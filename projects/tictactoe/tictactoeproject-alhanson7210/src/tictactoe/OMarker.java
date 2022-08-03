package tictactoe;

import polygon.Polygon;

/**
 * Omaker that extends from polygon to create the O shape
 */
public class OMarker extends Polygon implements Marker {

    static private final int NUMBER_VERTICES = 24;

    /**
     * Constructor for the omarker taking in a given size to construct an O shaped polygon
     * @param size length of the size of the line
     * @param left x-coordinate starting point
     * @param top y-coordinate starting point
     */
    OMarker(int size, int left, int top) {
        setWithVertices(false);
        //while not exactly right use half size
        double radius = size/2.0;
        for (int i = 0; i < NUMBER_VERTICES; i++) {
            addPoint(
                    (int)(left + size/2.0 +
                            radius * Math.cos(2 * Math.PI * i / NUMBER_VERTICES)),
                    (int)(top + size/2.0 +
                            radius * Math.sin(2 * Math.PI * i / NUMBER_VERTICES)));
        }
    }

    /**
     * implements the delete method from the Marker interface
     */
    public void delete() {
        removeAll();
    }
}

