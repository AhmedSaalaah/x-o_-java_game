/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictoef;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class AIGame  {
    List<Point> availablePoints;
    Scanner scan = new Scanner(System.in);
    int[][] board = new int[3][3];
    public boolean isGameOver() {
        return (hasXWon() || hasOWon() || getAvailableStates().isEmpty());
    }
    public boolean hasXWon() {
        if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == 1) || (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == 1)) {
            return true;
        }
        for (int i = 0; i < 3; ++i) {
            if (((board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == 1)
                    || (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == 1))) {
                return true;
            }
        }
        return false;
    }
    public boolean hasOWon() {
        if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == 2) || (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == 2)) {
            return true;
        }
        for (int i = 0; i < 3; ++i) {
            if ((board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == 2)
                    || (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == 2)) {
                return true;
            }
        }
        return false;
    }
    public List<Point> getAvailableStates() {
        availablePoints = new ArrayList<>();
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (board[i][j] == 0) {
                    availablePoints.add(new Point(i, j));
                }
            }
        }
        return availablePoints;
    }
    public void placeAMove(int x, int y, int player) {
        board[x][y] = player;   //player = 1 for X, 2 for O
    } 
    void takeHumanInput() {
        System.out.println("Your move: ");
        int x = scan.nextInt();
        int y = scan.nextInt();
        Point point = new Point(x, y);
        placeAMove(x,y, 2); 
    }
    public void displayBoard() {
        System.out.println();
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    } 
    Point computersMove;  
    public int minimax(int depth, int turn) {  
        if (hasXWon()) return +1; 
        if (hasOWon()) return -1;
        List<Point> pointsAvailable = getAvailableStates();
        if (pointsAvailable.isEmpty()) return 0; 
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;         
        for (int i = 0; i < pointsAvailable.size(); ++i) {  
            Point point = pointsAvailable.get(i);   
            if (turn == 1) { 
                placeAMove(point.x,point.y,1); 
                int currentScore = minimax(depth + 1, 2);
                max = Math.max(currentScore, max);                
                if(currentScore >= 0){ if(depth == 0) computersMove = point;} 
                if(currentScore == 1){board[point.x][point.y] = 0; break;} 
                if(i == pointsAvailable.size()-1 && max < 0){if(depth == 0)computersMove = point;}
            } else if (turn == 2) {
                placeAMove(point.x,point.y,2); 
                int currentScore = minimax(depth + 1, 1);
                min = Math.min(currentScore, min); 
                if(min == -1){board[point.x][point.y] = 0; break;}
            }
            board[point.x][point.y] = 0; //Reset this point
        } 
        return turn == 1?max:min;
    } 
     /*public static void main(String[] args) {
        AIGame b = new AIGame();        
        b.displayBoard();
//        System.out.println("Select turn ");
//        int choice = b.scan.nextInt();
//        if(choice == 1){
//            b.displayBoard();
//        }
        while (!b.isGameOver()) {
            System.out.println("Your move: ");
            Point userMove = new Point(b.scan.nextInt(), b.scan.nextInt());
            b.placeAMove(userMove, 2); //2 for O and O is the user
            b.displayBoard();
            if (b.isGameOver()) break;
            b.minimax(0, 1);  
            b.placeAMove(b.computersMove, 1);
            b.displayBoard();
        }
        if (b.hasXWon()) 
            System.out.println("Unfortunately, you lost!");
        else if (b.hasOWon()) 
            System.out.println("You win!"); 
        else 
            System.out.println("It's a draw!");

    
}*/
}




  

/**
 *
 * @author MohabOmar
 */

