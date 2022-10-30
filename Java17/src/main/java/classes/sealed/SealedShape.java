package classes.sealed;

public sealed class SealedShape permits Pentagon, Triangle, Quadrilateral {

    private final int edges;

    public SealedShape(int edges) {
        this.edges = edges;
    }

    public int getEdges() {
        return edges;
    }
}
