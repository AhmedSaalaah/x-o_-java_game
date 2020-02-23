/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictoef;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Acer
 */
public class log_in {
   
  
//  check_user(String name,String password);
   Integer  check_user(String name,String password) throws SQLException, InterruptedException{
    connect con= new connect();
     Connection conn=con.establish();
     //sleep(1000);
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
