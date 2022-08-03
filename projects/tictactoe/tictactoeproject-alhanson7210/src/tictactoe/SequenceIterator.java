package tictactoe;

import tictactoe.Cell;
import tictactoe.Sequence;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterating through the cells to determine sequences
 */
public class SequenceIterator implements Iterator<Cell> {

    private Cell[][] cells;
    private Sequence sequence;
    private int currentRow;
    private int currentColumn;
    private int deltaRow;
    private int deltaColumn;

    /**
     * construtor to start iterating through the cells
     * @param sequence set of sequences to iterate through
     * @param cells current board setting
     */
    public SequenceIterator(Sequence sequence, Cell[][] cells) {
        this.cells = cells;
        this.sequence = sequence;
        deltaRow = sequence.getStartRow() == sequence.getEndRow()
                ? 0
                : (sequence.getStartRow() < sequence.getEndRow() ? 1 : -1);
        deltaColumn = sequence.getStartColumn() == sequence.getEndColumn()
                ? 0
                : (sequence.getStartColumn() < sequence.getEndColumn() ? 1 : -1);
        currentRow = sequence.getStartRow();
        currentColumn = sequence.getStartColumn();
    }

    /**
     * determining if there is another item
     * @return true if their is a next item within iteration, false otherwise
     */
    @Override
    public boolean hasNext() {
        return (currentRow * deltaRow <= sequence.getEndRow() * deltaRow
                && currentColumn * deltaColumn <= sequence.getEndColumn() * deltaColumn);
    }

    /**
     * getting the next cell from the board
     * @return a given cell through the iteration process of a given sequence an board
     * @throws NoSuchElementException if there is no other item to iterate over, an exception is through
     */
    @Override
    public Cell next() throws NoSuchElementException {
        if (!hasNext()) {
            throw new NoSuchElementException("At end of sequence");
        }
        Cell cell = cells[currentRow][currentColumn];
        currentRow += deltaRow;
        currentColumn += deltaColumn;
        return cell;
    }
}
