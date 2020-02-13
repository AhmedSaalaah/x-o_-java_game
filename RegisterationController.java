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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class RegisterationController implements Initializable {

    public int  done=1;
    
    
    @FXML
    private Pane main;

    /**
     * Initializes the controller class.
     */
    
    
        @FXML
 private void handlButtonAction (ActionEvent event) throws  IOException

{
   if (done==1) 
   {
    Parent firsttime = FXMLLoader.load(getClass().getResource("homepage.fxml"));
        Scene firsttimescene = new Scene(firsttime);
        Stage app_stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
           
                app_stage1.hide(); //optional
                app_stage1.setScene(firsttimescene);
                app_stage1.show();  
       
   
   }
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
