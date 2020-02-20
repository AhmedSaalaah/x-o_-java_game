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
public class LevelofOneplayerController implements Initializable {
 
    /**
     * Initializes the controller class.
     */
     @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
 @FXML
    private Button hard;

    @FXML
    private Button easy;

   
    
    @FXML
    void initialize() {
       
 assert hard != null : "fx:id=\"hard\" was not injected: check your FXML file 'levelof oneplayer.fxml'.";
        assert easy != null : "fx:id=\"easy\" was not injected: check your FXML file 'levelof oneplayer.fxml'.";
    }    
  

     
     @FXML
      private void sethard (ActionEvent event) throws  IOException
   {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("oneplayer.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           
                app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
       
      
    }
      
      
      @FXML
      private void seteasy (ActionEvent event) throws  IOException
   {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("oneplayer.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           
                app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
       
      
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
