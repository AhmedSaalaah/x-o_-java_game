
package tictactoe_server;

import java.net.Socket;

/**
 *
 * @author MohabOmar
 */
public class Player {
    private int gameId;
    private Socket socket;
    Player opponent;
    private Game game;
    private String mark;
    
    
    public Player(Socket socket, Game game, String mark, int gameId) {
        this.gameId = gameId;
        this.mark = mark;
        this.socket = socket;
        this.game = game;
    }
    
    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }
    
}
