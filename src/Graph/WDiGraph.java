package Graph;

import Edge.DirectedEdge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WDiGraph<V, E extends DirectedEdge<V>> extends Graph<V, E> {

    public Map<V, ArrayList<E>> adjacencyList;

    public void addDirectedEdge(E directedEdge) {
        if (this.adjacencyList.get(directedEdge.from()) == null) {
            this.adjacencyList.put(directedEdge.from(), new ArrayList<>());
        }
        this.adjacencyList.get(directedEdge.from()).add(directedEdge);
    }

    public WDiGraph() {
        this.adjacencyList = new HashMap<>();
    }
}
