/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictoef;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 *
 * @author Acer
 */
public class Tictoef extends Application {
  
    MediaPlayer mediaplayer ;
  

    @Override
  public  void start(Stage stage) throws IOException {
          
     /* Media musicfile =new Media ("file:\\C:\\Users\\Acer\\Desktop\\java labs\\tictoef\\src\\tictoef\\Goofy-Mischief.mp3");
     mediaplayer =new  MediaPlayer(musicfile) ;
      mediaplayer.setAutoPlay(true);
      mediaplayer.setVolume(0.1);*/
      
        Parent root = FXMLLoader.load(getClass().getResource("firstscene.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       launch(args);
    }
    
   

    
    
    
    
    
    
    
    
}
