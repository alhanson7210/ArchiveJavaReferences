package game;

import java.util.ArrayList;

/**
 * Game class that creates two teams with scores
 * @author Alex Hanson
 * @version 1
 */
public class Game {

    private static ArrayList<Game> games = new ArrayList<>();

    private Team homeTeam;
    private Team awayTeam;
    private int homeScore;
    private int awayScore;

    /**
     * reads game line as and parses it as a game and teams
     * @param line game line from file
     * @throws IllegalArgumentException wrong line format
     */
    Game(String line) throws IllegalArgumentException {
        int at = line.indexOf('@');
        int colon = line.indexOf(':');
        int dash = line.indexOf('-');

        String team1 = line.substring(0,at).trim();
        String team2 = line.substring(at+1, colon).trim();
        String scoreone = line.substring(colon+1, dash).trim();
        String scoretwo = line.substring(dash+1).trim();
        int score1 = Integer.parseInt(scoreone);
        int score2 = Integer.parseInt(scoretwo);

        homeTeam = Team.getTeam(team1) != null? Team.getTeam(team1) : new Team(team1);
        awayTeam = Team.getTeam(team2) != null? Team.getTeam(team2) : new Team(team2);

        homeScore = score1;
        awayScore = score2;

        if (homeScore > awayScore) {
            homeTeam.addWin();
            awayTeam.addloss();
            homeTeam.addStreak();
            awayTeam.subtractStreak();
        }
        else {
            homeTeam.addloss();
            homeTeam.subtractStreak();
            awayTeam.addWin();
            awayTeam.addStreak();
        }

        games.add(this);
    }

    /**
     * returns the winning team
     * @return team winner
     */
    public Team getWinner() {
        if (homeScore == awayScore) {
            return null;
        }
        return homeScore > awayScore ? homeTeam : awayTeam;
    }

    /**
     * returns the loser team
     * @return team loser
     */
    public Team getLoser() {
        if (homeScore == awayScore) {
            return null;
        }
        return homeScore < awayScore ? homeTeam : awayTeam;
    }

    /**
     * return the away teams score
     * @return integer for the away score
     */
    int getAwayScore() {
        return awayScore;
    }

    /**
     * return the home teams score
     * @return integer for the home score
     */
    int getHomeScore() {
        return homeScore;
    }

    /**
     * returns the away team
     * @return a team object
     */
    Team getAwayTeam() {
        return awayTeam;
    }

    /**
     * returns the home team
     * @return a team object
     */
    Team getHomeTeam() {
        return homeTeam;
    }

    /**
     * list of all the games
     * @return array list of games
     */
    public static ArrayList<Game> getGames() {
        return games;
    }

    /**
     * formatted for the team name and score @ other team name and score
     * @return string of the format
     */
    @Override
    public String toString() {
        return String.format("\n%s(%d) @ %s(%d)", homeTeam.getName(),homeScore,awayTeam.getName(),awayScore);
    }

}
