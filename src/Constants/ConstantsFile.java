package Constants;

public final class ConstantsFile {

    private ConstantsFile() {
        // restrict instantiation
    }

    public static final int FRAME_RATE = 60;
    public static final int WIDE = 900;
    public static final int HIGH = 900;
    public static final float CELL_SIZE = 150.0F;
    public static final float CELL_RATE = 0.036F;
    public static final float COLUMN_RATE = 0.01F;
    public static final float ROW_RATE = 0.01F;


    public enum InputDirection {
        UP,
        DOWN,
        LEFT,
        RIGHT,
        NONE
    }


}


