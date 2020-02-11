
package tictactoe_server;

import java.io.IOException;
import java.net.ServerSocket;

/**
 *
 * @author MohabOmar
 */
public class Server {
    private int port;
    
    public Server(int _port)
    {
        this.port = _port;
    }
    
    public void runServer() throws IOException
    {
        ServerSocket serverSocket = new ServerSocket(port);
        while(true)
        {
            Game game = new Game();
            Player first = new Player(serverSocket.accept(), game, "X", game.getGameId());
            game.setPlayer1(first);
            Player second = new Player(serverSocket.accept(), game, "O", game.getGameId());
            game.setPlayer2(second);
            
            first.
            second.setOpponent(first);
            
            first.start();
            second.start();
            game.startGame();
        }
    }
    
}

    
