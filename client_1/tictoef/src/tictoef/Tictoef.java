/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictoef;

import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.File;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import java.io.IOException;
import java.net.URL;
import java.util.Vector;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 *
 * @author marwa
 */
public class Tictoef extends Application {

  
public static DataInputStream dis;
public static  PrintStream  ps;
//public FXMLDocumentController game ;
 public int fe =1;
 Scene scene_1;

 public boolean errorFlag = false;
public  FXMLDocumentController FX;

private static Vector<Users> online;
private static String userName;
public static String opponent;
public static String whoX;
    @Override
  public  void start(Stage stage) throws IOException {



    
        FXMLLoader Loader =new FXMLLoader () ;
         FXMLLoader Loader_game =new FXMLLoader () ;
         Loader_game.setLocation(getClass().getResource("twoplayer.fxml"));
         Loader.setLocation(getClass().getResource("firstscene.fxml"));  
         Parent root = Loader.load();
         Parent root_1 = Loader_game.load();
         FirstsceneController FS =Loader.getController();
         FX=Loader_game.getController();
         /////////////////////////////////////////////////

         
         //////////////////////////////////////////////////////
//         FXMLDocumentController FX =Loader_game.getController();        
          scene_1 = new Scene(root_1);
         Scene scene = new Scene(root);
         stage.setScene(scene);
         stage.setTitle("Tic Tac Toe");
         stage.show();
         try{
         Socket client =new Socket("127.0.0.1",5005);
         dis = new DataInputStream(client.getInputStream());
         ps = new PrintStream(client.getOutputStream());  
         FX.get_socket(dis, ps);
         FS.get_socket(dis, ps);

      new Thread(() -> {
        while(true){
            try {
               Gson g=new Gson();
		String string = dis.readLine();
                data p2=g.fromJson(string,data.class);
                Platform.runLater(() -> {
            if(p2.type.equals("online_players")){
                online = p2.clientsVector; 
      }
      if(p2.type.equals("update")){
          Platform.runLater(() -> {FX.set(string);
          stage.setScene(scene_1);
          stage.show();
          });
      }});
                    try {
                        execute(string,stage,FX);
                    } catch (IOException ex) {
                        try {
                             client.close();
                            dis.close();
                            this.stop();
                        } catch (IOException ex1) {
                            try { client.close();
                                this.stop();
                            } catch (Exception ex2) {
                                try {
                                    this.stop();
                                    client.close();
                                } catch (IOException ex3) {
                                    Logger.getLogger(Tictoef.class.getName()).log(Level.SEVERE, null, ex3);
                                } catch (Exception ex3) {
                                    Logger.getLogger(Tictoef.class.getName()).log(Level.SEVERE, null, ex3);
                                }
                                Logger.getLogger(Tictoef.class.getName()).log(Level.SEVERE, null, ex2);
                            }
                            Logger.getLogger(Tictoef.class.getName()).log(Level.SEVERE, null, ex1);
                        } catch (Exception ex1) {
                            try {
                                client.close();
                            } catch (IOException ex2) {
                                Logger.getLogger(Tictoef.class.getName()).log(Level.SEVERE, null, ex2);
                            }
                            Logger.getLogger(Tictoef.class.getName()).log(Level.SEVERE, null, ex1);
                        }
                        try {
                            client.close();
                        } catch (IOException ex1) {
                            try {
                                this.stop();
                            } catch (Exception ex2) {
                                Logger.getLogger(Tictoef.class.getName()).log(Level.SEVERE, null, ex2);
                            }
                            Logger.getLogger(Tictoef.class.getName()).log(Level.SEVERE, null, ex1);
                        }
                ps.close();}
//                    }});
  
            } 
            catch (IOException ex) {
                Logger.getLogger(Tictoef.class.getName()).log(Level.SEVERE, null, ex);
            }}}).start();
       }
         catch(IOException e){
             System.out.println("server down");
         }
        
    }
  
  public static Vector getOnlinePlayers ()
  {
      return online;
  }
  public DataInputStream getDis()
  {
      return dis;
  }
  public PrintStream getPs()
  {
      return ps;
  }


  void execute(String s,Stage s_1,FXMLDocumentController w) throws IOException{
  
     Gson g=new Gson();
      data p2=g.fromJson(s,data.class);
//      if(p2.type.equals("update")){
////          w.update_board(s);
//         Platform.runLater(() -> {w.update_board(s);});
//      }
      if(p2.type.equals("inviteaccept"))
      {
          if(p2.sucess==1)
          {
            Platform.runLater(() -> {
                 FXMLLoader LoaderInvite =new FXMLLoader () ;
          LoaderInvite.setLocation(getClass().getResource("twoplayer.fxml"));  
               InvitationController invitation =LoaderInvite.getController();
               Parent root;
          try {
              root = LoaderInvite.load();
               Scene scene = new Scene(root);
                s_1.setScene(scene);
            s_1.show();
          } catch (IOException ex) {
              Logger.getLogger(Tictoef.class.getName()).log(Level.SEVERE, null, ex);


          }
              
           });
          }
      }
  if(p2.type.equals("error can't access to palyer")){
      System.out.println("error can't access to another palyer");}
  if(p2.type.equals("invite"))
  {
      opponent = p2.user_name;
            Platform.runLater(() -> {
                 FXMLLoader LoaderInvite =new FXMLLoader () ;
          LoaderInvite.setLocation(getClass().getResource("invitation.fxml"));  
               InvitationController invitation =LoaderInvite.getController();
               Parent root;
          try {
              root = LoaderInvite.load();
               Scene scene = new Scene(root);
                s_1.setScene(scene);
            s_1.show();
          } catch (IOException ex) {
              Logger.getLogger(Tictoef.class.getName()).log(Level.SEVERE, null, ex);


          }
              
           });
      
  }
  if (p2.type.equals("login")){
  if (p2.sucess==1){
      userName = p2.user_name;
      Platform.runLater(() -> {
                 FXMLLoader Loader_1 =new FXMLLoader () ;
          Loader_1.setLocation(getClass().getResource("homepage.fxml"));  
               HomepageController hp =Loader_1.getController();
               Parent root;
          try {
              root = Loader_1.load();
               Scene scene = new Scene(root);
                s_1.setScene(scene);
            s_1.show();
          } catch (IOException ex) {
              Logger.getLogger(Tictoef.class.getName()).log(Level.SEVERE, null, ex);


          }
              
           });
                }
                 

                
                }
  }

  
  void set_names(String my_name,String opposit){

  }
  public static String getUserName()
  {
      return userName;
  }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       launch(args);

    }
    @Override
    public void stop()
    {
        System.exit(0);
    }
}
