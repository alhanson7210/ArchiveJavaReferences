package tictactoe;

import polygon.LineList;

/**
 * Xmaker that extends from polygon to create the X shape
 */
public class XMarker extends LineList implements Marker {
    /**
     * Constructor for the xmarker taking in a given size to construct an X shaped polygon
     * @param size length of the size of the line
     * @param left x-coordinate starting point
     * @param top y-coordinate starting point
     */
    XMarker(int size, int left, int top) {
        super(false);
        addLine(left, top, left + size, top + size);
        addLine(left, top + size, left + size, top);
    }

    /**
     * implements the delete method from the Marker interface
     */
    public void delete() {
        removeAll();
    }
}
