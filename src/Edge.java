
public class Edge<V> {
	private final V source;
	private final V destination;
	
	public Edge(V sourceVertex, V destinationVertex) {
		this.source = sourceVertex;
		this.destination = destinationVertex;
	}
	
	public V from() {
		return source;
	}
	
	public V to() {
		return destination;
	}
}
