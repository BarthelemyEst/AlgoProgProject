package Edge;

import java.util.Comparator;

public class SortByDestinationDirectedEdge<V extends Comparable<V>> implements Comparator<DirectedEdge<V>> {

	public int compare(DirectedEdge<V> a, DirectedEdge<V> b) {
		V aTo = a.to();
		V bTo = b.to();
		return aTo.compareTo(bTo);
	}

}
