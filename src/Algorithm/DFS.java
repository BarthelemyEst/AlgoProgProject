package Algorithm;

import Edge.DirectedEdge;
import Edge.Edge;
import Edge.SortByDestinationDirectedEdge;
import Edge.SortByDestinationEdge;
import Graph.DiGraph;
import Graph.WDiGraph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DFS<V extends Comparable<V>> {

	public List<V> dfsWD(WDiGraph<V, DirectedEdge<V>> g, V startNode) {
		List<V> dfsNodesList = new ArrayList<>();
		dFSRecursion2(g, startNode, dfsNodesList);
		return dfsNodesList;
	}

	public void dFSRecursion2(WDiGraph<V, DirectedEdge<V>> g, V currentNode, List<V> dfsNodesList) {
		dfsNodesList.add(currentNode);
		if (!g.adjacencyList.get(currentNode).equals(null)) {
			Collections.sort(g.adjacencyList.get(currentNode), new SortByDestinationDirectedEdge<V>());
			Iterator<DirectedEdge<V>> i = g.adjacencyList.get(currentNode).listIterator();
			while (i.hasNext()) {
				V nextNode = i.next().to();
				if (!dfsNodesList.contains(nextNode))
					dFSRecursion2(g, nextNode, dfsNodesList);
			}
		}
	}

	public List<V> dfs(DiGraph<V, Edge<V>> g, V startNode) {
		List<V> dfsNodesList = new ArrayList<>();
		dFSRecursion(g, startNode, dfsNodesList);
		return dfsNodesList;
	}

	public void dFSRecursion(DiGraph<V, Edge<V>> g, V currentNode, List<V> dfsNodesList) {
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