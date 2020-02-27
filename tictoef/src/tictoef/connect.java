/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictoef;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Acer
 */
public class connect {
   
    
    public Connection establish (){
    try{
Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5544/java", "postgres", "postgres");
            System.out.println("Connection sucess.");
            return connection;

}
catch (SQLException e) {
            System.out.println("Connection failure.");
            System.out.println(e);
        }return null;
}}
    
    

