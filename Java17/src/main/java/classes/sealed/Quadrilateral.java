package classes.sealed;

public sealed class Quadrilateral extends SealedShape permits Square, Rectangle {


    private final int internalAngle1;
    private final int internalAngle2;
    private final int internalAngle3;
    private final int internalAngle4;

    public Quadrilateral(int internalAngle1, int internalAngle2, int internalAngle3, int internalAngle4) {
        super(4);
        this.internalAngle1 = internalAngle1;
        this.internalAngle2 = internalAngle2;
        this.internalAngle3 = internalAngle3;
        this.internalAngle4 = internalAngle4;

        if ((internalAngle1 + internalAngle2 + internalAngle3 + internalAngle4) > 360) {
            throw new IllegalArgumentException("Cannot have a square with internal angles of more than 360 degrees; "
                    + internalAngle1 + ", " + internalAngle2 + "," + internalAngle3 + "," + internalAngle4);
        }
    }

    public int getInternalAngle1() {
        return internalAngle1;
    }

    public int getInternalAngle2() {
        return internalAngle2;
    }

    public int getInternalAngle3() {
        return internalAngle3;
    }

    public int getInternalAngle4() {
        return internalAngle4;
    }
}
