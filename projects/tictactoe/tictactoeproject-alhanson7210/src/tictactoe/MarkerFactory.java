package tictactoe;

/**
 * Marker creator
 */
public class MarkerFactory {
    /**
     * Creating an Omarker from a passed enum
     * @param type enum marker type X or O
     * @param size cell size and padding
     * @param left cell size and padding
     * @param top cell size and padding
     * @return null, a new Omarker, or a Xmarker
     */
    public static Marker getMarker(MarkerType type, int size,  int left, int top) {

        switch(type) {
            case O:
                return new OMarker(size, left, top);

            case X:
                return new XMarker(size, left, top);

        }
        return null;
    }
}
