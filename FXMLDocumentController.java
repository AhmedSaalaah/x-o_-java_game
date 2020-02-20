
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
import java.io.DataInputStream;
import java.io.PrintStream;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType; 
   
 
    

public class FXMLDocumentController {
    public static Integer[][] arry={{2,2,2},{2,2,2},{2,2,2}};
    String my_name ="marwa";
    String opposit_name="mohamed";
    Gson g=new Gson();
    data d=new data();
    public static DataInputStream dis;
    public static PrintStream ps;
    
    void get_socket(DataInputStream diss,PrintStream pss){
    ps=pss;
    dis=diss;}
    
    
    
    void get_name(String my,String opposit){
    my_name=my;
    opposit=opposit_name;
   }
    @FXML
    private Button init;
    @FXML
    private Button init1;
    @FXML
    private Button init2;
    
    
   
    
    
    
    void update_board(Integer[][] x){
        if(x[0][0]==0){
    b1.setText("o");}
        if(x[0][0]==1){
        b1.setText("x");
        }
           if(x[0][1]==0){
    b1.setText("o");}
        if(x[0][1]==1){
        b1.setText("x");
        }
       if(x[0][2]==0){
    b1.setText("o");}
        if(x[0][2]==1){
        b1.setText("x");
        }
           if(x[1][0]==0){
    b1.setText("o");}
        if(x[1][0]==1){
        b1.setText("x");
        }
           if(x[1][1]==0){
    b1.setText("o");}
        if(x[1][1]==1){
        b1.setText("x");
        }
           if(x[1][2]==0){
    b1.setText("o");}
        if(x[1][2]==1){
        b1.setText("x");
        }
           if(x[2][0]==0){
    b1.setText("o");}
        if(x[2][0]==1){
        b1.setText("x");
        }
           if(x[2][1]==0){
    b1.setText("o");}
        if(x[2][1]==1){
        b1.setText("x");
        }
           if(x[2][2]==0){
    b1.setText("o");}
        if(x[2][2]==1){
        b1.setText("x");
        }
    
    }

//       Integer[][] arry;
       
   // f is flag to know the symbol we play by it
       public int f =1;
       
       
    Game_logic gl = new Game_logic();
    

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
      d.array[0][0]=1;

              if ( gl.check_winner(arry)!=-1){
       System.out.print(  gl.check_winner(arry));
              }
   }
   
       }  
       else if(f==0){
      if ("".equals(b1.getText()))  {
      b1.setText("O");
      arry[0][0]=0;
      d.array[0][0]=0;

              if ( gl.check_winner(arry)!=-1){
   System.out.print(  gl.check_winner(arry));
              }
   }
          }
       d.type="update";
       d.opposit=opposit_name;
       ps.println(g.toJson(d));
       
       
       
       
   }
       @FXML

   private void setb2 ()
   {
    if (f==1){
   if ("".equals(b2.getText()))  {
      b2.setText("X");}
           arry[0][1]=1;
           d.array[0][1]=1;

   if ( gl.check_winner(arry)!=-1){
   System.out.print(  gl.check_winner(arry));
                   }

       } 
    else if(f==0){
            if ("".equals(b2.getText()))  {
      b2.setText("O");
      arry[0][1]=0;
      d.array[0][1]=0;

              if ( gl.check_winner(arry)!=-1){
   System.out.print(  gl.check_winner(arry));
              }
   }
          }
           d.type="update";
           d.opposit=opposit_name;
           ps.println(g.toJson(d));



   }
    @FXML
   
   private void setb3 ()
   {
   if (f==1){
   if ("".equals(b3.getText()))  {
      b3.setText("x");
                 arry[0][2]=1;
              d.array[0][2]=1;
     if ( gl.check_winner(arry)!=-1){
   System.out.print(  gl.check_winner(arry));
     }

   }
   }
   else if(f==0){
            if ("".equals(b3.getText()))  {
      b3.setText("O");
      arry[0][2]=0;
       d.array[0][2]=0;
              if ( gl.check_winner(arry)!=-1){
   System.out.print(  gl.check_winner(arry));
              }
   }
          }
          d.type="update";
                 d.opposit=opposit_name;
          System.out.println(g.toJson(d));
          ps.println(g.toJson(d));


       }
       @FXML

   private void setb4 ()
   {
    if (f==1){
   if ("".equals(b4.getText()))  {
      b4.setText("X");
      arry[1][0]=1; 
      d.array[1][0]=1;
   if ( gl.check_winner(arry)!=-1){
   System.out.print(  gl.check_winner(arry));
              }
   }
    }
    else if(f==0){
            if ("".equals(b4.getText()))  {
      b4.setText("O");
      arry[1][0]=0;
      d.array[1][0]=0;

              if ( gl.check_winner(arry)!=-1){
   System.out.print(  gl.check_winner(arry));
              }
   }
          }
           d.type="update";
                  d.opposit=opposit_name;

                  ps.println(g.toJson(d));


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
      d.array[1][1]=0;
              if ( gl.check_winner(arry)!=-1){
       gl.check_winner(arry);
              }
   }
          }
                  d.type="update";
                         d.opposit=opposit_name;

                         ps.println(g.toJson(d));



       }
       @FXML

   private void setb6 ()
   {
   if (f==1){
   if ("".equals(b6.getText()))  {
      b6.setText("x");
       arry[1][2]=1;
       d.array[1][2]=1;
               if ( gl.check_winner(arry)!=-1){
       gl.check_winner(arry);
               }

   }
   }
   else if(f==0){
            if ("".equals(b6.getText()))  {
      b6.setText("O");
      arry[1][2]=0;
      d.array[1][2]=0;
              if ( gl.check_winner(arry)!=-1){
      gl.check_winner(arry);
              }
   }
          }
          d.type="update";
                 d.opposit=opposit_name;

           ps.println(g.toJson(d));


       }  
       @FXML

   private void setb7 ()
   {
   if (f==1){
   if ("".equals(b7.getText()))  {
      b7.setText("x");
      arry[2][0]=1;
      d.array[2][0]=1;
              if( gl.check_winner(arry)!=-1){
   System.out.print(  gl.check_winner(arry));

   }}
   }
   else if(f==0){
            if ("".equals(b7.getText()))  {
      b7.setText("O");
      arry[2][0]=0;
      d.array[2][0]=0;
              if ( gl.check_winner(arry)!=-1){
   System.out.print(  gl.check_winner(arry));
              }
   }
          }
          d.type="update";
          d.opposit=opposit_name;
           ps.println(g.toJson(d));


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
                         d.type="update";
                         d.opposit=opposit_name;
                        ps.println(g.toJson(d));


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
          }       d.type="update";
                 d.opposit=opposit_name;
                 ps.println(g.toJson(d));

}
   

     public void exit ()
     {
              Alert a = new Alert(AlertType.WARNING); 
              a.setContentText("are you sure you want to exit?");
              a.show();
              
     }
 
   
   
   
 
  
  
 
   
   
   
   
   
   

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
    
        Integer [][] initiat_game(){
Integer [][]arr = {{-1,-1,-1},{-1,-1,-1},{-1,-1,-1}};
return arr;}

String convert_to_gson(data x,String type){
Gson g=new Gson();
x.type=type;
String message=g.toJson(x);

return message;
}
    @FXML
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