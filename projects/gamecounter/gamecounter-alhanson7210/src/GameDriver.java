import game.History;

import java.io.File;
import game.Game;
import game.Team;

/**
 * Game Driver using the ../results as the first argument to read all of the files
 */
public class GameDriver {
    /**
     * Reading in the results and printing out team info
     * @param args should be '../results'
     */
    public static void main(String[] args) {
        if (args.length == 0) {System.err.println("Please provide a directory");System.exit(1);}
        History gameHistory = new History();
        File[] files = new File(args[0]).listFiles();
        assert files != null;
        for (File file : files) {
            System.out.println(String.format("%d games read", gameHistory.readFile(file.getAbsolutePath())));
        }
        System.out.println(Game.getGames().size());
        for (Game game : Game.getGames()) {
            System.out.println(game.toString());
            Team loser = game.getLoser();
            System.out.println(loser.getName() + " is the loser");
            System.out.println(loser.getLoses() + " is how many times the loser lost");
            System.out.println(loser.getName() + " has a streak of " + loser.getCurrentStreak());
            System.out.println(loser.toString());
            Team winner = game.getWinner();
            System.out.println(winner.getName() + " is the winner");
            System.out.println(winner.toString());
            System.out.println(winner.getWins() + " is how many times the winner won");
            System.out.println(winner.getName() + " has a streak of " + winner.getCurrentStreak());
            System.out.println(winner.compareTo(loser) + " is the winning percentage number for the winner");


        }

    }
}