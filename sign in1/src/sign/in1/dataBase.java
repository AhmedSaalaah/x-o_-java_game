package tictoef;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class dataBase extends Application {
    Connection conn;
    public static void main(String[] args) {
        launch(args);
        
    }
    @Override
     public void init() throws SQLException{
     }
    @Override
     public void start(Stage primaryStage)throws Exception {
         Parent root;
        root = FXMLLoader.load(getClass().getResource("FXMLDocument2.fxml"));
         Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
         PreparedStatement stmt;
         connect con= new connect();
         conn=con.establish();  
        } 
    
}
//dataBase connection 
class connect{
    public Connection establish (){
    try{
Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/javagame","postgres", "1234");
            System.out.println("Connection sucess.");
            return connection;

}
catch (SQLException e) {
            System.out.println("Connection failure.");
        }return null;
}}
