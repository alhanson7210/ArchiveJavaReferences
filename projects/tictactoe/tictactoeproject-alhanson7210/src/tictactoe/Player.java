package tictactoe;

import java.util.ArrayList;

/**
 * Tic tac toe player to create a human and computer player
 */
abstract public class Player {

    private static ArrayList<Player> players = new ArrayList<>();

    private String name;

    /**
     * list of all created players
     * @return current list of players
     */
    public static ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * Constructor to create a player for a game with a name
     * @param name name of the player
     */
    protected Player(String name) {
        this.name = name;
        players.add(this);
    }

    /**
     * Point to play on the tic tac toe board
     * @param type enum of the players type during the game
     * @param board current tictactoe board with all cells
     * @return a location point to play on the board each extended player must utilize
     */
    abstract public Location getPlay(tictactoe.MarkerType type, tictactoe.Board board);

    /**
     * name of the player
     * @return name of a given player
     */
    public String getName() {
        return name;
    }
}
