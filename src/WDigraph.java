import java.util.ArrayList;
import java.util.TreeMap;

public class WDigraph<V extends Comparable<V>> extends Graph<V, DirectedEdge<V>>{
	
	public TreeMap<V,ArrayList<DirectedEdge<V>>> adjacencyList;

	public void addDirectedEdge(DirectedEdge<V> edge) {
		if (this.adjacencyList.get(edge.from()) == null) {
		    this.adjacencyList.put(edge.from(), new ArrayList<>());
		}
		this.adjacencyList.get(edge.from()).add(edge);
	}
	
	public WDigraph() {
		this.adjacencyList = new TreeMap<>();
	}
}
