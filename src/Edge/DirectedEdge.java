package Edge;

public class DirectedEdge<V> extends Edge<V> {
	private final double weight;
	
	public DirectedEdge(V source, V destination, double weightDouble) {
		super(source, destination);
		this.weight = weightDouble;
	}
	
	public double weight() {
		return weight;
	}
}
