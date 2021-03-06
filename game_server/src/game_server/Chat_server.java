/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_server;

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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import static java.util.Collections.list;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.HashMap;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;

/**
 *
 * @author M Gamal
 */
public class Chat_server {
 
ServerSocket serverSocket;
public  Vector<Users> v;
void list() throws SQLException{
select_all list=new select_all();
Vector<Users> user= list.users();
v=user;
    }
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
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, SQLException {
        new Chat_server();

    }

    public Chat_server() throws IOException, SQLException {
        serverSocket = new ServerSocket(5005);
        while (true) {
            Socket s = serverSocket.accept();
            new ChatHandler(s);
        }

    }
}
//game handler

class ChatHandler extends Thread {

    static Integer i = 0;
    String temp_des = "player_" + i;
    DataInputStream dis;
    PrintStream ps;
    String my_name;
     
//static Vector<ChatHandler> clientsVector=new Vector<ChatHandler>();
//hash map of all users
    static Map<String, ChatHandler> player_socket = new HashMap<>();
    static Map<String, ChatHandler> temp = new HashMap<>();

    public ChatHandler(Socket cs) throws IOException, SQLException {
        i++;
        dis = new DataInputStream(cs.getInputStream());
        ps = new PrintStream(cs.getOutputStream());
       

//clientsVector.add(this);
        start();
    }

    public void run() {
        temp.put("player_" + i, this);
        
        while (true) {
            try {
                String str = null;
                String string = dis.readLine();
                if (string != null) {
                    execute(string);
                }
            } catch (IOException | SQLException | InterruptedException ex) {
                try {
                    player_socket.remove(my_name, this);
                    dis.close();
                } catch (IOException ex1) {
                    try {
                        player_socket.remove(my_name, this);
                        dis.close();
                        ps.close();
                    } catch (IOException ex2) {
                        player_socket.remove(my_name, this);
                        ps.close();
                    }
                }
                player_socket.remove(my_name, this);
                ps.close();
            }
        }
    }

    void execute(String s) throws SQLException, InterruptedException, IOException {
        Gson g = new Gson();
        data p2 = g.fromJson(s, data.class);
        if (p2.type.equals("chat")) {
            player_socket.get(p2.opposit).ps.println(convert_to_gson(p2, "chat"));
        }
// sign up
        if (p2.type.equals("inviteaccept")) {
            p2.sucess = 1;
            player_socket.get(p2.destination).ps.println(convert_to_gson(p2, "inviteaccept"));
        }
        if (p2.type.equals("invite")) {
            player_socket.get(p2.destination).ps.println(convert_to_gson(p2, "invite"));
            System.out.println(p2.user_name);
            System.out.println(p2.destination);
        }
        if (p2.type.equals("signup")) {
            //create singup object
            sing_up sign = new sing_up();
            sign.sing_up(p2.user_name, p2.password);
        }
        if (p2.type.equals("update")) {
            System.out.println(p2.opposit);
            System.out.println(p2.array[0][0]);
            System.out.println(p2.array[0][1]);
            System.out.println(p2.array[0][2]);

            try {
                player_socket.get(p2.opposit).ps.println(s);
            } catch (Exception e) {
                data error = new data();
                error.type = "error can't access to palyer";
                Gson gson_error = new Gson();
                ps.println(gson_error.toJson(error));
//        ps.close();
//        dis.close();
//        this.stop();
            }

        }
//log in
        if (p2.type.equals("login")) {
            log_in log = new log_in();
            p2.sucess = log.check_user(p2.user_name, p2.password);
            if (p2.sucess == 1) {
                player_socket.put(p2.user_name, this);
                my_name = p2.user_name;
                data d = new data();
                d.sucess = 1;
                d.user_name = p2.user_name;
                d.user_name = my_name;
                System.out.println(d.user_name);

                player_socket.get(p2.user_name).ps.println(convert_to_gson(d, "login"));
                sendMessageToAll(player_socket);
                System.out.println("login_sucess");
            } else {
                data d = new data();
                d.sucess = 0;
                ps.println(convert_to_gson(d, "login"));
                System.out.println("login_failed");
            }
        }
    }

    void sendMessageToAll(Map<String, ChatHandler> online_users) {

        data da = new data();
        Vector<Users> clientsVector = new Vector<Users>();
        da.type = "online_players";
        for (String ch : online_users.keySet()) {
            Users temp = new Users(1, ch);
            clientsVector.add(temp);
            System.out.println("online" + ch);
        }
        da.clientsVector = clientsVector;
        for (String ch : online_users.keySet()) {
            player_socket.get(ch).ps.println(convert_to_gson(da, "online_players"));
        }
        ps.println(convert_to_gson(da, "online_players"));
//System.out.println(user_name);
//System.out.println(x);
//System.out.println(player_socket);
//player_socket.get(user_name).ps.println(x);
//player_socket.get(user_name).ps.println(x);
    }

    Integer[][] initiat_game() {
        Integer[][] arr = {{-1, -1, -1}, {-1, -1, -1}, {-1, -1, -1}};
        return arr;
    }

    String convert_to_gson(data x, String type) {
        Gson g = new Gson();
        x.type = type;
        String message = g.toJson(x);
        return message;
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

    class log_in {

//  check_user(String name,String password);
        Integer check_user(String name, String password) throws SQLException, InterruptedException {
            connect con = new connect();
            Connection conn = con.establish();
//     sleep(1000);
            PreparedStatement pst = conn.prepareStatement("select * from users where user_name=?");
            pst.setString(1, name);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                String pass = res.getString(3);
                System.out.print(pass);
                if (password.equals(pass)) {
                    return 1;
                }
                if (!password.equals(pass)) {
                    return 0;
                }

            }
            return 0;
        }
    }

    class sing_up {

        void sing_up(String user_name, String password) throws InterruptedException, SQLException {

            connect con = new connect();
            Connection conn = con.establish();
            sleep(1000);
            PreparedStatement pst = conn.prepareStatement("insert into  users(user_name,password) values(?,?) ");
            pst.setString(1, user_name);
            pst.setString(2, password);
            boolean state = true;
            try {
                state = pst.execute();
            } catch (SQLException e) {
                Gson g = new Gson();
                data p1 = new data();
                p1.type = "singup_state";
                p1.sucess = 0;
                System.out.println("sing_up_failed");
                ps.println(convert_to_gson(p1, "singup_state"));
            }
            if (state == false) {
                Gson g = new Gson();
                data p1 = new data();
                p1.type = "singup_state";
                p1.sucess = 1;
                ps.println(convert_to_gson(p1, "singup_state"));
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
        }
    }

 
    }
