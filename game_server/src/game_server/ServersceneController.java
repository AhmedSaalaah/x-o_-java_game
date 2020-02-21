/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_server;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Acer
 */





public class ServersceneController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button off;

    @FXML
    private Button on;

    @FXML
    void initialize() {
        assert off != null : "fx:id=\"off\" was not injected: check your FXML file 'serverscene.fxml'.";
        assert on != null : "fx:id=\"on\" was not injected: check your FXML file 'serverscene.fxml'.";

    } 
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    
    @FXML
    public void onclick (ActionEvent event) throws  IOException{
    
    
    
    }
    
     @FXML
    public void offclick (ActionEvent event) throws  IOException{
    
    
    
    }
    
    
    
    
    
    
    
    
}
