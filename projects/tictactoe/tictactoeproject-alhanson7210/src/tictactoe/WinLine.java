package tictactoe;

import polygon.Polygon;

/**
 * Win lins are constructed at the en of the game when a winning position has been found
 */
class WinLine extends Polygon {
    /**
     * creation of the line that shows the sequence that has one the game for a given player
     * @param start starting point of the line to be drawn
     * @param end ending point of the line to be drawn
     */
    WinLine(Location start, Location end) {
        addPoint(start.getRow(), start.getColumn());
        addPoint(end.getRow(), end.getColumn());
    }

    /**
     * deleting the winning line from the board view
     */
    void delete() {
        removeAll();
    }
}
