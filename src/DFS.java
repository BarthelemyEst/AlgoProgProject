import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DFS<V extends Comparable<V>> {

	List<V> dfsWD(WDigraph<V> g, V startNode) {
		List<V> dfsNodesList = new ArrayList<V>();
		dFSRecursion2(g, startNode, dfsNodesList);
		return dfsNodesList;
	}

	void dFSRecursion2(WDigraph<V> g, V currentNode, List<V> dfsNodesList) {
		dfsNodesList.add(currentNode);
		if (g.adjacencyList.get(currentNode) != null) {
			Collections.sort(g.adjacencyList.get(currentNode), new SortByDestinationDirectedEdge<V>());
			Iterator<DirectedEdge<V>> i = g.adjacencyList.get(currentNode).listIterator();
			while (i.hasNext()) {
				V nextNode = i.next().to();
				if (!dfsNodesList.contains(nextNode))
					dFSRecursion2(g, nextNode, dfsNodesList);
			}
		}
	}

	List<V> dfs(Digraph<V> g, V startNode) {
		List<V> dfsNodesList = new ArrayList<V>();
		dFSRecursion(g, startNode, dfsNodesList);
		return dfsNodesList;
	}

	void dFSRecursion(Digraph<V> g, V currentNode, List<V> dfsNodesList) {
		dfsNodesList.add(currentNode);
		if (g.adjacencyList.get(currentNode) != null) {
			Collections.sort(g.adjacencyList.get(currentNode), new SortByDestinationEdge<V>());
			Iterator<Edge<V>> i = g.adjacencyList.get(currentNode).listIterator();
			while (i.hasNext()) {
				V nextNode = i.next().to();
				if (!dfsNodesList.contains(nextNode))
					dFSRecursion(g, nextNode, dfsNodesList);
			}
		}
	}
}
