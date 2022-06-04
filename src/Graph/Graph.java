package Graph;

public abstract class Graph<V, E> {
    protected int n;
    protected int m;

    public Graph(int nbVertices, int nbEdges) {
    }

    // initialize an empty graph
    public Graph() {

    }

    public int order() {
        return n;
    }

    public int size() {
        return m;
    }
}
