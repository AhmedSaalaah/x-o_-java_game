/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictoef;

import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;

import java.io.IOException;
import javafx.application.Platform;
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
FXMLDocumentController FX;
    @Override
  public  void start(Stage stage) throws IOException {
         FXMLLoader Loader =new FXMLLoader () ;
         FXMLLoader Loader_game =new FXMLLoader () ;
         Loader_game.setLocation(getClass().getResource("twoplayer.fxml"));
         Loader.setLocation(getClass().getResource("firstscene.fxml"));  
         Parent root = Loader.load();
         Parent root_1 = Loader_game.load();
         FirstsceneController FS =Loader.getController();
         FXMLDocumentController FX =Loader_game.getController();        
         Scene scene_1 = new Scene(root_1);
         Scene scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
         Socket client =new Socket("10.145.83.4",5005);
         DataInputStream dis=new DataInputStream(client.getInputStream());
         PrintStream ps =new PrintStream(client.getOutputStream());  
         FX.get_socket(dis, ps);
         FS.get_socket(dis, ps);
//         FX.get_socket(dis, ps);

        
       
         
         
       
      new Thread(() -> {
        while(true){
            try {
                Gson g=new Gson();
		String string = dis.readLine();
                data p2=g.fromJson(string,data.class);
                System.out.println(p2.type);
                System.out.println(p2.sucess);
                execute(string,stage);
                
                
            } 
            catch (IOException ex) {
                Logger.getLogger(Tictoef.class.getName()).log(Level.SEVERE, null, ex);
            }}}).start();
        
    }
  void execute(String s,Stage s_1) throws IOException{
  
     Gson g=new Gson();
      data p2=g.fromJson(s,data.class);
      if(p2.type.equals("update")){
     FX.update_board(p2.array);     
      }
      
  if(p2.type.equals("inviteaccept")){
    set_names(p2.opposit, p2.user_name);}

  if (p2.type.equals("login")){
  if (p2.sucess==1){
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
  

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       launch(args);

    }
    
   

    
    
    
    
    
    
    
    
}
