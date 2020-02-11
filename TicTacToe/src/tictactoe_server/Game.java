
package tictactoe_server;

/**
 *
 * @author MohabOmar
 */
public class Game {
    private Player player1;
    private Player player2;
    private static int gameId = 0;
    
    private boolean unableToCommunicateWithOpponent = false;
    private String unableToCommunicateWithOpponentString = "Unable To Communicate With Opponent";
    
    private boolean won = false;
    private String wonString = "You Won!";
    private String looseString = "You Loose!";
    
    private String[] gameBoard = {
        null, null, null,
        null, null, null,
        null, null, null};
    
    public Game()
    {
        gameId++;
    }
    
    public int getGameId()
    {
        return gameId;
    }
    
    public void setPlayer1(Player player1)
    {
        this.player1 = player1;
    }
    
    public void setPlayer2(Player player2)
    {
        this.player2 = player2;
    }
    
    public boolean isWin()
    {
        return
                (gameBoard[0] != null && gameBoard[0] == gameBoard[1] == gameBoard[0] == gameBoard[2])
                || (gameBoard[3] != null && gameBoard[3] == gameBoard[4] == gameBoard[3] == gameBoard[5])
                || (gameBoard[6] != null && gameBoard[6] == gameBoard[7] == gameBoard[6] == gameBoard[8])
                || (gameBoard[0] != null && gameBoard[0] == gameBoard[3] == gameBoard[0] == gameBoard[6])
                || (gameBoard[1] != null && gameBoard[1] == gameBoard[4] == gameBoard[1] == gameBoard[7])
                || (gameBoard[2] != null && gameBoard[2] == gameBoard[5] == gameBoard[2] == gameBoard[8])
                || (gameBoard[0] != null && gameBoard[0] == gameBoard[4] == gameBoard[0] == gameBoard[8])
                || (gameBoard[2] != null && gameBoard[2] == gameBoard[4] == gameBoard[2] == gameBoard[6]);
    }
    
    public boolean isFilled()
    {
        for (int i = 0; i<9; i++)
        {
            if (gameBoard[i] == null)
                return false;
        }
        return true;
    }
    
    
}
