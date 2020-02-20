/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package single.mode.random;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 *
 * @author Ahmed Salah
 */
public class FXMLrandomController implements Initializable {
    
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
                        Counter == 2201||Counter==233 )


    {
            System.out.println(" YOU WIN ");
            winer.toFront();
            continuee =false;
    
    }
    

    
    
}
            public void checkWinner2(){ 
    
    if( Counter2 == 1220 ||Counter2 == 6 || Counter2 == 2330 ||
                Counter2 == 3003 || Counter2 == 502 || Counter2 == 51 || 
                        Counter2 == 2201||Counter2==233 )


    {
            System.out.println(" YOU LOSE ");
            winer.toFront();
            continuee =false;
    
    }
    

    
    
}}