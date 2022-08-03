package hanson;

import tictactoe.Board;
import tictactoe.MarkerType;
import tictactoe.Player;
import tictactoe.Location;
import tictactoe.Cell;
import java.util.ArrayList;
import java.util.Objects;
/**
 * hanson.ComputerPlayer for the tournament tic tac toe in class for artificial computer plays
 * @author Alex Hanson
 * @version 1.0
 */
public class ComputerPlayer extends Player {
    boolean firstMove = false;
    private ArrayList<int[]> myMoves;
    private ArrayList<int[]> opponentsMoves;
    /**
     * create a player with a name
     * @param name name of a given player
     */
    public ComputerPlayer(String name) {
        super(name);
        myMoves = new ArrayList<>();
        opponentsMoves = new ArrayList<>();
    }

    /**
     * creates a location point from the computers calculated strategy play
     * @param type enum type of the marker to be played for a given player
     * @param board current board to act upon to place a given marker
     * @return location point to be played
     */
    public Location getPlay(tictactoe.MarkerType type, tictactoe.Board board) {
        Cell[][] currentCells = board.getCells();
        int rows = board.getNumberRows();
        int columns = board.getNumberColumns();
        int opponentsmoves = countOfOpponentsMarkers(currentCells, type, rows, columns);
        boolean emptyCells = allCellsEmpty(currentCells, rows, columns);
        if (emptyCells) {
            opponentsMoves.clear();
            myMoves.clear();
        }
        getOpponentsMove(currentCells,type,rows,columns);
        int[] move = randomPlay(currentCells, rows, columns);
        return new Location(move[0], move[1]);
        //break in code
//        if (emptyCells == true) {
//            firstMove = true;
//            myMoves.add(new int[] {0,2});
//        }
//        if (firstMove == true) {
//            switch (opponentsmoves) {
//                case 0:
//                    int[] moveOne = myMoves.get(0);
//                    return new location(moveOne[0],moveOne[1]);
//                case 1:
//                    if (opponentPlayedInTheMiddle(currentCells,rows,columns,type)) {
//                        myMoves.add(new int[] {1,1});
//                        myMoves.add(new int[] {2,0});
//                        myMoves.add(new int[] {2,2});
//                        myMoves.add(new int[] {0,0});
//                        myMoves.add(new int[] {1,2});
//                        myMoves.add(new int[] {0,2});
//                        int[] moveTwo = myMoves.get(1);
//                        return new location(moveTwo[0], moveTwo[1]);
//                    }
//                    else if (opponentPlayedInTheCorner(currentCells,rows,columns,type)) {
//
//                    }
//                    else if (opponentPlayedInTheCenter(currentCells,rows,columns,type)) {
//
//                    }
//
//                case 2:
//                    break;
//                case 3:
//                    break;
//                case 4:
//                    break;
//            }
//        }
//
//
//        int[] move = randomPlay(currentCells, rows, columns);
//        return new Location(move[0], move[1]);
//        switch (type) {
//            case X:
//                switch (opponentsmoves) {
//                    case 0:
//                        int[] move = randomPlay(currentCells, rows, columns);
//                        return new Location(move[0], move[1]);
//                    case 1:
//                        int[] move = randomPlay(currentCells, rows, columns);
//                        return new Location(move[0], move[1]);
//                    case 2:
//                        int[] move = randomPlay(currentCells, rows, columns);
//                        return new Location(move[0], move[1]);
//                    case 3:
//                        int[] move = randomPlay(currentCells, rows, columns);
//                        return new Location(move[0], move[1]);
//                    case 4:
//                        int[] move = randomPlay(currentCells, rows, columns);
//                        return new Location(move[0], move[1]);
//                    default:
//                        int[] move = randomPlay(currentCells, rows, columns);
//                        return new Location(move[0], move[1]);
//                }
//            case O:
//                switch (opponentsmoves){
//                    case 1:
//                        if (!opponentPlayedInTheCenter(currentCells,rows,columns,type)) {
//                            return new Location(1,1);
//                        }
//                        return new Location(0,0);
//                    default:
//                        int[] move = randomPlay(currentCells, rows, columns);
//                        return new Location(move[0], move[1]);
//                }
//            default:
//                break;
//        }
////        if (allCellsEmpty(currentCells)) {
////            firstMove = true;
////        }
////        if (firstMove == true) {
////            return new Location(0,2);
////        }
////        switch (opponentsmoves){
////            case 0:
////                int[] moveOne = new int[2] {0,(int)(Math.random() * 2)};
////                myMoves.add(moveOne)
////                return new Location(moveOne[0], moveOne[1]);
////                break;
////            case 1:
////        }
//        int[] moveOne = new int[] {0,(int)(Math.random() * 2)};
//        myMoves.add(moveOne);
//        return new Location(moveOne[0], moveOne[1]);
    }

