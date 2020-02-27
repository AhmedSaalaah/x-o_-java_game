/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictoef;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Ahmed Salah
 */
public class randomController implements Initializable {
    
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
   
    Boolean continuee =true;
   
     int score1=0;
     int score22=0;
     
    Random r = new Random();  
    int random;
    int randam2;
    @FXML
    private TextField score;
    @FXML
    private TextField score2;
    @FXML
    private Button init21;
    

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
    private void exit()
    {
        Platform.exit();
    }
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
    private void setb5(ActionEvent event) {
         Button userTurn=(Button)event.getSource();
         if(continuee==true){ 
                  
             if( userTurn.getText().equals("")){
             userTurn.setText("X");
             
            
             userTurn.setDisable(true);
             checkWinner();
                
             }
             else 
                 System.out.println("Please choose an empty space");
                 
                 }
         if(continuee==true){
                 
                
                 
                 for(int c = 0; c <9; c++){
                  random = r.nextInt(3);
                  randam2 = r.nextInt(3);
                
                       
                            if (button[random][randam2].getText().equals(""))
                            {
                               button[random][randam2].setText("O");
                               
                                button[random][randam2].setDisable(true);
                              
                                 checkWinner();
                            
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
              userTurn.setDisable(true);
             
             checkWinner();
                
             }
             else 
                 System.out.println("Please choose an empty space");
            
                 }
         if(continuee==true){
                
                
                 
                 for(int c = 0; c <9; c++){
                  random = r.nextInt(3);
                  randam2 = r.nextInt(3);
                
                       
                            if (button[random][randam2].getText().equals(""))
                            {
                               button[random][randam2].setText("O");
                               
                                 button[random][randam2].setDisable(true);
                                
                                 checkWinner();
                                
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
              userTurn.setDisable(true);
             
             checkWinner();
                
             }
             else 
                 System.out.println("Please choose an empty space");
            
                 }
         if(continuee==true){
                 
                
                 
                 for(int c = 0; c <9; c++){
                  random = r.nextInt(3);
                  randam2 = r.nextInt(3);
                
                       
                            if (button[random][randam2].getText().equals(""))
                            {
                               button[random][randam2].setText("O");
                               
                                button[random][randam2].setDisable(true);
                                
                                 checkWinner();
                                
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
              userTurn.setDisable(true);
             
             checkWinner();
                
             }
             else 
                 System.out.println("Please choose an empty space");
            
                 }
         if(continuee==true){
                
                 
                 
                 for(int c = 0; c <9; c++){
                  random = r.nextInt(3);
                  randam2 = r.nextInt(3);
                
                       
                            if (button[random][randam2].getText().equals(""))
                            {
                               button[random][randam2].setText("O");
                             
                                button[random][randam2].setDisable(true);
                               
                                 checkWinner();
                              
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
              userTurn.setDisable(true);
            
             checkWinner();
                
             }
             else 
                 System.out.println("Please choose an empty space");
            
                 }
         if(continuee==true){
                
                
                 
                 for(int c = 0; c <9; c++){
                  random = r.nextInt(3);
                  randam2 = r.nextInt(3);
                
                       
                            if (button[random][randam2].getText().equals(""))
                            {
                               button[random][randam2].setText("O");
                               
                                button[random][randam2].setDisable(true);
                               
                                 checkWinner();
                                
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
             userTurn.setDisable(true);
             
             checkWinner();
                
             }
             else 
                 System.out.println("Please choose an empty space");
            
                 }
         if(continuee==true){
                 
                
                 
                 for(int c = 0; c <9; c++){
                  random = r.nextInt(3);
                  randam2 = r.nextInt(3);
                
                       
                            if (button[random][randam2].getText().equals(""))
                            {
                               button[random][randam2].setText("O");
                                 
                                 
                                  button[random][randam2].setDisable(true);
                                  
                                 checkWinner();
                                  
                              break;
                               
                            } 
                 }}
    }

    
    @FXML
    private void new1(ActionEvent event) {
    
        b1.setText("");
        b1.setDisable(false);
          b2.setText("");
          b2.setDisable(false);
          b3.setText("");
          b3.setDisable(false);
          b4.setText("");
          b4.setDisable(false);
          b5.setText("");
          b5.setDisable(false);
          b6.setText("");
          b6.setDisable(false);
          b7.setText("");
          b7.setDisable(false);
          b8.setText("");
          b8.setDisable(false);
          b9.setText("");
          b9.setDisable(false);
           winer.toBack();
            continuee =true;
             
        
    }
     

    @FXML
    private void setb6(ActionEvent event) {
        Button userTurn=(Button)event.getSource();
         if(continuee==true){ 
                  
             if( userTurn.getText().equals("")){
             userTurn.setText("X");
             userTurn.setDisable(true);
            
             checkWinner();
                
             }
             else 
                 System.out.println("Please choose an empty space");
            
                 }
         if(continuee==true){
                 
                
                 
                 for(int c = 0; c <9; c++){
                  random = r.nextInt(3);
                  randam2 = r.nextInt(3);
                
                       
                            if (button[random][randam2].getText().equals(""))
                            {
                               button[random][randam2].setText("O");
                                
                                  button[random][randam2].setDisable(true);
                                
                                 checkWinner();
                                
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
             userTurn.setDisable(true);
             
             checkWinner();
                
             }
             else 
                 System.out.println("Please choose an empty space");
            
                 }
         if(continuee==true){
                
                
                
                 for(int c = 0; c <9; c++){
                  random = r.nextInt(3);
                  randam2 = r.nextInt(3);
                
                       
                            if (button[random][randam2].getText().equals(""))
                            {
                               button[random][randam2].setText("O");
                              
                                  button[random][randam2].setDisable(true);
                               
                                 checkWinner();
                              
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
             userTurn.setDisable(true);
            
             checkWinner();
                
             }
             else 
                 System.out.println("Please choose an empty space");
            
         }
         if(continuee==true){
                 
                
                 
                 for(int c = 0; c <9; c++){
                  random = r.nextInt(3);
                  randam2 = r.nextInt(3);
                
                       
                            if (button[random][randam2].getText().equals(""))
                            {
                               button[random][randam2].setText("O");
                              
                                button[random][randam2].setDisable(true);
                               
                                 checkWinner();
                               
                              break;
                               
                            } 
                 }}
    }
       public void checkWinner(){ 
    

      String s1=b1.getText();
      String s2=b2.getText();
      String s3=b3.getText();
      String s4=b4.getText();
      String s5=b5.getText();
      String s6=b6.getText();
      String s7=b7.getText();
      String s8=b8.getText();
      String s9=b9.getText();
      
      if((s1.equals(s2) && s1.equals(s3) && s1.equals("X"))||(s4.equals(s5) && s4.equals(s6) && s4.equals("X"))
              
              ||(s7.equals(s8) && s7.equals(s9) && s7.equals("X"))||(s1.equals(s4) && s1.equals(s7) && s1.equals("X"))
              ||(s2.equals(s5) && s2.equals(s8) && s2.equals("X"))||(s3.equals(s6) && s3.equals(s9) && s3.equals("X"))
              ||(s1.equals(s5) && s1.equals(s9) && s1.equals("X"))||(s3.equals(s5) && s3.equals(s7) && s3.equals("X"))
              )
      
      {
      
      System.out.println(" YOU WIN ");
           winer.toFront();
            continuee =false;
            score1+=10;
            String s=String.valueOf(score1);
            score.setText(s);
      }
      
      
      else if ((s1.equals(s2) && s2.equals(s3) && s1.equals("O"))||(s4.equals(s5) && s5.equals(s6) && s4.equals("O"))
              
              ||(s7.equals(s8) && s8.equals(s9) && s7.equals("O"))||(s1.equals(s4) && s4.equals(s7) && s1.equals("O"))
              ||(s2.equals(s5) && s5.equals(s8) && s2.equals("O"))||(s3.equals(s6) && s6.equals(s9) && s3.equals("O"))
              ||(s1.equals(s5) && s5.equals(s9) && s1.equals("O"))||(s3.equals(s5) && s5.equals(s7) && s3.equals("O"))
              )
      
      {
     System.out.println(" YOU LOSE ");
           
            continuee =false;
              score22+=10;
            String s11=String.valueOf(score22);
            score2.setText(s11);
       }
       
      
        
      
    
      
         
       
          
       
           
          
        



    
    
}


    @FXML
    private void exit1(ActionEvent event) {
      Platform.exit();
    }

    @FXML
    private void new12(ActionEvent event) {
         b1.setText("");
        b1.setDisable(false);
          b2.setText("");
          b2.setDisable(false);
          b3.setText("");
          b3.setDisable(false);
          b4.setText("");
          b4.setDisable(false);
          b5.setText("");
          b5.setDisable(false);
          b6.setText("");
          b6.setDisable(false);
          b7.setText("");
          b7.setDisable(false);
          b8.setText("");
          b8.setDisable(false);
          b9.setText("");
          b9.setDisable(false);
           winer.toBack();
            continuee =true;
        
        
    }

    
}