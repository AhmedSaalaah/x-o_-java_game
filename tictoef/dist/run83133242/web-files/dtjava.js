/*
 * Copyright (c) 2006, 2016, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
  The Java Deployment Toolkit is a utility to deploy Java content in
  the browser as applets or applications using the right version of Java.
  If needed it can initiate an upgrade of user's system to install required
  components of Java platform.
  <p>
  Note that some of the Deployment Toolkit methods may not be fully operational if
  used before web page body is loaded (because DT native plugins could not be instantiated).
  If you intend to use it before web page DOM tree is ready then dtjava.js
  needs to be loaded inside the body element of the page and before use of other DT APIs.

  @module java/deployment_toolkit
*/
var dtjava = function() {
    function notNull(o) {
        return (o != undefined && o != null);
    }

    function isDef(fn) {
        return (fn != null && typeof fn != "undefined");
    }

    //return true if any of patterns from query list is found in the given string
    function containsAny(lst, str) {
        for (var q = 0; q < lst.length; q++) {
            if (str.indexOf(lst[q]) != -1) {
                return true;
            }
        }
        return false;
    }

    /* Location of static web content - images, javascript files. */
    var jscodebase =  (function () {
        // <script> elements are added to the DOM and run synchronously,
        // the currently running script will also be the last element in the array
        var scripts = document.getElementsByTagName("script");
        var src = scripts[scripts.length - 1].getAttribute("src");
        return src ? src.substring(0, src.lastIndexOf('/') + 1) : "";
    })();

    //set to true to disable FX auto install (before release)
    var noFXAutoInstall = false;

    // page has no body yet, postpone plugin installation
    postponeNativePluginInstallation = false;

    // JRE version we start to have JRE and FX true co-bundle
    var minJRECobundleVersion = "1.7.0_06";

    //aliases
    var d = document;
    var w = window;

    var cbDone = false;  //done with onload callbacks
    var domInternalCb = []; //list of internal callbacks
    var domCb = [];      //list of callbacks
    var ua = null;


    // Add internal function to be called on DOM ready event.
    // These functions will be called before functions added by addOnDomReady().
    // Used to do internal initialization (installing native plug-in) to avoid
    // race condition with user requests.
    function addOnDomReadyInternal(fn) {
        if (cbDone) {
            fn();
        } else {
            domInternalCb[domInternalCb.length] = fn;
        }
    }

    // add function to be called on DOM ready event
    function addOnDomReady(fn) {
        if (cbDone) {
            fn();
        } else {
            domCb[domCb.length] = fn;
        }
    }

    //invoke pending onload callbacks
    function invokeCallbacks() {
        if (!cbDone) {
            //swfoject.js tests whether DOM is actually ready first
            //  in order to not fire too early. Use same heuristic
            try {
                var t = d.getElementsByTagName("body")[0].appendChild(
                    d.createElement("div"));
                t.parentNode.removeChild(t);
            } catch (e) {
                return;
            }
            cbDone = true;
            for (var i = 0; i < domInternalCb.length; i++) {
                domInternalCb[i]();
            }
            for (var i = 0; i < domCb.length; i++) {
                domCb[i]();
            }
        }
    }

    //cross browser onload support.
    //Derived from swfobject.js
    function addOnload(fn) {
        if (isDef(w.addEventListener)) {
            w.addEventListener("load", fn, false);
        } else if (isDef(d.addEventListener)) {
            d.addEventListener("load", fn, false);
        } else if (isDef(w.attachEvent)) {
            w.attachEvent("onload", fn);
            //TODO: swfobject also keeps references to the listeners to detach them on onload
            // to avoid memory leaks ...
        } else if (typeof w.onload == "function") {
            var fnOld = w.onload;
            w.onload = function() {
                fnOld();
                fn();
            };
        } else {
            w.onload = fn;
        }
    }

    function detectEnv() {
        var dom = isDef(d.getElementById) && isDef(d.getElementsByTagName) && isDef(d.createElement);
        var u = navigator.userAgent.toLowerCase(),
            p = navigator.platform.toLowerCase();

        //NB: may need to be refined as some user agent may contain strings related to other browsers
        //   (e.g. Chrome has both Safari and mozilla, Safari also has mozilla
        var windows = p ? /win/.test(p) : /win/.test(u),
            mac = p ? /mac/.test(p) : /mac/.test(u),
            linux = p ? /linux/.test(p) : /linux/.test(u),
            chrome = /chrome/.test(u),
            // get webkit version or false if not webkit
            webkit = !chrome && /webkit/.test(u) ?
                parseFloat(u.replace(/^.*webkit\/(\d+(\.\d+)?).*$/, "$1")) : false,
            opera = /opera/.test(u),
            cputype = null,
            osVersion = null;

        var ie = false;
        try {
            //Used to be using trick from
            //  http://webreflection.blogspot.com/2009/01/32-bytes-to-know-if-your-browser-is-ie.html
            //ie = !+"\v1",
            //but it does not work with IE9 in standards mode
            //Reverting to alternative - use execScript
            ie = isDef(window.execScript);
            // IE 11 does not support execScript any more and no exception is thrown, so lets use more naive test.
            // http://msdn.microsoft.com/en-us/library/ie/bg182625(v=vs.85).aspx
            if (!ie) { // We do not want to overwrite if ie was detected above.
                ie = (navigator.userAgent.match(/Trident/i) != null);
            }
        } catch (ee) {
            //if javafx app is in the iframe and content of main window is coming from other domain
            //  then some browsers may restrict access to outer window properties,
            //  e.g. FF can throw exception for top.execScript (see RT-17885)
            //We could revert to more naive test, e.g. test user agent for "MSIE " string
            // but so far IE does not seem to throw exception => if we get here it is not IE anyways
            ie = false;
        }

        var edge = false;
        var noActiveX = false;
        edge = (navigator.userAgent.match(/Edge/i) != null);
        
        // If IE and Windows 8 or Windows 8.1 then check for Metro mode
        if(ie && navigator.userAgent.match(/Windows NT 6\.[23]/i) != null) {
            try {
                // try to create a known ActiveX object
                new ActiveXObject("htmlfile");
            } catch(e) {
		// ActiveX is disabled or not supported. 
                noActiveX = true;
            } 
        }

        if(edge || noActiveX) {
            ie = false;
	}

	var noPluginWebBrowser = edge || chrome || noActiveX;

        //we are not required to detect everything and can leave values null as
        // long as we later treat them accordingly.
        //We use "cputype" to detect if given hardware is supported,
        // e.g. we do not support PPC or iPhone/iPad despite they are running Mac OS
        //We use "osVersion" to detect if Java/JavaFX can be installed on this OS
        // e.g. Oracle Java for Mac requires 10.7.3
        if (mac) {
            if ((p && /intel/.test(p)) || /intel/.test(u)) {
                cputype = "intel";
            }
            //looking for things like 10_7, 10_6_8, 10.4 in the user agent
            var t = u.match(/mac os x (10[0-9_\.]+)/);
            //normalize to "." separators
            osVersion = notNull(t) ? t[0].replace("mac os x ","").replace(/_/g, ".") : null;
        }

        // trim() is not supported by IE10 and before
        if(typeof String.prototype.trim !== 'function') {
           String.prototype.trim = function() {
               return this.replace(/^\s+|\s+$/g, ''); 
           }
        }

        // startsWith() is not supported by IE
        if(typeof String.prototype.startsWith !== 'function') {
           String.prototype.startsWith = function(searchString, position) {
               position = position || 0;
               return this.indexOf(searchString, position) === position;
           }
        }


        // Check mime types. Works with netscape family browsers and checks latest installed plugin only
        var mm = navigator.mimeTypes;
        var jre = null;
        var deploy = null;
        var fx = null;
        var override = false;

        if (typeof __dtjavaTestHook__ !== 'undefined' &&
            __dtjavaTestHook__ != null &&
            __dtjavaTestHook__.jre != null &&
            __dtjavaTestHook__.jfx != null &&
            __dtjavaTestHook__.deploy != null) {
            jre = __dtjavaTestHook__.jre;
            deploy = __dtjavaTestHook__.deploy;
            fx = __dtjavaTestHook__.jfx;
            override = true;
        }
        else {
            //Cache configuration from plugin mimetypes
            //It is only available for NPAPI browsers
            for (var t = 0; t < mm.length; t++) {
                // The jpi-version is the JRE version.
                var m = navigator.mimeTypes[t].type;
                if (m.indexOf("application/x-java-applet;version") != -1 && m.indexOf('=') != -1) {
                    var v = m.substring(m.indexOf('=') + 1);
                    // Use the existing version comparison mechanism to ensure that
                    // the latest JRE is selected ( "versionA"<="VersionB" equals to 
                    // versionCheck("versionA+","versionB") returns "true")
                    if(jre == null || versionCheck(jre + "+", v)){
			jre = v;
	            }
                }
                //Supported for 7u6 or later
                if (m.indexOf("application/x-java-applet;deploy") != -1 && m.indexOf('=') != -1) {
                    deploy = m.substring(m.indexOf('=') + 1);
                }
                //javafx version for cobundled javafx (7u6+)
                if (m.indexOf("application/x-java-applet;javafx") != -1 && m.indexOf('=') != -1) {
                    fx = m.substring(m.indexOf('=') + 1);
                }
            }
        }
		
        return {haveDom:dom, wk:webkit, ie:ie, win:windows,
                linux:linux, mac:mac, op: opera, chrome:chrome, edge:edge,
                jre:jre, deploy:deploy, fx:fx, noPluginWebBrowser:noPluginWebBrowser,
                cputype: cputype, osVersion: osVersion, override: override};
    }

   function showMessageBox() {
        var message = 'Java Plug-in is not supported by this browser. <a href="https://java.com/dt-redirect">More info</a>';
        var mbStyle = 'background-color: #ffffce;text-align: left;border: solid 1px #f0c000; padding: 1.65em 1.65em .75em 0.5em; font-family: Helvetica, Arial, sans-serif; font-size: 75%; top:5;left:5;position:absolute; opacity:0.9; width:600px;';
        var messageStyle = "border: .85px; margin:-2.2em 0 0.55em 2.5em;";

        var messageBox = '<img src="https://java.com/js/alert_16.png"><div style="'+ messageStyle +'"><p>'+ message + '</p>';


        var divTag = document.createElement("div");
        divTag.id = "messagebox";
        divTag.setAttribute('style', mbStyle);
        divTag.innerHTML = messageBox;
        document.body.appendChild(divTag);              

    }
    //partially derived from swfobject.js
    var initDone = false;

    function init() {
        if (typeof __dtjavaTestHook__ !== 'undefined') {
          jre = null;
          jfx = null;
          deploy = null;

          if ((__dtjavaTestHook__ != null) && (__dtjavaTestHook__.args != null)) {
              jre = __dtjavaTestHook__.args.jre;
              jfx = __dtjavaTestHook__.args.jfx;
              deploy = __dtjavaTestHook__.args.deploy;
          }

          if ((window.location.href.indexOf('http://localhost') == 0) ||
             (window.location.href.indexOf('file:///') == 0)) {
             __dtjavaTestHook__ = {
                detectEnv: detectEnv,
                Version: Version,
                checkFXSupport: checkFXSupport,
                versionCheck: versionCheck,
                versionCheckFX: versionCheckFX,
                jre: jre,
                jfx: jfx,
                deploy: deploy
             };
          }
        }

        if (initDone) return;

        ua = detectEnv();
        if (!ua.haveDom) {
            return;
        }

        //NB: dtjava.js can be added dynamically and init() can be called after
        //    document onload event is fired
        if (( isDef(d.readyState) && d.readyState == "complete") ||
            (!isDef(d.readyState) &&
                (d.getElementsByTagName("body")[0] || d.body))) {
            invokeCallbacks();
        }

        if (!cbDone) {
            if (isDef(d.addEventListener)) {
                d.addEventListener("DOMContentLoaded",
                    invokeCallbacks, false);
            }
            if (ua.ie && ua.win) {
                // http://msdn.microsoft.com/en-us/library/ie/ms536343(v=vs.85).aspx
                // attachEvent is not supported by IE 11.
                if (isDef(d.addEventListener)) {
                    d.addEventListener("onreadystatechange", function() {
                        if (d.readyState == "complete") {
                            d.removeEventListener("onreadystatechange", arguments.callee, false);
                            invokeCallbacks();
                        }
                    }, false);
                } else {
                    d.attachEvent("onreadystatechange", function() {
                        if (d.readyState == "complete") {
                            d.detachEvent("onreadystatechange", arguments.callee);
                            invokeCallbacks();
                        }
                    });
                }
                if (w == top) { // if not inside an iframe
                    (function() {
                        if (cbDone) {
                            return;
                        }
                        //AI: what for??
                        try {
                            d.documentElement.doScroll("left");
                        } catch(e) {
                            setTimeout(arguments.callee, 0);
                            return;
                        }
                        invokeCallbacks();
                    })();
                }
            }
            if (ua.wk) {
                (function() {
                    if (cbDone) {
                        return;
                    }
                    if (!/loaded|complete/.test(d.readyState)) {
                        setTimeout(arguments.callee, 0);
                        return;
                    }
                    invokeCallbacks();
                })();
            }
            addOnload(invokeCallbacks);
        }
        //only try to install native plugin if we do not have DTLite
        //Practically this means we are running NPAPI browser on Windows
        //(Chrome or FF) and recent JRE (7u4+?)
        if (!haveDTLite()) {
            installNativePlugin();
        }
    }
    
   function getAbsoluteUrl(jnlp){
        var absoluteUrl;
        if(isAbsoluteUrl(jnlp)) {
            absoluteUrl = jnlp;
        } else {
            var location = window.location.href;
            var pos = location.lastIndexOf('/');
            var docbase =  pos > -1 ? location.substring(0, pos + 1) : location + '/';
	    absoluteUrl = docbase + jnlp;
        }
        return absoluteUrl;
    }

    function launchWithJnlpProtocol(jnlp) {
        document.location="jnlp:"+ getAbsoluteUrl(jnlp);
    }
  

    function isAbsoluteUrl(url){
       var protocols = ["http://", "https://", "file://"];
       for (var i=0; i < protocols.length; i++){
         if(url.toLowerCase().startsWith(protocols[i])){
         	return true;;
	 }
       }
       return false;
     }


    /**
     This class provides details on why current platform does not meet
     application platform requirements. Note that severe problems are
     reported immediately and therefore full check may be not performed and
     some (unrelated to fatal problem)
     methods may provide false positive answers.
     <p>
     If multiple components do not match then worst status is reported.
     Application need to repeat checks on each individual component
     if it want to find out all details.

     @class PlatformMismatchEvent
     @for   dtjava
     */
    function PlatformMismatchEvent(a) {

        //expect to get all parameters needed
        for (var p in a) {
            this[p] = a[p];
        }

        /**
         * @method toString
         * @return {string}
         *    Returns string replesentation of event. Useful for debugging.
         */
        this.toString = function() {
            return "MISMATCH [os=" + this.os + ", browser=" + this.browser
                + ", jre=" + this.jre + ", fx=" + this.fx
                + ", relaunch=" + this.relaunch + ", platform="
                + this.platform + "]";
        };

        /**
         @method isUnsupportedPlatform
         @return {boolean}
         Returns true if this platform (OS/hardware) is not supported in a way
         to satisfy all platfrom requirements.
         (E.g. page is viewed on iPhone or JavaFX 2.0 application on Solaris.)
         <p>
         Note that this does not include browser match data.
         If platform is unsupported then application can not be
         launched and user need to use another platform to view it.
         */

        this.isUnsupportedPlatform = function() {
            return this.os;
        };

        /**
         @method isUnsupportedBrowser
         @return {boolean}
         Returns true if error is because current browser is not supported.
         <p>
         If true is returned and isRelaunchNeeded() returns true too then
         there are known supported browsers browsers for this platform.
         (but they are not necessary installed on end user system)
         */
        this.isUnsupportedBrowser = function() {
            return this.browser;
        };

        /**
         @method jreStatus
         @return {string}

         Returns "ok" if error was not due to missing JRE.
         Otherwise return error code characterizing the problem:
         <ul>
         <li> none - no JRE were detected on the system
         <li> old - some version of JRE was detected but it does not match platform requirements
         <li> oldplugin - matching JRE found but it is configured to use deprecated Java plugin that
         does not support Java applets
         <ul>
         <p>
         canAutoInstall() and isRelaunchNeeded() can be used to
         get more details on how seamless user' install experience will be.
         */
        this.jreStatus = function() {
            return this.jre;
        };

        /**
         * @method jreInstallerURL
         * @param {string} locale (optional) Locale to be used for installation web page
         * @return {string}
         *
         * Return URL of page to visit to install required version of Java.
         * If matching java runtime is already installed or not officially supported
         * then return value is null.
         */
        this.jreInstallerURL = function(locale) {
            if (!this.os && (this.jre == "old" || this.jre == "none")) {
                return getJreUrl(locale);
            }
            return null;
        };

        /**
         @method javafxStatus
         @return {string}

         Returns "ok" if error was not due to missing JavaFX.
         Otherwise return error code characterizing the problem:
         <ul>
         <li> none - no JavaFX runtime is detected on the system
         <li> old - some version of JavaFX runtime iss detected but it does not match platform requirements
         <li> disabled - matching JavaFX is detected but it is disabled
         <li> unsupported - JavaFX is not supported on this platform
         <ul>
         <p>
         canAutoInstall() and isRelaunchNeeded() can be used to
         get more details on how seamless user' install experience will be.
         */
        this.javafxStatus = function() {
            return this.fx;
        };

        /**
         * @method javafxInstallerURL
         * @param {string} locale (optional) Locale to be used for installation web page
         * @return {string}
         *
         * Return URL of page to visit to install required version of JavaFX.
         * If matching JavaFX runtime is already installed or not officially supported
         * then return value is null.
         */
        this.javafxInstallerURL = function(locale) {
            if (!this.os && (this.fx == "old" || this.fx == "none")) {
                return getFxUrl(locale);
            }
            return null;
        };

        /**
         @method canAutoInstall
         @return {boolean}
         Returns true if installation of missing components can be
         triggered automatically. In particular, ture is returned
         if there are no missing components too.
         <p>
         If any of missing components need to be installed manually
         (i.e. click through additional web pages) then false is returned.
         */
        this.canAutoInstall = function() {
            return isAutoInstallEnabled(this.platform, this.jre, this.fx);
        };

        /**
         @method isRelaunchNeeded
         @return {boolean}

         Returns true if browser relaunch is needed before application can be loaded.
         This often is true in conjuction with need to perform installation.
         <p>
         Other typical case - use of unsupported browser when
         it is known that there are supported browser for this pltaform.
         Then both isUnsupportedBrowser() and isRelaunchNeeded() return true.
         */
        this.isRelaunchNeeded = function() {
            return this.relaunch;
        };
    }

    //returns version of instaled JavaFX runtime matching requested version
    //or null otherwise
    function getInstalledFXVersion(requestedVersion) {
        //NPAPI browser and JRE with cobundle
        if (ua.fx != null && versionCheckFX(requestedVersion, ua.fx)) {
            return ua.fx;
        }
        //try to use DT
        var p = getPlugin();
        if (notNull(p)) {
            try {
                return p.getInstalledFXVersion(requestedVersion);
            } catch(e) {}
        }
        return null;
    }

    //concatenate list with space as separator
    function listToString(lst) {
      if (lst != null) {
          return lst.join(" ");
      } else {
          return null;
      }
    }

    function addArgToList(lst, arg) {
        if (notNull(lst)) {
           lst.push(arg);
           return lst;
        } else {
            var res = [arg];
            return res;
        }
    }

    function doLaunch(ld, platform, cb) {
        var app = normalizeApp(ld, true);
        if(ua.noPluginWebBrowser){
            launchWithJnlpProtocol(app.url);
            return;
	}

        //required argument is missing
        if (!(notNull(app) && notNull(app.url))) {
            throw "Required attribute missing! (application url need to be specified)";
        }

        //if we got array we need to copy over!
        platform = new dtjava.Platform(platform);

        //normalize handlers
        cb = new dtjava.Callbacks(cb);

        var launchFunc = function() {
            //prepare jvm arguments
            var jvmArgs = notNull(platform.jvmargs) ? platform.jvmargs : null;
            if (notNull(platform.javafx)) {
                //if FX is needed we know it is available or
                // we will not get here
                var v = getInstalledFXVersion(platform.javafx);
                //add hint that we need FX toolkit to avoid relaunch
                // if JNLP is not embedded
                jvmArgs = addArgToList(jvmArgs, " -Djnlp.fx=" + v);
                //for swing applications embedding FX we do not want this property as it will
                // trigger FX toolkit and lead to app failure!
                //But for JavaFX application it saves us relaunch as otherwise we wil launch with AWT toolkit ...
                if (!notNull(ld.toolkit) || ld.toolkit == "fx") {
                    jvmArgs = addArgToList(jvmArgs, " -Djnlp.tk=jfx");
                }

            }


            //if we on 7u6+ we can use DTLite plugin in the NPAPI browsers
            //Caveat: as of 7u6 it does not work with Chrome on Linux because Chrome expects
            //   DTLite plugin to implement xembed (or claim to support xembed)
            if (haveDTLite() && !(ua.linux && ua.chrome)) {
                if (doLaunchUsingDTLite(app, jvmArgs, cb)) {
                    return;
                }
            }

            //Did not launch yet? Try DT plugin (7u2+)
            var p =  getPlugin();
            if (notNull(p)) {
                try {
                    try {
                        //check if new DT APIs are available
                        if (versionCheck("10.6+", ua.deploy, false)) {
                            //    obj.launchApp({"url" : "http://somewhere/my.jnlp",
                            //                   "jnlp_content" : "... BASE 64 ...",
                            //                   "vmargs" : [ "-ea -Djnlp.foo=bar"
                            //                   "appargs" : [ "first arg,  second arg" ]
                            //                   "params" : {"p1" : "aaa", "p2" : "bbb"}});
                            var callArgs = {"url":app.url};
                            if (notNull(jvmArgs)) {
                                callArgs["vmargs"] = jvmArgs;
                            }
                            //Only use HTML parameters, they are supposed to overwrite values in the JNLP
                            //In the future we want to pass arguments too but this needs also be exposed for
                            // embedded deployment
                            if (notNull(app.params)) {
                                //copy over and ensure all values are strings
                                // (native code will ignore them otherwise)
                                var ptmp = {};
                                for (var k in app.params) {
                                    ptmp[k] = String(app.params[k]);
                                }
                                callArgs["params"] = ptmp;
                            }
                            if (notNull(app.jnlp_content)) {
                                callArgs["jnlp_content"] = app.jnlp_content;
                            }
                            var err = p