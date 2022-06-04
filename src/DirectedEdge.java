
public class DirectedEdge<V> {
	private final V v;
	private final V w;
	private final double weight;
	
	public DirectedEdge(V source, V destination, double weightDouble) {
		this.v = source;
		this.w = destination;
		this.weight = weightDouble;
	}
	
	public V from() {
		return v;
	}
	
	public V to() {
		return w;
	}
	
	public double weight() {
		return weight;
	}
}
