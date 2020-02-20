/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat_server;
import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import static java.lang.Thread.sleep;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.control.Label;
/**
 *
 * @author M Gamal
 */
public class Chat_server {
ServerSocket serverSocket;
    /**
     * @param args the command line arguments
     */
public static void main(String[] args) throws IOException {
new Chat_server();

}
public Chat_server() throws IOException{
serverSocket = new ServerSocket(5005);
while(true)
{
Socket s = serverSocket.accept();
new ChatHandler(s);
}

}}
//game handler
  class ChatHandler extends Thread
{
                 
static Integer i=0;
String temp_des="player_"+i;
DataInputStream dis;
PrintStream ps;
//static Vector<ChatHandler> clientsVector=new Vector<ChatHandler>();
//hash map of all users
static Map<String, ChatHandler> player_socket = new HashMap<>();
static Map<String, ChatHandler> temp = new HashMap<>();

public ChatHandler(Socket cs) throws IOException
{  
    i++;
dis = new DataInputStream(cs.getInputStream());
ps= new PrintStream(cs.getOutputStream());
//clientsVector.add(this);
start();}
public void run()
{
 temp.put("player_"+i, this);   
while(true)
{
    try {
        String str = null;
        String string = dis.readLine();
        if(string!=null){
        execute(string);
        System.out.println("hi");
        }
    } catch (IOException | SQLException | InterruptedException ex) {
        try {
            dis.close();
        } catch (IOException ex1) {
            try {
                dis.close();
                ps.close();
            } catch (IOException ex2) {
                ps.close();            }
            
        }
        ps.close();
    }
}}
void execute(String s) throws SQLException, InterruptedException, IOException{
Gson g=new Gson();
data p2=g.fromJson(s,data.class);
// sign up
if (p2.type.equals("signup")){
    //create singup object
    sing_up sign=new sing_up();
  sign.sing_up(p2.user_name,p2.password);
}
if (p2.type.equals("update")){
    System.out.println(p2.opposit);
    System.out.println(p2.array[0][0]);
        System.out.println(p2.array[0][1]);
    System.out.println(p2.array[0][2]);

    try {
        player_socket.get(p2.opposit).ps.println(s);
    } catch (Exception e) {
        data error=new data();
        error.type="error can't access to palyer";
        Gson gson_error= new Gson();
        ps.println(gson_error.toJson(error));
//        ps.close();
//        dis.close();
//        this.stop();
    }

}
//log in
if (p2.type.equals("login")){
log_in log=new log_in();
p2.sucess=log.check_user(p2.user_name,p2.password);
if(p2.sucess ==1){player_socket.put(p2.user_name, this);
    data d=new data();
d.sucess=1;
    player_socket.get(p2.user_name).ps.println(convert_to_gson(d,"login"));
     System.out.println("login_sucess");
}
else{
    data d=new data();
    d.sucess=0;
    System.out.println(temp);
    ps.println(convert_to_gson(d,"login"));
     System.out.println("login_failed");
}
}
}
void sendMessageToAll(String x,String user_name)
{
//    for(ChatHandler ch: clientsVector)
//{   
//ch.ps.println(x);
//}
System.out.println(user_name);
System.out.println(x);
System.out.println(player_socket);
player_socket.get(user_name).ps.println(x);
player_socket.get(user_name).ps.println(x);
}
Integer [][] initiat_game(){
Integer [][]arr = {{-1,-1,-1},{-1,-1,-1},{-1,-1,-1}};
return arr;}
String convert_to_gson(data x,String type){
Gson g=new Gson();
x.type=type;
String message=g.toJson(x);
return message;
}


class connect{
    public Connection establish (){
    try{
Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5544/java", "postgres", "mohamed");
            System.out.println("Connection sucess.");
            return connection;

}
catch (SQLException e) {
            System.out.println("Connection failure.");
            System.out.println(e);
        }return null;
}}
  class log_in{
  
//  check_user(String name,String password);
   Integer  check_user(String name,String password) throws SQLException, InterruptedException{
    connect con= new connect();
     Connection conn=con.establish();
//     sleep(1000);
PreparedStatement pst = conn.prepareStatement("select * from users where user_name=?");
pst.setString(1, name);
ResultSet  res=pst.executeQuery();
while (res.next()) {
String pass=res.getString(3);     
System.out.print(pass);
if(password.equals(pass)){
return 1;
}
  }
return 0;
}
  }
class sing_up{
void sing_up (String user_name,String password) throws InterruptedException, SQLException{

    connect con= new connect();
     Connection conn=con.establish();
     sleep(1000);
PreparedStatement pst = conn.prepareStatement("insert into  users(user_name,password) values(?,?) ");
pst.setString(1, user_name);
pst.setString(2, password);
boolean state=true;
try{
state=pst.execute();}
catch(SQLException e){
    Gson g=new Gson();
data p1=new data();
p1.type="singup_state";
p1.sucess=0;
System.out.println("sing_up_failed");
ps.println(convert_to_gson(p1,"singup_state"));
}
if(state== false){
    Gson g=new Gson();
data p1=new data();
p1.type="singup_state";
p1.sucess=1;
ps.println(convert_to_gson(p1,"singup_state"));
//System.out.println("sing_up_sucess");
}
//else{
//  Gson g=new Gson();
//data p1=new data();
//p1.type="singup_state";
//p1.sucess=0;
//System.out.println("sing_up_failed");
//ps.println(convert_to_gson(p1,"singup_state"));
//}
}}}