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
    

public class FXMLDocumentController {

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
     
   //void handleButtonAction(ActionEvent event) {}
    
        
   private void setb1 ()
   {
   if ("x".equals(b1.getText()))  {
      b1.setText("o");
   }
     else
     {     b1.setText("x");
            }
       }   
       @FXML

   private void setb2 ()
   {
   if ("x".equals(b2.getText()))  {
      b2.setText("o");}
     else
     {     b2.setText("x");
            }
       } 
    @FXML
   
   private void setb3 ()
   {
   if ("x".equals(b3.getText()))  {
      b3.setText("o");}
     else
     {     b3.setText("x");
            }
       }
       @FXML

   private void setb4 ()
   {
   if ("x".equals(b4.getText()))  {
      b4.setText("o");}
     else
     {     b4.setText("x");
            }
       } 
    @FXML
   
   private void setb5()
   {
   if ("x".equals(b5.getText()))  {
      b5.setText("o");}
     else
     {     b5.setText("x");
            }
       }
       @FXML

   private void setb6 ()
   {
   if ("x".equals(b6.getText()))  {
      b6.setText("o");}
     else
     {     b6.setText("x");
            }
       }  
       @FXML

   private void setb7 ()
   {
   if ("x".equals(b7.getText()))  {
      b7.setText("o");}
     else
     {     b7.setText("x");
            }
       }
       @FXML

   private void setb8 ()
   {
   if ("x".equals(b8.getText()))  {
      b8.setText("o");}
     else
     {     b8.setText("x");
            }
       } 
    @FXML
   
   private void setb9 ()
   {
   if ("x".equals(b9.getText()))  {
      b9.setText("o");}
     else
     {     b9.setText("x");
            }
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
    
  
    
}

    

