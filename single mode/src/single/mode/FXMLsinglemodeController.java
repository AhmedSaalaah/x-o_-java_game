/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package single.mode;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 *
 * @author Ahmed Salah
 */
public class FXMLsinglemodeController implements Initializable {
    
    @FXML
    private Pane winer;
    @FXML
    private Button b5;
    @FXML
    private Button b4;
    @FXML
    private Button b8;
    @FXML
    private Button b7;
    @FXML
    private Button b1;
    @FXML
    private Button b2;
    @FXML
    private Button init;
    @FXML
    private Button init1;
    @FXML
    private Button init2;
    @FXML
    private Button b6;
    @FXML
    private Button b9;
    @FXML
    private Button b3;
     @FXML
    private Button n1;
      
      @FXML
    private Button e1;
    
     Button[][] button;  
    Boolean first = false;
    Boolean continuee =true;
    int Counter = 0; 
     int Counter2 = 0; 
    Random r = new Random();  
    int random;
    int randam2;
    
    
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        button=new Button[3][3];
     
     button[0][0]=b1;
     button[0][1]=b2;
     button[0][2]=b3;
     button[1][0]=b4;
     button[1][1]=b5;
     button[1][2]=b6;
     button[2][0]=b7;
     button[2][1]=b8;
     button[2][2]=b9; 
        // TODO
    }    

    @FXML
    private void setb5(ActionEvent event) {
         Button userTurn=(Button)event.getSource();
         if(continuee==true){ 
                  
             if( userTurn.getText().equals("")){
             userTurn.setText("X");
             
             Counter+=200;
             checkWinner();
                
             }
             else 
                 System.out.println("Please choose an empty space");
                 
                 }
         if(continuee==true){
                 first = false;
                
                 
                 for(int c = 0; c <9; c++){
                  random = r.nextInt(3);
                  randam2 = r.nextInt(3);
                
                       
                            if (button[random][randam2].getText().equals(""))
                            {
                               button[random][randam2].setText("O");
                               Counter2+=200;
                                 checkWinner2();
                              break;
                               
                            } 
                 }}
    }

    @FXML
    private void setb4(ActionEvent event) {
         Button userTurn=(Button)event.getSource();
         if(continuee==true){ 
                  
             if( userTurn.getText().equals("")){
             userTurn.setText("X");
             
             Counter+=20;
             checkWinner();
                
             }
             else 
                 System.out.println("Please choose an empty space");
            
                 }
         if(continuee==true){
                 first = false;
                
                 
                 for(int c = 0; c <9; c++){
                  random = r.nextInt(3);
                  randam2 = r.nextInt(3);
                
                       
                            if (button[random][randam2].getText().equals(""))
                            {
                               button[random][randam2].setText("O");
                               Counter2+=20;
                                 checkWinner2();
                              break;
                               
                            } 
                 }}
    }

    @FXML
    private void setb8(ActionEvent event) {
         Button userTurn=(Button)event.getSource();
         if(continuee==true){ 
                  
             if( userTurn.getText().equals("")){
             userTurn.setText("X");
             
             Counter+=300;
             checkWinner();
                
             }
             else 
                 System.out.println("Please choose an empty space");
            
                 }
         if(continuee==true){
                 first = false;
                
                 
                 for(int c = 0; c <9; c++){
                  random = r.nextInt(3);
                  randam2 = r.nextInt(3);
                
                       
                            if (button[random][randam2].getText().equals(""))
                            {
                               button[random][randam2].setText("O");
                               Counter2+=300;
                                 checkWinner2();
                              break;
                               
                            } 
                 }}
    }

    @FXML
    private void setb7(ActionEvent event) {
        Button userTurn=(Button)event.getSource();
         if(continuee==true){ 
                  
             if( userTurn.getText().equals("")){
             userTurn.setText("X");
             
             Counter+=30;
             checkWinner();
                
             }
             else 
                 System.out.println("Please choose an empty space");
            
                 }
         if(continuee==true){
                 first = false;
                
                 Counter2+=30;
                 for(int c = 0; c <9; c++){
                  random = r.nextInt(3);
                  randam2 = r.nextInt(3);
                
                       
                            if (button[random][randam2].getText().equals(""))
                            {
                               button[random][randam2].setText("O");
                               Counter2+=30;
                                 checkWinner2();
                              break;
                               
                            } 
                 }}
    }

    @FXML
    private void setb1(ActionEvent event) {
        Button userTurn=(Button)event.getSource();
         if(continuee==true){ 
                  
             if( userTurn.getText().equals("")){
             userTurn.setText("X");
             
             Counter+=1;
             checkWinner();
                
             }
             else 
                 System.out.println("Please choose an empty space");
            
                 }
         if(continuee==true){
                 first = false;
                
                 
                 for(int c = 0; c <9; c++){
                  random = r.nextInt(3);
                  randam2 = r.nextInt(3);
                
                       
                            if (button[random][randam2].getText().equals(""))
                            {
                               button[random][randam2].setText("O");
                               Counter2+=1;
                                 checkWinner2();
                              break;
                               
                            } 
                 }}
        

    }

    @FXML
    private void setb2(ActionEvent event) {
         Button userTurn=(Button)event.getSource();
         if(continuee==true){ 
                  
             if( userTurn.getText().equals("")){
             userTurn.setText("X");
             
             Counter+=2;
             checkWinner();
                
             }
             else 
                 System.out.println("Please choose an empty space");
            
                 }
         if(continuee==true){
                 first = false;
                
                 
                 for(int c = 0; c <9; c++){
                  random = r.nextInt(3);
                  randam2 = r.nextInt(3);
                
                       
                            if (button[random][randam2].getText().equals(""))
                            {
                               button[random][randam2].setText("O");
                                 checkWinner2();
                                 Counter2+=2;
                              break;
                               
                            } 
                 }}
    }

    @FXML
    private void iniate(ActionEvent event) {
        
        
    }
    @FXML
    private void new1(ActionEvent event) {
    
        b1.setText("");
          b2.setText("");
          b3.setText("");
          b4.setText("");
          b5.setText("");
          b6.setText("");
          b7.setText("");
          b8.setText("");
          b9.setText("");
           winer.toBack();
            continuee =true;
            Counter = 0; 
        
    }
     

    @FXML
    private void setb6(ActionEvent event) {
        Button userTurn=(Button)event.getSource();
         if(continuee==true){ 
                  
             if( userTurn.getText().equals("")){
             userTurn.setText("X");
             
             Counter+=1000;
             checkWinner();
                
             }
             else 
                 System.out.println("Please choose an empty space");
            
                 }
         if(continuee==true){
                 first = false;
                
                 
                 for(int c = 0; c <9; c++){
                  random = r.nextInt(3);
                  randam2 = r.nextInt(3);
                
                       
                            if (button[random][randam2].getText().equals(""))
                            {
                               button[random][randam2].setText("O");
                               Counter2+=1000;
                                 checkWinner2();
                              break;
                               
                            } 
                 }}
    }

    @FXML
    private void setb9(ActionEvent event) {
         Button userTurn=(Button)event.getSource();
         if(continuee==true){ 
                  
             if( userTurn.getText().equals("")){
             userTurn.setText("X");
             
             Counter+=2000;
             checkWinner();
                
             }
             else 
                 System.out.println("Please choose an empty space");
            
                 }
         if(continuee==true){
                 first = false;
                
                
                 for(int c = 0; c <9; c++){
                  random = r.nextInt(3);
                  randam2 = r.nextInt(3);
                
                       
                            if (button[random][randam2].getText().equals(""))
                            {
                               button[random][randam2].setText("O");
                               Counter2+=2000;
                                 checkWinner2();
                              break;
                               
                            } 
                 }}
    }

    @FXML
    private void setb3(ActionEvent event) {
         Button userTurn=(Button)event.getSource();
         if(continuee==true){ 
                  
             if( userTurn.getText().equals("")){
             userTurn.setText("X");
             
             Counter+=3;
             checkWinner();
                
             }
             else 
                 System.out.println("Please choose an empty space");
            
         }
         if(continuee==true){
                 first = false;
                
                 
                 for(int c = 0; c <9; c++){
                  random = r.nextInt(3);
                  randam2 = r.nextInt(3);
                
                       
                            if (button[random][randam2].getText().equals(""))
                            {
                               button[random][randam2].setText("O");
                               Counter2+=3;
                                 checkWinner2();
                              break;
                               
                            } 
                 }}
    }
       public void checkWinner(){ 
    
    if( Counter == 1220 ||Counter == 6 || Counter == 2330 ||
                Counter == 3003 || Counter == 502 || Counter == 51 || 
                        Counter == 2201||Counter==233||Counter==26||
            Counter==206||Counter==1006||Counter==36||Counter==306||Counter==2006||
            Counter==1221||Counter==1222||Counter==1223||Counter==1250||Counter==1520||Counter==3220
            ||Counter==2331||Counter==2332||Counter==2333||Counter==2350||Counter==2530||Counter==3330
            ||Counter==53||Counter==251||Counter==351||Counter==54||Counter==1051||Counter==2051||Counter==503
            ||Counter==522||Counter==532||Counter==505||Counter==1502||Counter==2502||Counter==3004
            ||Counter==3023||Counter==3033||Counter==3005||Counter==3203||Counter==3303)


    {
            System.out.println(" YOU WIN ");
            winer.toFront();
            continuee =false;
    
    }
    

    
    
}
            public void checkWinner2(){ 
    
    if( Counter2 == 1220 ||Counter2 == 6 || Counter2 == 2330 ||
                Counter2 == 3003 || Counter2 == 502 || Counter2 == 51 || 
                        Counter2 == 2201||Counter2==233||Counter2==26||
            Counter2==206||Counter2==1006||Counter2==36||Counter2==306||Counter2==2006||
            Counter2==1221||Counter2==1222||Counter2==1223||Counter2==1250||Counter2==1520||Counter2==3220
            ||Counter2==2331||Counter2==2332||Counter2==2333||Counter2==2350||Counter2==2530||Counter2==3330
            ||Counter2==53||Counter2==251||Counter2==351||Counter2==54||Counter2==1051||Counter2==2051||Counter2==503
            ||Counter2==522||Counter2==532||Counter2==505||Counter2==1502||Counter2==2502||Counter2==3004
            ||Counter2==3023||Counter2==3033||Counter2==3005||Counter2==3203||Counter2==3303
            )


    {
            System.out.println(" YOU LOSE ");
            winer.toFront();
            continuee =false;
    
    }
    

    
    
}

    @FXML
    private void exit1(ActionEvent event) {
      
    }

    
}