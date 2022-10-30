package pattern;

public class OldEquals {

    private final int x;
    private final int y;

    public OldEquals(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (! (o instanceof OldEquals)) {
            return false;
        }
        OldEquals other = (OldEquals) o;
        return x == other.x
                && y == other.y;
    }
}