    /**
     * checking if all the cells are empty
     * @param cells current board
     * @param rows rows on the board
     * @param columns columns on the board
     * @return returning true if all cells are null, otherwise it is false
     */
    private boolean allCellsEmpty(Cell[][] cells, int rows, int columns) {
        boolean isEmpty = true;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (cells[r][c].getType() != null) {
                    isEmpty = false;
                }
            }
        }
        return isEmpty;
    }

    /**
     * creating a random play location point in a array of integers
     * @param cells current board
     * @param rows rows on the board
     * @param columns columns on the board
     * @return integer array of a given location to play for a play
     */
    private int[] randomPlay(Cell[][] cells, int rows, int columns) {
        boolean emptySpotFound = false;
        int[] randomPair = new int[2];
        while (!emptySpotFound) {
            int r = (int) ((Math.random() * rows));
            int c = (int) ((Math.random() * columns));
            if (cells[r][c].isFilled()) {
                continue;
            }
            emptySpotFound = true;
            randomPair[0] = r;
            randomPair[1] = c;
        }
        return randomPair;
    }

    /**
     * did the opponent play in the corner for their first move
     * @param cells current board
     * @param rows rows on the board
     * @param columns columns on the board
     * @param type enum type of the marker to be played for a given player
     * @return true if they have played in a corner, false otherwise
     */
    boolean opponentPlayedInTheCorner(Cell[][] cells, int rows, int columns, MarkerType type) {
        if (cells[0][0].getType() != null && cells[0][0].getType() != type) {
            return true;
        }
        else if (cells[0][2].getType() != null && cells[0][2].getType() != type) {
            return true;
        }
        else if (cells[2][0].getType() != null && cells[2][0].getType() != type) {
            return true;
        }
        else return cells[2][2].getType() != null && cells[2][2].getType() != type;
    }

    /**
     * did the opponent play in the middle for their first move
     * @param cells current board
     * @param rows rows on the board
     * @param columns columns on the board
     * @param type enum type of the marker to be played for a given player
     * @return true if they have played in a middle cell in a row, false otherwise
     */
    boolean opponentPlayedInTheMiddle(Cell[][] cells, int rows, int columns, MarkerType type) {
        if (cells[0][1].getType() != null && cells[0][1].getType() != type) {
            return true;
        }
        else if (cells[2][1].getType() != null && cells[2][1].getType() != type) {
            return true;
        }
        else if (cells[1][0].getType() != null && cells[1][0].getType() != type) {
            return true;
        }
        else return cells[1][2].getType() != null && cells[1][2].getType() != type;
    }

    /**
     * did the opponent play in the center for their first move
     * @param cells current board
     * @param rows rows on the board
     * @param columns columns on the board
     * @param type enum type of the marker to be played for a given player
     * @return true if they have played in the center of the board
     */
    boolean opponentPlayedInTheCenter(Cell[][] cells, int rows, int columns, MarkerType type) {
        return cells[1][1].getType() != null && cells[1][1].getType() != type;
    }

    /**
     * counting the opponents markers in a given game
     * @param cells current board
     * @param type enum type of the marker to be played for a given player
     * @param rows rows on the board
     * @param columns columns on the board
     * @return the number of their markers
     */
    private int countOfOpponentsMarkers(Cell[][] cells, MarkerType type, int rows, int columns) {
        int count = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (cells[r][c].getType() != null && cells[r][c].getType() != type) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * get the opponents last move and save it for reference for strategy
     * @param cells current board
     * @param type enum type of the marker to be played for a given player
     * @param rows rows on the board
     * @param columns columns on the board
     */
    private void getOpponentsMove(Cell[][] cells, MarkerType type, int rows, int columns) {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (cells[r][c].getType() != null && cells[r][c].getType() != type) {
                    boolean matches = false;
                    for (int[] move : opponentsMoves) {
                        if (Objects.deepEquals(move, new int[] {r,c})) {
                            matches = true;
                        }
                    }
                    if (!matches) {
                        opponentsMoves.add( new int[] {r,c});
                    }
                }
            }
        }
    }
}