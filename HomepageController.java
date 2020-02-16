/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictoef;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author marwa
 */
public class HomepageController implements Initializable {
 
    /**
     * Initializes the controller class.
     */
     @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button oneplayer;

    @FXML
    private Button setting;

    @FXML
    private Button exit;

    @FXML
    private Button twoplayer;
    
        @FXML
    private Label lab1;
    
    @FXML
    void initialize() {
        assert oneplayer != null : "fx:id=\"oneplayer\" was not injected: check your FXML file 'homepage.fxml'.";
        assert setting != null : "fx:id=\"setting\" was not injected: check your FXML file 'homepage.fxml'.";
        assert exit != null : "fx:id=\"exit\" was not injected: check your FXML file 'homepage.fxml'.";
        assert twoplayer != null : "fx:id=\"twoplayer\" was not injected: check your FXML file 'homepage.fxml'.";

    }    
   /*   @FXML
    public void passfun (String text )  {      
    lab1.setText(text);
} */

     
     @FXML
      private void handlButtonAction (ActionEvent event) throws  IOException
   {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("oneplayer.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           
                app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
       
      
    }
           @FXML
         private void handlButtonAction1 (ActionEvent event) throws  IOException
   {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("twoplayer.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           
                app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
       
      
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    
    
      
    
}



   

