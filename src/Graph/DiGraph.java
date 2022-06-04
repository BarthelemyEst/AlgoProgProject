package Graph;

import Edge.Edge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DiGraph<V, E extends Edge<V>> extends Graph<V, E> {

    public Map<V, ArrayList<E>> adjacencyList;

    public void addEdge(E edge) {
        if (this.adjacencyList.get(edge.from()) == null) {
            this.adjacencyList.put(edge.from(), new ArrayList<>());
        }
        this.adjacencyList.get(edge.from()).add(edge);
    }

    public DiGraph() {
        this.adjacencyList = new HashMap<>();
    }
}
