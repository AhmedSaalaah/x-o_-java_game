/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author M Gamal
 */
public class FXMLDocumentController implements Initializable {

    private Vector<Users> onlineUsers;
    public ObservableList<Users> users = FXCollections.observableArrayList();
    @FXML
    private TableView<Users> table;
    @FXML
    public TableColumn<Users, Integer> score;
    @FXML
    public TableColumn<Users, String> UserName;

    @FXML
    private Label label;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    Thread t;

    @FXML
    public void onclick(ActionEvent event) throws IOException {
        t = new Thread(() -> {
            try {
                Chat_server s = new Chat_server();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        t.start();
    }

    @FXML
    public void offclick(ActionEvent event) throws IOException {
        t.interrupt();
        t.stop();
        Platform.exit();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        score.setCellValueFactory(new PropertyValueFactory<>("Score"));
        UserName.setCellValueFactory(new PropertyValueFactory<>("UserName"));
        class select_all {
       public  Vector<Users> users() throws SQLException {
            connect con = new connect();
            Connection conn = con.establish();
            Vector<Users> list = new Vector<Users>();
            Statement select = conn.createStatement();

            ResultSet res = select.executeQuery("select* from users");
            ResultSetMetaData rsmd = res.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            //result of select *
            while (res.next()) {
                Users tem = new Users(res.getInt(4),res.getString(2));
                list.add(tem);
            }
            return list;

        }
           class connect {

        public Connection establish() {
            try {
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5544/java", "postgres", "mohamed");
                System.out.println("Connection sucess.");
                return connection;

            } catch (SQLException e) {
                System.out.println("Connection failure.");
                System.out.println(e);
            }
            return null;
        }
    }
    }
  select_all list=new select_all();
        try {
            Vector<Users> l=list.users();
            for(Users user : l)
        {
            users.add(user);
        }
        table.setItems(users); 
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
   
}
    

}
