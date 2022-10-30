package pattern;

public class NewEquals {

    private final int x;
    private final int y;

    public NewEquals(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof NewEquals other)
                && x == other.x
                && y == other.y;
    }
}
