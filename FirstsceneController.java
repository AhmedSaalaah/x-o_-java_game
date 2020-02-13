/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 package tictoef;


import javafx.scene.control.Button;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

    

public class FirstsceneController {   
  
  public  int verified=1;
    
    
    @FXML
    private Button signup;

    void initialize() {
        assert signup != null : "fx:id=\"signup\" was not injected: check your FXML file 'firstscene.fxml'.";

    }
    
    
      @FXML
      private void handlButtonAction (ActionEvent event) throws  IOException
   {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("registeration.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           
                app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
       
      
    }
      
       @FXML
      private void handlButtonAction1 (ActionEvent event) throws  IOException
   {
       if(verified==1)
       {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("homepage.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           
                app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
       }
      
    }
      

  
         

}