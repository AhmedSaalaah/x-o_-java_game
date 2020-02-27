/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 package tictoef;


import com.google.gson.Gson;
import java.io.DataInputStream;
import javafx.scene.control.Button;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

    

public class FirstsceneController {
    public DataInputStream dis;
    public PrintStream ps;
    void get_socket(DataInputStream diss,PrintStream pss){
    ps=pss;
    dis=diss;}

    
    //flag shows that the  login operation success 
    //this flag come from server and data base
  public  int verified=1;
  Tictoef tf = new Tictoef ();

    
      @FXML
    private TextField username;

    @FXML
    private PasswordField password;
    @FXML
    private Button signup;
    @FXML
            public TextField error1;
    @FXML 
            private TextField error2;
    

    
    

    void initialize() {
        assert signup != null : "fx:id=\"signup\" was not injected: check your FXML file 'firstscene.fxml'.";
        error1.setVisible(false);
        error2.setVisible(false);
    }
    /*signup button */
      @FXML
      private void handlButtonAction (ActionEvent event) throws  IOException
   {
     
       data d=new data();
       d.type="signup";
       d.user_name=username.getText();
       d.password=password.getText();
       Gson g=new Gson();
       String message=g.toJson(d);
       if((username.getText().equals("") | password.getText().equals(""))){
           System.out.println("invalid input");
           error2.setVisible(true);
           
    } else {
           try{
               ps.println(message);  }
           catch(Exception e){
               System.out.println("server down");
           }}
   }
      
     //login button 
       @FXML
      private void handlButtonAction1 (ActionEvent event) throws  IOException
   {
    
       data d=new data();
       d.type="login";      d.user_name=username.getText();
       d.password=password.getText();
       Gson g=new Gson();
       String message=g.toJson(d);
            if((username.getText().equals("") | password.getText().equals("")))
            {
           System.out.println("invalid input");
           error2.setVisible(true);          
            }

 
            else {
           try{
               ps.println(message);
           }
           catch(Exception e){
               System.out.println("server down");

           }


            }
            

            

       
      }
       
       
           
       
       
       
       
          
      
   
       
      
    }
      

  
         

