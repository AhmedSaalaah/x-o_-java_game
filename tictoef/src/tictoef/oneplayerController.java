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
import java.io.IOException;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType; 
import javafx.stage.Stage;
   
 
    

public class oneplayerController {
    
    AIGame ai = new AIGame();

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
    private void goBack(ActionEvent event) throws IOException {
    Parent home_page_parent = FXMLLoader.load(getClass().getResource("difficulty.fxml"));
    Scene home_page_scene = new Scene(home_page_parent);
    Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    app_stage.hide(); //optional
    app_stage.setScene(home_page_scene);
    app_stage.show();        
    }

    
    @FXML 

   private void setb1 ()
   {
        if (!ai.isGameOver())
        {
            ai.placeAMove(0, 0, 2);
            b1.setText("O");
            playAi();
        }

       
   }
       @FXML

   private void setb2 ()
   {
               if (!ai.isGameOver())
        {
            ai.placeAMove(0, 1, 2);
            b2.setText("O");
            playAi();
        }

   }
    @FXML
   
   private void setb3 ()
   {
       
               if (!ai.isGameOver())
        {
            ai.placeAMove(0, 2, 2);
            b3.setText("O");
            playAi();
        }
       }
       @FXML

   private void setb4 ()
   {
               if (!ai.isGameOver())
        {
            ai.placeAMove(1, 0, 2);
            b4.setText("O");
            playAi();
        }


       } 
    @FXML
   
   private void setb5()
   {
               if (!ai.isGameOver())
        {
            ai.placeAMove(1, 1, 2);
            b5.setText("O");
            playAi();
        }

       }
       @FXML

   private void setb6 ()
   {
               if (!ai.isGameOver())
        {
            ai.placeAMove(1, 2, 2);
            b6.setText("O");
            playAi();
        }

       }  
       @FXML

   private void setb7 ()
   {
               if (!ai.isGameOver())
        {
            ai.placeAMove(2, 0, 2);
            b7.setText("O");
            playAi();
        }
   }
       @FXML

   private void setb8 ()
   {
               if (!ai.isGameOver())
        {
            ai.placeAMove(2, 1, 2);
            b8.setText("O");
            playAi();
        }

   }
    @FXML
   
   private void setb9 ()
   {
               if (!ai.isGameOver())
        {
            ai.placeAMove(2, 2, 2);
            b9.setText("O");
            playAi();
        }
    }
   
          public void playAi()
    {
        if (!ai.isGameOver())
        {
            ai.minimax(0, 1);
            Point bestMove = ai.computersMove;
            
            
          // ai.minimax.Move bestMove = minimax.findBestMove(ai.board);
          
            ai.placeAMove(bestMove.x, bestMove.y, 1);
            
            if (bestMove.x == 0 && bestMove.y == 0)
            {
                b1.setText("X");
                b1.setDisable(true);
            }
            else if (bestMove.x == 1 && bestMove.y == 0)
            {
                b4.setText("X");
                b4.setDisable(true);
            }
            else if (bestMove.x == 2 && bestMove.y == 0)
            {
                b7.setText("X");
                b7.setDisable(true);
            }
            else if (bestMove.x == 0 && bestMove.y == 1)
            {
                b2.setText("X");
                b2.setDisable(true);
            }
            else if (bestMove.x == 1 && bestMove.y == 1)
            {
                b5.setText("X");
                b5.setDisable(true);
            }
            else if (bestMove.x == 2 && bestMove.y == 1)
            {
                b8.setText("X");
                b8.setDisable(true);
            }
            else if (bestMove.x == 0 && bestMove.y == 2)
            {
               b3.setText("X");
                b3.setDisable(true);
            }
            else if (bestMove.x == 1 && bestMove.y == 2)
            {
                b6.setText("X");
                b6.setDisable(true);
            }
            else if (bestMove.x == 2 && bestMove.y == 2)
            {
                b9.setText("X");
                b9.setDisable(true);
            }
            else
            {
    //            throw new Exception("are you kidding me?");
            }
        }
    }
   

     @FXML
     public void exit () throws Exception
     {
         Platform.exit(); 
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