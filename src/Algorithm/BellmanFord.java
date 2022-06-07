package Algorithm;

import Edge.DirectedEdge;
import Graph.WDiGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BellmanFord<V extends Comparable<V>> {
    public Map<V, MPD<V>> map = new HashMap<>();

    public List<V> nodesToVisit = new ArrayList<>();
    public V start;

    public BellmanFord(WDiGraph<V, DirectedEdge<V>> wDiGraph, V s) {
        this.start = s;
        map.put(s, new MPD(false, "-1", 0.0));
        nodesToVisit.add(s);
        ArrayList<DirectedEdge<V>> nodesAndEdges = new ArrayList<>();
        for (V key : wDiGraph.adjacencyList.keySet()) {
            map.put(key, new MPD(false, null, Double.POSITIVE_INFINITY));
            for (DirectedEdge<V> directedEdge : wDiGraph.adjacencyList.get(key)) {
                nodesAndEdges.add(directedEdge);
            }
        }
        map.replace(s, new MPD(true, "-1", 0));

        for (V key : wDiGraph.adjacencyList.keySet()) {
            for (DirectedEdge<V> edge : nodesAndEdges) {
                if (map.get(edge.from()).distance != Double.POSITIVE_INFINITY && map.get(edge.from()).distance + edge.weight() < map.get(edge.to()).distance && map.get(edge.to()).previous == null) {
                    map.get(edge.to()).distance = map.get(edge.from()).distance + edge.weight();
                    map.get(edge.to()).previous = edge.from();
                }
            }
        }
    }

    public void printSP(V d) {

        String path = "";
        V currentNode = d;
        while (!currentNode.equals(start) && !currentNode.equals("-1")) {
            path = currentNode + " " + path;
            currentNode = map.get(currentNode).previous;
        }
        path = start + " " + path;
        if (currentNode.equals(-1)) {
            System.out.println("There is no path between " + start + " to " + d);
        } else {
            System.out.println("The path from " + start + " to node " + d + " is " + path);
            System.out.println(map.get(d).distance);
        }
    }
}
