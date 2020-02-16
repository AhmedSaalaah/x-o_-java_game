/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictoef;

import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
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

    @Override
  public  void start(Stage stage) throws IOException {
         FXMLLoader Loader =new FXMLLoader () ;
         Loader.setLocation(getClass().getResource("firstscene.fxml"));  
         Parent root = Loader.load();
         FirstsceneController FS =Loader.getController();
         Scene scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
         Socket client =new Socket("10.145.4.83",5005);
         DataInputStream dis=new DataInputStream(client.getInputStream());
         PrintStream ps =new PrintStream(client.getOutputStream());  
         FS.get_socket(dis, ps);
        
         /*****************new***********************/
         Loader.setLocation(getClass().getResource("registeration.fxml"));  
         RegisterationController RG =Loader.getController();
         RG.get_socket(dis, ps);

         
         
       
      new Thread(() -> {
        while(true){
            try {
                Gson g=new Gson();
		String string = dis.readLine();
                data p2=g.fromJson(string,data.class);
                System.out.println(p2.type);
                System.out.println(p2.sucess);   
            } catch (IOException ex) {
                Logger.getLogger(Tictoef.class.getName()).log(Level.SEVERE, null, ex);
            }}}).start();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       launch(args);

    }
    
   

    
    
    
    
    
    
    
    
}
