package tictoef;
import javafx.scene.control.PasswordField;
import java.net.URL;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.sql.SQLException;
import com.google.gson.Gson;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
public class FXMLDocumentController2 implements Initializable {
    
   dataBase data=new dataBase();
    public static void main(String[] args) {
    }
 dataBase b =new dataBase();
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button signup; 
    @FXML
    private Button login;
     @FXML
    void initialize() {
        username.clear();
        password.clear();
    }
     @FXML
    void signUp() throws SQLException{
        PreparedStatement stmt;
        stmt = b.conn.prepareStatement("insert into users values( ?, ?)");
        stmt.setString(2,username.getText());
        stmt.setString(3, password.getText());
        System.out.println(stmt.execute());
        initialize();
    } 
    void login()throws SQLException{
        PreparedStatement stmt,stmt2;
        stmt = b.conn.prepareStatement("select name from users where name=username.getText()");
        stmt2 = b.conn.prepareStatement("select password from users where name=username.getText()");
        if (stmt==null){
            System.out.println("incorrect username");
         }
        if (stmt2==null){
            System.out.println("incorrect password");
         }
        initialize();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
