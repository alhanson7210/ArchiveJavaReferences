package game;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.IllegalFormatException;

/**
 * History of all the games played
 */
public class History {
    /**
     * how many games were read into the history
     * @param fileName name of the results file
     * @return games read from file
     */
    public int readFile(String fileName){
        int addedGames = 0;
        try{
            FileReader reader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                try {
                    if (line.contains("@") && line.contains(":") && line.contains("-")) {
                        new Game(line);
                        addedGames++;
                    }
                } catch (IllegalFormatException e) {
                    e.printStackTrace();
                }
            }
            reader.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return addedGames;
    }

    /**
     * list of all the games played
     * @return array of the current games
     */
    public static Game[] getGames(){
        ArrayList<Game> games = Game.getGames();
        return games.toArray(new Game[0]);
    }
}
