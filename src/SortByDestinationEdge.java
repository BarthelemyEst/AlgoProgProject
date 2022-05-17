import java.util.Comparator;

public class SortByDestinationEdge<V extends Comparable<V>> implements Comparator<Edge<V>> {

	public int compare(Edge<V> a, Edge<V> b) {
		V aTo = a.to();
		V bTo = b.to();
		return aTo.compareTo(bTo);
	}
}
