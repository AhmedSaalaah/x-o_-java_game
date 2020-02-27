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
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class TablesceneController implements Initializable {

    private Vector<Users> onlineUsers;
    public ObservableList<Users> users = FXCollections.observableArrayList();
    private static Users player;
    public static DataInputStream disTable;
    public static  PrintStream  psTable;
    public static String myName;
    
    public void setDisPs(DataInputStream  _dis, PrintStream  _ps)
    {
        disTable = _dis;
        psTable = _ps;
    }
    
    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TableView<Users> table; 
    @FXML
    public TableColumn<Users, Integer> score;
    @FXML
    public TableColumn<Users, String> UserName;    
    @FXML
    private Button invite_button;
    @FXML
    private Button mainMenu;

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        score.setCellValueFactory(new PropertyValueFactory<>("Score"));
        UserName.setCellValueFactory(new PropertyValueFactory<>("UserName"));
        onlineUsers = Tictoef.getOnlinePlayers();
        myName = Tictoef.getUserName();
        psTable = Tictoef.ps;
        for(Users user : onlineUsers)
        {
            users.add(user);
        }
        table.setItems(users);       
       }
    
    @FXML
    public void selectPlayer(MouseEvent event)
    {
        player = table.getSelectionModel().getSelectedItem();
    }
    public static Users getPlayer()
    {
        return player;
    }
    @FXML
    private void goToHomePage(ActionEvent event) throws IOException
    {
        Parent home_page_parent1 = FXMLLoader.load(getClass().getResource("homepage.fxml"));
        Scene home_page_scene1 = new Scene(home_page_parent1);
        Stage app_stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage1.hide(); //optional
        app_stage1.setScene(home_page_scene1);
        app_stage1.show();        
    }
    @FXML
   private void settwoplayer (ActionEvent event) throws  IOException
   {
        Parent home_page_parent1 = FXMLLoader.load(getClass().getResource("twoplayer.fxml"));
        Scene home_page_scene1 = new Scene(home_page_parent1);
        Stage app_stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage1.hide(); //optional
        app_stage1.setScene(home_page_scene1);
        app_stage1.show();
   }
     @FXML
   private void invite (ActionEvent event) throws  IOException
           
   {
       data invitation = new data();
       invitation.user_name = myName;
       invitation.type = "invite";
       invitation.destination = player.getUserName();
       Tictoef.opponent=player.getUserName();
       Tictoef.whoX = myName;
       Gson temp = new Gson();
       Tictoef main = new Tictoef();
       psTable.println(temp.toJson(invitation));     
   }
  
}
