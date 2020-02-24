package tictoef;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.PrintStream;
import java.util.Arrays;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
public class FXMLDocumentController {
 Game_logic gl = new Game_logic();
 public static Integer[][] x=initiat_game();
 public String my_name =Tictoef.getUserName();
 public String  opposit_name=Tictoef.opponent;
    public static DataInputStream dis;
    public static PrintStream ps;
    public String  turn_who=Tictoef.whoX;
    @FXML
    private Pane gameEnd;
    @FXML
    private Label who_win;
    @FXML
    private Button Play_Again;
    @FXML
    private Button gameEndExit;
    @FXML
    private Pane game;
    @FXML
    private Label turn;
    void get_socket(DataInputStream diss,PrintStream pss){
    ps=pss;
    dis=diss;}
    void get_name(String my,String opposit){
    my_name=my;
    opposit=opposit_name;
   }
    public static data object=new data();
    public void set(String s){Platform.runLater(() -> {update_board(s);});}                
    public  void update_board(String message){
        Gson arr=new Gson();
         System.out.println(message);
        object=arr.fromJson(message,data.class);
        x =object.array;
        for (Integer[] integers : x) {
                System.out.println(Arrays.toString(integers));}
        if(x[0][0]==0){
            Platform.runLater(() ->{b1.setText("O");
            });
        }
        if(x[0][0]==1){
                  Platform.runLater(() ->{b1.setText("X");
                  });
        }
        if(x[0][1]==0){
                   Platform.runLater(() ->{b2.setText("O");
                   });
        }
        if(x[0][1]==1){
                  Platform.runLater(() ->{b2.setText("X");
                  });
        }
       if(x[0][2]==0){
                
              Platform.runLater(() ->{b3.setText("O");
});       }
        if(x[0][2]==1){
              Platform.runLater(() ->{b3.setText("X");
                   });
        }
           if(x[1][0]==0){
              Platform.runLater(() ->{b4.setText("O");});
           }
        if(x[1][0]==1){
              Platform.runLater(() ->{b4.setText("X");});
        }
           if(x[1][1]==0){
              Platform.runLater(() ->{b5.setText("O");});
           }
        if(x[1][1]==1){
              Platform.runLater(() ->{b5.setText("X");});        }
           if(x[1][2]==0){       
              Platform.runLater(() ->{b6.setText("O");});           }
        if(x[1][2]==1){
                Platform.runLater(() ->{b6.setText("X");});
        }
           if(x[2][0]==0){
                Platform.runLater(() ->{b7.setText("O");});
           }
        if(x[2][0]==1){
                Platform.runLater(() ->{b7.setText("X");});
        }
           if(x[2][1]==0){
                Platform.runLater(() ->{b8.setText("O");});
           }
        if(x[2][1]==1){
                Platform.runLater(() ->{b8.setText("X");});
        }
           if(x[2][2]==0){
                Platform.runLater(() ->{b9.setText("O");});
           }
        if(x[2][2]==1){
                Platform.runLater(() ->{b9.setText("X");});}
    turn_who=Tictoef.userName;
          if(gl.check_winner(x)==1){gameEnd.toFront();

   if(Tictoef.whoX.equals(Tictoef.userName)){who_win.setText(Tictoef.userName);}
   else{who_win.setText(Tictoef.opponent);}
   }
   else if(gl.check_winner(x)==0){gameEnd.toFront();

   if(Tictoef.whoX.equals(Tictoef.userName)){who_win.setText(Tictoef.opponent);}
   else{who_win.setText(Tictoef.userName);}
   }
    }
      private void resetb1(){b1.setText("O");}
            @FXML 
   private void setb1 ()
   {Gson g=new Gson();
   if(turn_who.equals(Tictoef.userName)){
   if(x[0][0]==-1){
       if (Tictoef.whoX.equals(Tictoef.userName)){
   if ("".equals(b1.getText())){
      b1.setText("X");
      x[0][0]=1;
      if ( gl.check_winner(x)!=-1){
      System.out.print(  gl.check_winner(x));}}}  
       else if(Tictoef.whoX.equals(Tictoef.opponent)){
      if ("".equals(b1.getText()))  {
      b1.setText("O");
      x[0][0]=0;
      if ( gl.check_winner(x)!=-1){
    System.out.print(  gl.check_winner(x));
      }}}     
       object.type="update";
       object.opposit=Tictoef.opponent;
       object.array=x;
       ps.println(g.toJson(object));
   turn_who=Tictoef.opponent;
      turn.setText(turn_who);
   }
   }
         if(gl.check_winner(x)==1){gameEnd.toFront();

   if(Tictoef.whoX.equals(Tictoef.userName)){who_win.setText(Tictoef.userName);}
   else{who_win.setText(Tictoef.opponent);}
   }
   else if(gl.check_winner(x)==0){gameEnd.toFront();

  if(Tictoef.whoX.equals(Tictoef.userName)){who_win.setText(Tictoef.opponent);}
   else{who_win.setText(Tictoef.userName);}
   }
   }
    @FXML
   private void setb2 ()
   {Gson g=new Gson();
   if(turn_who.equals(Tictoef.userName)){
      if(x[0][1]==-1){
    if (Tictoef.whoX.equals(Tictoef.userName)){
   if ("".equals(b2.getText()))  {
      b2.setText("X");}
           x[0][1]=1;
   if ( gl.check_winner(x)!=-1){
   System.out.print(  gl.check_winner(x));}} 
    else if(Tictoef.whoX.equals(Tictoef.opponent)){
    if ("".equals(b2.getText()))  {
          b2.setText("O");
          x[0][1]=0;
   if ( gl.check_winner(x)!=-1){
   System.out.print(  gl.check_winner(x));}}}
           object.type="update";
       object.opposit=Tictoef.opponent;
              object.array=x;
       ps.println(g.toJson(object));
       System.out.println(object.array);
   turn_who=Tictoef.opponent;
      turn.setText(turn_who);}

   }
         if(gl.check_winner(x)==1){gameEnd.toFront();

   if(Tictoef.whoX.equals(Tictoef.userName)){who_win.setText(Tictoef.userName);}
   else{who_win.setText(Tictoef.opponent);}
   }
   else if(gl.check_winner(x)==0){gameEnd.toFront();

  if(Tictoef.whoX.equals(Tictoef.userName)){who_win.setText(Tictoef.opponent);}
   else{who_win.setText(Tictoef.userName);}
   }
   }
    @FXML
   private void setb3 ()
   {Gson g=new Gson();
   if(turn_who.equals(Tictoef.userName)){
      if(x[0][2]==-1){
   if (Tictoef.whoX.equals(Tictoef.userName)){
   if ("".equals(b3.getText()))  {
      b3.setText("X");
                 x[0][2]=1;
     if ( gl.check_winner(x)!=-1){
   System.out.print(  gl.check_winner(x));}}}
   else if(Tictoef.whoX.equals(Tictoef.opponent)){
    if ("".equals(b3.getText()))  {
        b3.setText("O");
        x[0][2]=0;
    if ( gl.check_winner(x)!=-1){
        System.out.print(  gl.check_winner(x));}}}
        object.type="update";
       object.opposit=Tictoef.opponent;
              object.array=x;
       ps.println(g.toJson(object));
   turn_who=Tictoef.opponent;
      turn.setText(turn_who);}

   }
         if(gl.check_winner(x)==1){gameEnd.toFront();

   if(Tictoef.whoX.equals(Tictoef.userName)){who_win.setText(Tictoef.userName);}
   else{who_win.setText(Tictoef.opponent);}
   }
   else if(gl.check_winner(x)==0){gameEnd.toFront();

 if(Tictoef.whoX.equals(Tictoef.userName)){who_win.setText(Tictoef.opponent);}
   else{who_win.setText(Tictoef.userName);}
   }
   }
       @FXML
   private void setb4 ()
   {Gson g=new Gson();
   if(turn_who.equals(Tictoef.userName)){
   if(x[1][0]==-1){
   if (Tictoef.whoX.equals(Tictoef.userName)){
   if ("".equals(b4.getText()))  {
       b4.setText("X");
       x[1][0]=1; 
   if ( gl.check_winner(x)!=-1){
   System.out.print(  gl.check_winner(x));}}}
      else if(Tictoef.whoX.equals(Tictoef.opponent)){
      if ("".equals(b4.getText()))  {
      b4.setText("O");
      x[1][0]=0;
       if ( gl.check_winner(x)!=-1){
       System.out.print(  gl.check_winner(x));}}}
       object.type="update";
       object.opposit=Tictoef.opponent;
       object.array=x;
       ps.println(g.toJson(object));
   turn_who=Tictoef.opponent;
      turn.setText(turn_who);}

   }
      if(gl.check_winner(x)==1){gameEnd.toFront();

   if(Tictoef.whoX.equals(Tictoef.userName)){who_win.setText(Tictoef.userName);}
   else{who_win.setText(Tictoef.opponent);}
   }
   else if(gl.check_winner(x)==0){gameEnd.toFront();

if(Tictoef.whoX.equals(Tictoef.userName)){who_win.setText(Tictoef.opponent);}
   else{who_win.setText(Tictoef.userName);}
   }
   } 
    @FXML
   private void setb5()
   {Gson g=new Gson();
   if(turn_who.equals(Tictoef.userName)){
   if(x[1][1]==-1){
   if (Tictoef.whoX.equals(Tictoef.userName)){
   if ("".equals(b5.getText()))  {
      b5.setText("X");
      x[1][1]=1;
    if ( gl.check_winner(x)!=-1){
      gl.check_winner(x);}}}
           else if(Tictoef.whoX.equals(Tictoef.opponent)){
            if ("".equals(b5.getText()))  {
      b5.setText("O");
      x[1][1]=0;
       if ( gl.check_winner(x)!=-1){
       gl.check_winner(x);}}}
       object.type="update";
       object.opposit=Tictoef.opponent;
       object.array=x;
       ps.println(g.toJson(object));
   turn_who=Tictoef.opponent;
      turn.setText(turn_who);}

   }
      if(gl.check_winner(x)==1){gameEnd.toFront();

   if(Tictoef.whoX.equals(Tictoef.userName)){who_win.setText(Tictoef.userName);}
   else{who_win.setText(Tictoef.opponent);}
   }
   else if(gl.check_winner(x)==0){gameEnd.toFront();

  if(Tictoef.whoX.equals(Tictoef.userName)){who_win.setText(Tictoef.opponent);}
   else{who_win.setText(Tictoef.userName);}
   }
   }
       @FXML
   private void setb6 ()
   {Gson g=new Gson();
   if(turn_who.equals(Tictoef.userName)){
      if(x[1][2]==-1){
   if (Tictoef.whoX.equals(Tictoef.userName)){
   if ("".equals(b6.getText()))  {
      b6.setText("X");
       x[1][2]=1;
      if ( gl.check_winner(x)!=-1){
      gl.check_winner(x);}}}
      else if(Tictoef.whoX.equals(Tictoef.opponent)){
      if ("".equals(b6.getText()))  {
      b6.setText("O");
      x[1][2]=0;
      if ( gl.check_winner(x)!=-1){
      gl.check_winner(x);}}}
      object.type="update";
      object.opposit=Tictoef.opponent;
      object.array=x;
       ps.println(g.toJson(object));
   turn_who=Tictoef.opponent;}
   }
           if(gl.check_winner(x)==1){gameEnd.toFront();

   if(Tictoef.whoX.equals(Tictoef.userName)){who_win.setText(Tictoef.userName);}
   else{who_win.setText(Tictoef.opponent);}
   }
   else if(gl.check_winner(x)==0){gameEnd.toFront();

if(Tictoef.whoX.equals(Tictoef.userName)){who_win.setText(Tictoef.opponent);}
   else{who_win.setText(Tictoef.userName);}
   }
   }
       @FXML
   private void setb7 ()
   {Gson g=new Gson();
   if(turn_who.equals(Tictoef.userName)){
   if(x[2][0]==-1){

   if (Tictoef.whoX.equals(Tictoef.userName)){
   if ("".equals(b7.getText()))  {
      b7.setText("X");
      x[2][0]=1;
              if( gl.check_winner(x)!=-1){
   System.out.print(  gl.check_winner(x));}}}
    else if(Tictoef.whoX.equals(Tictoef.opponent)){
    if ("".equals(b7.getText()))  {
        b7.setText("O");
        x[2][0]=0;
    if ( gl.check_winner(x)!=-1){
       System.out.print(  gl.check_winner(x));}}}
       object.type="update";
       object.opposit=Tictoef.opponent;
       object.array=x;
       ps.println(g.toJson(object));
   turn_who=Tictoef.opponent;
   turn.setText(turn_who);}
   }
            if(gl.check_winner(x)==1){gameEnd.toFront();

   if(Tictoef.whoX.equals(Tictoef.userName)){who_win.setText(Tictoef.userName);}
   else{who_win.setText(Tictoef.opponent);}
   }
   else if(gl.check_winner(x)==0){gameEnd.toFront();

  if(Tictoef.whoX.equals(Tictoef.userName)){who_win.setText(Tictoef.opponent);}
   else{who_win.setText(Tictoef.userName);}
   }
   }
       @FXML
   private void setb8 ()
   {Gson g=new Gson();
   if(turn_who.equals(Tictoef.userName)){
      if(x[2][1]==-1){
                  if (Tictoef.whoX.equals(Tictoef.userName)){
   if ("".equals(b8.getText()))  {
      b8.setText("X");
      x[2][1]=1;
//      object.array[2][1]=1;
    if( gl.check_winner(x)!=-1){
   System.out.print(  gl.check_winner(x));}}}
   else if(Tictoef.whoX.equals(Tictoef.opponent)){
   if ("".equals(b8.getText()))  {
      b8.setText("O");
      x[2][1]=0;
    if ( gl.check_winner(x)!=-1){
   System.out.print(gl.check_winner(x));}}}
       object.type="update";
       object.opposit=Tictoef.opponent;
       object.array=x;
       ps.println(g.toJson(object));
   turn_who=Tictoef.opponent;
      turn.setText(turn_who);}

   }
      if(gl.check_winner(x)==1){gameEnd.toFront();

   if(Tictoef.whoX.equals(Tictoef.userName)){who_win.setText(Tictoef.userName);}
   else{who_win.setText(Tictoef.opponent);}
   }
   else if(gl.check_winner(x)==0){gameEnd.toFront();

 if(Tictoef.whoX.equals(Tictoef.userName)){who_win.setText(Tictoef.opponent);}
   else{who_win.setText(Tictoef.userName);}
   }
   }
    @FXML
   private void setb9 ()
   {Gson g=new Gson();
   if(turn_who.equals(Tictoef.userName)){
   if(x[2][2]==-1){
   if (Tictoef.whoX.equals(Tictoef.userName)){
   if ("".equals(b9.getText()))  {
      b9.setText("X");
         x[2][2]=1;
        gl.check_winner(x);
        if ( gl.check_winner(x)!=-1){
   System.out.print(  gl.check_winner(x));}}}
   else if(Tictoef.whoX.equals(Tictoef.opponent)){
   if ("".equals(b9.getText()))  {
      b9.setText("O");
      x[2][2]=0;
   if ( gl.check_winner(x)!=-1){
       System.out.print(  gl.check_winner(x));}}}
       object.type="update";
       object.opposit=Tictoef.opponent;
       object.array=x;
       ps.println(g.toJson(object));
   turn_who=Tictoef.opponent;
      turn.setText(turn_who);}

   }
      if(gl.check_winner(x)==1){gameEnd.toFront();

   if(Tictoef.whoX.equals(Tictoef.userName)){who_win.setText(Tictoef.userName);}
   else{who_win.setText(Tictoef.opponent);}
   }
   else if(gl.check_winner(x)==0){gameEnd.toFront();

if(Tictoef.whoX.equals(Tictoef.userName)){who_win.setText(Tictoef.opponent);}
   else{who_win.setText(Tictoef.userName);}
   }
   }
   public void exit ()
     {
         Platform.exit();   
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
    return arr;
}
String convert_to_gson(data x,String type){
Gson g=new Gson();
x.type=type;
String message=g.toJson(x);
return message;
}
    @FXML
    public void iniate (){}
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

    @FXML
    private void game_end(ActionEvent event) {
        if (event.getSource()==Play_Again){
            gameEnd.toBack();
            turn_who=Tictoef.whoX;
            b1.setText("");
            b2.setText("");
            b3.setText("");
            b4.setText("");
            b5.setText("");
            b6.setText("");
            b7.setText("");
            b8.setText("");
            b9.setText("");
            x=initiat_game();
        }
        if (event.getSource()==gameEnd){
        gameEnd.toBack();
        }
    }
}