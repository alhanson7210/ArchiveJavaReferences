package game;

import java.util.ArrayList;

/**
 * Creation of all the teams from the results files
 */
public class Team implements Comparable<Team> {
    private static ArrayList<Team> teams = new ArrayList<>();
    private String name;
    private int wins;
    private int loses;
    private int avgscore;
    private int otheravgscore;
    private int currentStreak;

    /**
     * creating a team
     * @param name name of team
     */
    Team(String name){
        this.name = name;
        wins = 0;
        loses = 0;
        otheravgscore = 0;
        avgscore = 0;
        currentStreak = 0;
        teams.add(this);
    }

    /**
     * increments the wins for a given team
     */
    void addWin() {
        wins++;
    }

    /**
     * increments the loses for a given team
     */
    void addloss() {
        loses++;
    }

    /**
     * increments the streaks for a given team
     */
    void addStreak() {
        currentStreak++;
    }

    /**
     * decrements the streaks for a given team
     */
    void subtractStreak() {
        currentStreak--;
    }

    /**
     * Name of the team
     * @return string of the team name
     */
    public String getName() {
        return name;
    }

    /**
     * the streak of the team
     * @return integer of the current streak
     */
    public int getCurrentStreak() {
        return currentStreak;
    }

    /**
     * how many wins the team has
     * @return number of wins
     */
    public int getWins() {
        return wins;
    }

    /**
     * how many loses the team has
     * @return number of loses
     */
    public int getLoses() {
        return loses;
    }

    /**
     * calculated the average score for the home team
     * @return double of the average score
     */
    private double getAvgscore() {
        int sum = 0;
        int count = 0;
        ArrayList<Game> games = Game.getGames();
        for (Game game : games) {
            if (game.getHomeTeam() == this) {
                sum += game.getHomeScore();
                count++;
            }
        }
        return ((double)sum)/count;
    }

    /**
     * calculated the average score for the away team
     * @return double of the average score
     */
    private double getOtheravgscore() {
        int sum = 0;
        int count = 0;
        ArrayList<Game> games = Game.getGames();
        for (Game game : games) {
            if (game.getAwayTeam() == this) {
                sum += game.getAwayScore();
                count++;
            }
        }
        return ((double)sum)/count;
    }

    /**
     * search for the team in the list of teams
     * @param name name of the team
     * @return null or the team that was searched for
     */
    static Team getTeam(String name){
        Team returnTeam = null;
        for (Team team : teams) {
            if (name.equals(team.getName())) {
                returnTeam = team;
            }
        }
        return returnTeam;
    }

    /**
     * list of all the teams
     * @return array of the teams
     */
    public static Team[] getTeams() {
        return teams.toArray(new Team[0]);
    }

    /**
     * the wins,loses,streak, and average score for a given team
     * @return formatted team information
     */
    @Override
    public String toString() {
        return String.format("%s: %d win(s), %d loss(es); Streak: %d wins. Average score: %f-%f",this.getName(),wins,loses,currentStreak,getAvgscore(),getOtheravgscore());
    }

    /**
     * coparring the winning percentage average
     * @param otherTeam another Team to compare
     * @return integer of the winning percentage -1 or 1
     */
    @Override
    public int compareTo(Team otherTeam) {
        double otherScore = (double)otherTeam.getWins()/(otherTeam.getWins() + otherTeam.getLoses());
        double thisScore = (double)this.getWins()/(this.getWins() + this.getLoses());
        return Double.compare(otherScore,thisScore);
    }
}
