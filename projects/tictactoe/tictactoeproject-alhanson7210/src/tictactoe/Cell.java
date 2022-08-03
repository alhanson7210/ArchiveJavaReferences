package tictactoe;

/**
 * One of many cells to be created for the board
 */
public class Cell {

    private BoardView view;
    private Location location;
    private MarkerType type;
    private Marker marker;

    /**
     * Constructor for creating a cell on a board view
     * @param view the board view
     * @param row int row number
     * @param column int column number
     */
    Cell(BoardView view, int row, int column) {
        this.view = view;
        this.location = new Location(row, column);
        type = null;
    }

    /**
     * setting the typpe of a cell
     * @param type initialized to null, overiding the cell, or displaying a new marker
     */
    void setType(MarkerType type) {
        //override whatever may be there
        if (marker != null && this.type != type) {
            marker.delete();
            marker = null;
        }
        this.type  = type;
        if (type != null) {
            marker = view.displayMarker(this);
        }
    }

    /**
     * if the cell is occupied by a marker
     * @return true if there is a marker or false if the false if the markker is null
     */
    public boolean isFilled() {
        return type != null;
    }

    /**
     * get the type of marker assigned to a cell
     * @return null, X, or O
     */
    public MarkerType getType() {
        return type;
    }

    /**
     * Getting a row
     * @return getting the row of a given cell
     */
    public int getRow() {
        return location.getRow();
    }

    /**
     * getting a column
     * @return getting the column of a given cell
     */
    public int getColumn() {
        return location.getColumn();
    }

}
