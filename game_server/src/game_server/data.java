/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_server;

//import javafx.scene.Scene;

import java.util.Vector;


public class data{
    String type;
    Integer[][] array;
    String user_id;
    String password;
    String email;
    Integer who_win;
    Integer turn_who;
    Integer who_x;
    Integer sucess;
    String destination;
    String user_name;
    String opposit;     
    Vector<String> clientsVector=new Vector<String>();
    Integer score;
    String message;
}