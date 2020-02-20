 
 

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
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType; 
   
 
    

public class FXMLDocumentController {
 public int f =1;
 Game_logic gl = new Game_logic();
//   public static Integer[][]=g1.initiat_game();
 public static Integer[][] x=initiat_game();
 String my_name ="mohamed";
 String opposit_name="marwa";
    public static DataInputStream dis;
    public static PrintStream ps;
    void get_socket(DataInputStream diss,PrintStream pss){
    ps=pss;
    dis=diss;}
    void get_name(String my,String opposit){
    my_name=my;
    opposit=opposit_name;
   }
    public static data object=new data();
public  void update_board(String message){
        Gson arr=new Gson();
         System.out.println(message);
        object=arr.fromJson(message,data.class);
        x =object.array;
        for (Integer[] integers : x) {
                System.out.println(Arrays.toString(integers));
    }
        if(x[0][0]==0){
            Platform.runLater(() ->{b1.setText("o");
                System.out.println("i am in controller");
            });
            
//            System.out.println("tictoef.FXMLDocumentController.update_board()b11111");
        }
        if(x[0][0]==1){
                  Platform.runLater(() ->{b1.setText("x");
                  System.out.println("i am in controller");
                  });
//        b1.setText("x");
        }
        if(x[0][1]==0){
                   Platform.runLater(() ->{b2.setText("o");
                   System.out.println("i am in controller");
                   });
//        b2.setText("o");
        }
        if(x[0][1]==1){
                  Platform.runLater(() ->{b2.setText("x");
                  System.out.println("i am in controller");
                  });
//        b2.setText("x");
        }
       if(x[0][2]==0){
                
Platform.runLater(() ->{b3.setText("o");
System.out.println("i am in controller");
});       }
        if(x[0][2]==1){
                   Platform.runLater(() ->{b3.setText("x");
                   System.out.println("i am in controller");
                   });
        }
           if(x[1][0]==0){
                    Platform.runLater(() ->{b4.setText("o");});
//    b4.setText("o");
           }
        if(x[1][0]==1){
                   Platform.runLater(() ->{b4.setText("x");});
        }
           if(x[1][1]==0){
               Platform.runLater(() ->{b5.setText("o");});
            
           }
        if(x[1][1]==1){
                
Platform.runLater(() ->{b5.setText("x");});        }
           if(x[1][2]==0){       
                  Platform.runLater(() ->{b6.setText("o");});           }
        if(x[1][2]==1){
                  Platform.runLater(() ->{b6.setText("x");});
        }
           if(x[2][0]==0){
                Platform.runLater(() ->{b7.setText("o");});
           }
        if(x[2][0]==1){
                Platform.runLater(() ->{b7.setText("x");});
        }
           if(x[2][1]==0){
                     Platform.runLater(() ->{b8.setText("o");});
           }
        if(x[2][1]==1){
                 Platform.runLater(() ->{b8.setText("x");});
        }
           if(x[2][2]==0){
                    Platform.runLater(() ->{b9.setText("o");});
           }
        if(x[2][2]==1){
                  Platform.runLater(() ->{b9.setText("x");});
        }

    }

//       Integer[][] arry;
       
   // f is flag to know the symbol we play by it
      @FXML
      private void resetb1()
      {
          b1.setText("O");
          
      }
       
            @FXML 
   private void setb1 ()
   {Gson g=new Gson();
   if(x[0][0]==-1){
       if (f==1){
   if ("".equals(b1.getText())){
      b1.setText("X");
      x[0][0]=1;
//      object.array[0][0]=1;
      if ( gl.check_winner(x)!=-1){
      System.out.print(  gl.check_winner(x));
              }}
               }  
       else if(f==0){
      if ("".equals(b1.getText()))  {
      b1.setText("O");
      x[0][0]=0;
//      object.array[0][0]=0;
      if ( gl.check_winner(x)!=-1){
    System.out.print(  gl.check_winner(x));
      }}}
       
       object.type="update";
       object.opposit=opposit_name;
       object.array=x;
       ps.println(g.toJson(object));}}
    @FXML
   private void setb2 ()
   {Gson g=new Gson();
      if(x[0][1]==-1){

    if (f==1){
   if ("".equals(b2.getText()))  {
      b2.setText("X");}
           x[0][1]=1;
//           object.array[0][1]=1;

   if ( gl.check_winner(x)!=-1){
   System.out.print(  gl.check_winner(x));
                   }

       } 
    else if(f==0){
            if ("".equals(b2.getText()))  {
      b2.setText("O");
      x[0][1]=0;
//      object.array[0][1]=0;

              if ( gl.check_winner(x)!=-1){
   System.out.print(  gl.check_winner(x));
              }
   }
          }
           object.type="update";
       object.opposit=opposit_name;
              object.array=x;

       ps.println(g.toJson(object));
       System.out.println(object.array);

   }}
    @FXML
   
   private void setb3 ()
   {Gson g=new Gson();
      if(x[0][2]==-1){

   if (f==1){
   if ("".equals(b3.getText()))  {
      b3.setText("x");
                 x[0][2]=1;
//              object.array[0][2]=1;
     if ( gl.check_winner(x)!=-1){
   System.out.print(  gl.check_winner(x));
     }

   }
   }
   else if(f==0){
            if ("".equals(b3.getText()))  {
      b3.setText("O");
      x[0][2]=0;
//       object.array[0][2]=0;
              if ( gl.check_winner(x)!=-1){
   System.out.print(  gl.check_winner(x));
              }
   }
          }
          object.type="update";
       object.opposit=opposit_name;
              object.array=x;

       ps.println(g.toJson(object));

      }       }
       @FXML

