/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tictoef;


import com.sun.prism.Material;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author M Gamal
 */
 class Game_logic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
}
     static Integer check_winner(Integer [][]mat) { 
     int principal = 0, secondary = 0,col_1=0,col_2=0,col_3=0,row_1 = 0,row_2=0,row_3=0; 
     int n=3;
     int winner=-1;
    if ( (mat[0][0]==0) & (mat[0][1]==0) & (mat[0][2]==0) ) {winner=0;}
    else if ( (mat[0][0]==1) & (mat[0][1]==1) & (mat[0][2]==1) ) {winner=1;}
    else if ( (mat[1][0]==0) & (mat[1][1]==0) & (mat[1][2]==0) ) {winner=0;}
    else if ( (mat[1][0]==1) & (mat[1][1]==1) & (mat[1][2]==1) ) {winner=1;}
    else if ( (mat[2][0]==0) & (mat[2][1]==0) & (mat[2][2]==0) ) {winner=0;}
    else if ( (mat[2][0]==1) & (mat[2][1]==1) & (mat[2][2]==1) ) {winner=1;}
    else if ( (mat[0][0]==0) & (mat[1][0]==0) & (mat[2][0]==0) ) {winner=0;}
    else if ( (mat[0][0]==1) & (mat[1][0]==1) & (mat[2][0]==1) ) {winner=1;}
    else if ( (mat[0][1]==0) & (mat[1][1]==0) & (mat[2][1]==0) ) {winner=0;}
    else if ( (mat[0][1]==1) & (mat[1][1]==1) & (mat[2][1]==1) ) {winner=1;}
    else if ( (mat[0][2]==0) & (mat[1][2]==0) & (mat[2][2]==0) ) {winner=0;}
    else if ( (mat[0][2]==1) & (mat[1][2]==1) & (mat[2][2]==1) ) {winner=1;}
    else if ( (mat[0][0]==0) & (mat[1][1]==0) & (mat[2][2]==0) ) {winner=0;}
    else if ( (mat[0][0]==1) & (mat[1][1]==1) & (mat[2][2]==1) ) {winner=1;}
    else if ( (mat[0][2]==0) & (mat[1][1]==0) & (mat[2][0]==0) ) {winner=0;}
    else if ( (mat[0][2]==1) & (mat[1][1]==1) & (mat[2][0]==1) ) {winner=1;}
      return winner ;
    } }