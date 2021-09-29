package classes.sealed;

public non-sealed class Triangle extends SealedShape {

    private int internalAngle1;
    private int internalAngle2;
    private int internalAngle3;

    public Triangle(int internalAngle1, int internalAngle2, int internalAngle3) {
        super(3);
        this.internalAngle1 = internalAngle1;
        this.internalAngle2 = internalAngle2;
        this.internalAngle3 = internalAngle3;
        if ((internalAngle1 + internalAngle2 + internalAngle3) > 180) {
            throw new IllegalArgumentException("Cannot have a triangle with internal angles of more than 180 degrees; "
                    + internalAngle1 + ", " + internalAngle2 + "," + internalAngle3);
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
}
