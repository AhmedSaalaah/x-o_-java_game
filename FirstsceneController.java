/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 package tictoef;


import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.File;
import javafx.scene.control.Button;
import java.io.IOException;
import java.io.PrintStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

    

public class FirstsceneController {
    /*****music***/
   String path ="C:\\Users\\Acer\\Desktop\\tictoefclient2\\src\\tictoef\\Goofy-Mischief.mp3";
   Media media =new Media (new File (path).toURI().toString());
   MediaPlayer mediaplayer= new MediaPlayer (media);
   /**** music***/
    
    public DataInputStream dis;
    public PrintStream ps;
    void get_socket(DataInputStream diss,PrintStream pss){
    ps=pss;
    dis=diss;}
    
    
    void setalert()
     {
    Alert al =new Alert(Alert.AlertType.ERROR);
    al.setTitle("error");
    al.setContentText("The username or password is not correct");
    al.showAndWait();
     }
    
    
    
    
 
      @FXML
    private TextField username;

    @FXML
    private PasswordField password;
    @FXML
    private Button signup;
    
     @FXML
    private Button playvoice;

    @FXML
    private Button stopvoice;

    
    

    void initialize() {
        assert signup != null : "fx:id=\"signup\" was not injected: check your FXML file 'firstscene.fxml'.";
      
  
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
       ps.println(message);  
       
      
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
       ps.println(message);  
       
   
       
      }
      
    
      
      /*******music *///
      @FXML
      
       private void playmusic (ActionEvent event) throws  IOException
   {
    
       mediaplayer.play();
      
   
       
      
    }
      
       
          @FXML
      
       private void stopmusic (ActionEvent event) throws  IOException
   {
    
       mediaplayer.pause();
      
   
       
      
    }

  
}     