   private void setb4 ()
   {Gson g=new Gson();
      if(x[1][0]==-1){

    if (f==1){
   if ("".equals(b4.getText()))  {
      b4.setText("X");
      x[1][0]=1; 
//      object.array[1][0]=1;
   if ( gl.check_winner(x)!=-1){
   System.out.print(  gl.check_winner(x));
              }
   }
    }
    else if(f==0){
            if ("".equals(b4.getText()))  {
      b4.setText("O");
      x[1][0]=0;
//      object.array[1][0]=0;
              if ( gl.check_winner(x)!=-1){
   System.out.print(  gl.check_winner(x));
              }
   }
          }
            object.type="update";
       object.opposit=opposit_name;
              object.array=x;

       ps.println(g.toJson(object));


      }       } 
    @FXML
   
   private void setb5()
   {Gson g=new Gson();
      if(x[1][1]==-1){

           if (f==1){
   if ("".equals(b5.getText()))  {
      b5.setText("X");
      x[1][1]=1;
              if ( gl.check_winner(x)!=-1){
      gl.check_winner(x);
              }

   }
           }
           else if(f==0){
            if ("".equals(b5.getText()))  {
      b5.setText("O");
      x[1][1]=0;
//      object.array[1][1]=0;
              if ( gl.check_winner(x)!=-1){
       gl.check_winner(x);
              }
   }
          }
                  object.type="update";
       object.opposit=opposit_name;
              object.array=x;

       ps.println(g.toJson(object));


      }       }
       @FXML

   private void setb6 ()
   {Gson g=new Gson();
      if(x[1][2]==-1){

   if (f==1){
   if ("".equals(b6.getText()))  {
      b6.setText("x");
       x[1][2]=1;
//       object.array[1][2]=1;
               if ( gl.check_winner(x)!=-1){
       gl.check_winner(x);
               }

   }
   }
   else if(f==0){
            if ("".equals(b6.getText()))  {
      b6.setText("O");
      x[1][2]=0;
//      object.array[1][2]=0;
              if ( gl.check_winner(x)!=-1){
      gl.check_winner(x);
              }
   }
          }
          object.type="update";
       object.opposit=opposit_name;
              object.array=x;

       ps.println(g.toJson(object));

       }  }
       @FXML

   private void setb7 ()
   {Gson g=new Gson();
   if(x[2][0]==-1){

   if (f==1){
   if ("".equals(b7.getText()))  {
      b7.setText("x");
      x[2][0]=1;
//      object.array[2][0]=1;
              if( gl.check_winner(x)!=-1){
   System.out.print(  gl.check_winner(x));

   }}
   }
   else if(f==0){
            if ("".equals(b7.getText()))  {
      b7.setText("O");
      x[2][0]=0;
//      object.array[2][0]=0;
              if ( gl.check_winner(x)!=-1){
   System.out.print(  gl.check_winner(x));
              }
   }
          }
           object.type="update";
       object.opposit=opposit_name;
              object.array=x;

       ps.println(g.toJson(object));

   }
   }
       @FXML

   private void setb8 ()
   {Gson g=new Gson();
      if(x[2][1]==-1){
                  if (f==1){
   if ("".equals(b8.getText()))  {
      b8.setText("X");
      x[2][1]=1;
//      object.array[2][1]=1;
    if( gl.check_winner(x)!=-1){
   System.out.print(  gl.check_winner(x));

                      }
   }
                  }
   else if(f==0){
            if ("".equals(b8.getText()))  {
      b8.setText("O");
      x[2][1]=0;
//      object.array[2][1]=0;
             if ( gl.check_winner(x)!=-1){
   System.out.print(  gl.check_winner(x));
                  }
   }
          }
                        object.type="update";
       object.opposit=opposit_name;
              object.array=x;

       ps.println(g.toJson(object));


   }}
    @FXML
   
   private void setb9 ()
   {Gson g=new Gson();
      if(x[2][2]==-1){
                  if (f==1){
   if ("".equals(b9.getText()))  {
      b9.setText("x");
         x[2][2]=1;
//         object.array[2][2]=1;
        gl.check_winner(x);
        if ( gl.check_winner(x)!=-1){
   System.out.print(  gl.check_winner(x));
        }}
                  }
   else if(f==0){
            if ("".equals(b9.getText()))  {
      b9.setText("O");
      x[2][2]=0;
//      object.array[2][2]=0;

              if ( gl.check_winner(x)!=-1){
   System.out.print(  gl.check_winner(x));
              }
   }
          }        object.type="update";
       object.opposit=opposit_name;
              object.array=x;

       ps.println(g.toJson(object));
}
   
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
    
         public static Integer [][] initiat_game(){
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
/*b1.setText(String.valueOf(arry[0][0]));
b2.setText(String.valueOf(arry[0][1]));
b3.setText(String.valueOf(arry[0][2]));
b4.setText(String.valueOf(arry[1][0]));
b5.setText(String.valueOf(arry[1][1]));
b6.setText(String.valueOf(arry[1][2]));
b7.setText(String.valueOf(arry[2][0]));
b8.setText(String.valueOf(arry[2][1]));
b9.setText(String.valueOf(arry[2][2]));*/


}@FXML
        private Button ex;

@FXML
    private Button init;
    @FXML
    private Button init1;
    @FXML
    private Button init2;    
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

    

}