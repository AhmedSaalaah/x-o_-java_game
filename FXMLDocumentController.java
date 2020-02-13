/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 package tictoef;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.color;
import com.google.gson.Gson;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType; 
   
 
    

public class FXMLDocumentController {

       Integer[][] arry;
       
   // f is flag to know the symbol we play by it
       public int f =0;
       
       
      Game_logic gl = new Game_logic();
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button b1;

    @FXML
    private Button b4;

    @FXML
    private Button b7;

    @FXML
    private Button b2;

    @FXML
    private Button b5;

    @FXML
    private Button b8;

    @FXML
    private Button b3;

    @FXML
    private Button b6;

    @FXML
    private Button b9;

    
            @FXML 

   private void setb1 ()
   {
       if (f==1){
   if ("".equals(b1.getText()))  {
      b1.setText("X");
      arry[0][0]=1;
              if ( gl.check_winner(arry)!=-1){
       System.out.print(  gl.check_winner(arry));
              }
   }
   
       }  
       else if(f==0){
            if ("".equals(b1.getText()))  {
      b1.setText("O");
      arry[0][0]=0;
              if ( gl.check_winner(arry)!=-1){
   System.out.print(  gl.check_winner(arry));
              }
   }
          }
       
   }
       @FXML

   private void setb2 ()
   {
    if (f==1){
   if ("".equals(b2.getText()))  {
      b2.setText("X");}
           arry[0][1]=1;
                   if ( gl.check_winner(arry)!=-1){
   System.out.print(  gl.check_winner(arry));
                   }

       } 
    else if(f==0){
            if ("".equals(b2.getText()))  {
      b2.setText("O");
      arry[0][1]=0;
              if ( gl.check_winner(arry)!=-1){
   System.out.print(  gl.check_winner(arry));
              }
   }
          }

   }
    @FXML
   
   private void setb3 ()
   {
   if (f==1){
   if ("".equals(b3.getText()))  {
      b3.setText("x");
                 arry[0][2]=1;
     if ( gl.check_winner(arry)!=-1){
   System.out.print(  gl.check_winner(arry));
     }

   }
   }
   else if(f==0){
            if ("".equals(b3.getText()))  {
      b3.setText("O");
      arry[0][2]=0;
              if ( gl.check_winner(arry)!=-1){
   System.out.print(  gl.check_winner(arry));
              }
   }
          }

       }
       @FXML

   private void setb4 ()
   {
    if (f==1){
   if ("".equals(b4.getText()))  {
      b4.setText("X");
      arry[1][0]=1; 
              if ( gl.check_winner(arry)!=-1){
   System.out.print(  gl.check_winner(arry));
              }
   }
    }
    else if(f==0){
            if ("".equals(b4.getText()))  {
      b4.setText("O");
      arry[1][0]=0;
              if ( gl.check_winner(arry)!=-1){
   System.out.print(  gl.check_winner(arry));
              }
   }
          }

       } 
    @FXML
   
   private void setb5()
   {
           if (f==1){
   if ("".equals(b5.getText()))  {
      b5.setText("X");
      arry[1][1]=1;
              if ( gl.check_winner(arry)!=-1){
      gl.check_winner(arry);
              }

   }
           }
           else if(f==0){
            if ("".equals(b5.getText()))  {
      b5.setText("O");
      arry[1][1]=0;
              if ( gl.check_winner(arry)!=-1){
       gl.check_winner(arry);
              }
   }
          }

       }
       @FXML

   private void setb6 ()
   {
   if (f==1){
   if ("".equals(b6.getText()))  {
      b6.setText("x");
       arry[1][2]=1;
               if ( gl.check_winner(arry)!=-1){
       gl.check_winner(arry);
               }

   }
   }
   else if(f==0){
            if ("".equals(b6.getText()))  {
      b6.setText("O");
      arry[1][2]=0;
              if ( gl.check_winner(arry)!=-1){
      gl.check_winner(arry);
              }
   }
          }

       }  
       @FXML

   private void setb7 ()
   {
   if (f==1){
   if ("".equals(b7.getText()))  {
      b7.setText("x");
      arry[2][0]=1;
              if( gl.check_winner(arry)!=-1){
   System.out.print(  gl.check_winner(arry));

   }}
   }
   else if(f==0){
            if ("".equals(b7.getText()))  {
      b7.setText("O");
      arry[2][0]=0;
              if ( gl.check_winner(arry)!=-1){
   System.out.print(  gl.check_winner(arry));
              }
   }
          }
   }
       @FXML

   private void setb8 ()
   {
                  if (f==1){
   if ("".equals(b8.getText()))  {
      b8.setText("X");
   
              arry[2][1]=1;
    if( gl.check_winner(arry)!=-1){
   System.out.print(  gl.check_winner(arry));

                      }
   }
                  }
   else if(f==0){
            if ("".equals(b8.getText()))  {
      b8.setText("O");
      arry[2][1]=0;
             if ( gl.check_winner(arry)!=-1){
                  
   System.out.print(  gl.check_winner(arry));
                  }

   }
          }
   }
    @FXML
   
   private void setb9 ()
   {
                  if (f==1){
   if ("".equals(b9.getText()))  {
      b9.setText("x");
         arry[2][2]=1;
        gl.check_winner(arry);
        if ( gl.check_winner(arry)!=-1){
   System.out.print(  gl.check_winner(arry));
        }

   }
                  }
   else if(f==0){
            if ("".equals(b9.getText()))  {
      b9.setText("O");
      arry[2][2]=0;
              if ( gl.check_winner(arry)!=-1){
   System.out.print(  gl.check_winner(arry));
              }
   }
          }}
   

     @FXML
     public void exit ()
     {
              Alert a = new Alert(AlertType.WARNING); 
              a.setContentText("are you sure you want to exit?");
              a.show();
              
     }
 
   
   
   
 
  
  
 
   
   
   
   
   
   

    @FXML
    void initialize() {
        assert b1 != null : "fx:id=\"b1\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert b4 != null : "fx:id=\"b4\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert b7 != null : "fx:id=\"b7\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert b2 != null : "fx:id=\"b2\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert b5 != null : "fx:id=\"b5\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert b8 != null : "fx:id=\"b8\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert b3 != null : "fx:id=\"b3\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert b6 != null : "fx:id=\"b6\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert b9 != null : "fx:id=\"b9\" was not injected: check your FXML file 'FXMLDocument.fxml'.";

    }
    
        @FXML
Integer [][] initiat_game(){
Integer [][]arr = {{-1,-1,-1},{-1,-1,-1},{-1,-1,-1}};
return arr;}

String convert_to_gson(data x,String type){
Gson g=new Gson();
x.type=type;
String message=g.toJson(x);

return message;
}
public void iniate ()
{
arry=initiat_game();
/*b1.setText(String.valueOf(arry[0][0]));
b2.setText(String.valueOf(arry[0][1]));
b3.setText(String.valueOf(arry[0][2]));
b4.setText(String.valueOf(arry[1][0]));
b5.setText(String.valueOf(arry[1][1]));
b6.setText(String.valueOf(arry[1][2]));
b7.setText(String.valueOf(arry[2][0]));
b8.setText(String.valueOf(arry[2][1]));
b9.setText(String.valueOf(arry[2][2]));*/


}

}