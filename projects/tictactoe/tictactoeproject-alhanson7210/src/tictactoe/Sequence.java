package tictactoe;

/**
 * Row and column sequences on the board to detect wins for the game
 */
public class Sequence {

    private int startRow;
    private int startColumn;
    private int endRow;
    private int endColumn;

    /**
     * Sequence for the board given the boards rows, columns, and diagonals
     * @param startRow where to start counting for a particular row sequence
     * @param startColumn where to start counting for a particular column sequence
     * @param endRow where to end counting for a particular row sequence
     * @param endColumn where to end counting for a particular column sequence
     */
    Sequence(int startRow, int startColumn,  int endRow, int endColumn) {
        this.startRow = startRow;
        this.startColumn = startColumn;
        this.endRow = endRow;
        this.endColumn = endColumn;
    }

    /**
     * Is there a winner within a given sequence
     * @param cells cells of the current board
     * @param inRowToWin number of a players marker needed to win
     * @return the sequence where the winner is decided to have won or null if no winner is found
     */
    Sequence getWinner(Cell[][] cells, int inRowToWin) {
        SequenceIterator iter = new SequenceIterator(this, cells);
        int count = 0;
        Cell startCell = null;
        while (iter.hasNext()) {
            Cell cell = iter.next();
            if (cell.getType() == null) {
                count = 0;
                startCell = null;
                continue;
            }
            if (startCell == null || cell.getType() != startCell.getType()) {
                count = 1;
                startCell = cell;
                continue;
            }
            count++;
            if (count == inRowToWin) {
                //we have a winner
                return new Sequence(startCell.getRow(), startCell.getColumn(),
                        cell.getRow(), cell.getColumn());
            }
        }
        return null;
    }

    /**
     * geting the start row
     * @return the number of that given row
     */
    public int getStartRow() {
        return startRow;
    }

    /**
     * getting the start column
     * @return the number of that given column
     */
    public int getStartColumn() {
        return startColumn;
    }

    /**
     * getting the end row
     * @return the number of that given row
     */
    public int getEndRow() {
        return endRow;
    }

    /**
     * getting the end column
     * @return the number of that given column
     */
    public int getEndColumn() {
        return endColumn;
    }


}
