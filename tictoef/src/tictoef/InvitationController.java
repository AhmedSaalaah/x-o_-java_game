/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictoef;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintStream;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author MohabOmar
 */
public class InvitationController implements Initializable {
    
    public static  PrintStream  psInvitation;
    @FXML
    private TextField inviter;
    @FXML
    private Button ok;
    @FXML
    private void accept(ActionEvent event) throws IOException
    {
        Parent home_page_parent1 = FXMLLoader.load(getClass().getResource("twoplayer.fxml"));
        Scene home_page_scene1 = new Scene(home_page_parent1);
        Stage app_stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage1.hide(); //optional
        app_stage1.setScene(home_page_scene1);
        app_stage1.show(); 
        data acceptance = new data();
        acceptance.type = "inviteaccept";
        acceptance.destination = Tictoef.opponent;
        Tictoef.whoX= Tictoef.opponent;
        Gson acceptMessege = new Gson();
        psInvitation.println(acceptMessege.toJson(acceptance));
    }
    @FXML
    private void notAccept(ActionEvent event) throws IOException
    {
        Parent home_page_parent1 = FXMLLoader.load(getClass().getResource("homepage.fxml"));
        Scene home_page_scene1 = new Scene(home_page_parent1);
        Stage app_stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage1.hide(); //optional
        app_stage1.setScene(home_page_scene1);
        app_stage1.show();         
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inviter.setText(Tictoef.opponent);
        psInvitation = Tictoef.ps;
        // TODO
    }    
    
}
