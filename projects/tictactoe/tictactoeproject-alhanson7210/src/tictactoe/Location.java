package tictactoe;

/**
 * Location points to keep track of cell locations
 */
public class Location {
    private int row;
    private int column;

    /**
     * making a location point from a column and row
     * @param row x-coordinate of the location point
     * @param column y-coordinate of the location point
     */
    public Location(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * getting a row from a location point
     * @return the row of a point
     */
    public int getRow() {
        return row;
    }

    /**
     * setting a row
     * @param row set the row of a point
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * getting a column from a location point
     * @return the column of a point
     */
    public int getColumn() {
        return column;
    }

    /**
     * setting a column
     * @param column set the column of a point
     */
    public void setColumn(int column) {
        this.column = column;
    }

    /**
     * overriding the to string to return the row and column
     * @return formatted string with the played location inclyuding the row and column
     */
    @Override
    public String toString() {
        return "[" + row + "," + column + "]";
    }
}
