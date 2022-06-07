package Algorithm;

import Edge.DirectedEdge;
import Graph.WDiGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BellmanFord<V extends Comparable<V>, E> {
    public Map<V, MPD<V>> map = new HashMap<>();

    public List<V> nodesToVisit = new ArrayList<>();
    public V startingNode;

    public BellmanFord(WDiGraph<V, DirectedEdge<V>> G, V source) {
        this.startingNode = source;
        map.put(source, new MPD(false, "-1", 0.0));
        nodesToVisit.add(source);
        ArrayList<DirectedEdge<V>> edges = new ArrayList<>();
        for (V key : G.adjacencyList.keySet()) {
            map.put(key, new MPD(false, null, Double.POSITIVE_INFINITY));
            for (DirectedEdge<V> directedEdge : G.adjacencyList.get(key)) {
                edges.add(directedEdge);
            }
        }
        map.replace(source, new MPD(true, "-1", 0));

        for (V key : G.adjacencyList.keySet()) {
            for (DirectedEdge<V> edge : edges) {
                if (map.get(edge.from()).distance != Double.POSITIVE_INFINITY && map.get(edge.from()).distance + edge.weight() < map.get(edge.to()).distance && map.get(edge.to()).previous == null) {
                    map.get(edge.to()).distance = map.get(edge.from()).distance + edge.weight();
                    map.get(edge.to()).previous = edge.from();
                }
            }
        }


    }

    public void printSP(V destination) {

        String path = "";
        V currentNode = destination;
        while (!currentNode.equals(startingNode) && !currentNode.equals("-1")) {
            path = currentNode + " " + path;
            currentNode = map.get(currentNode).previous;
        }
        path = startingNode + " " + path;
        if (currentNode.equals(-1)) {
            System.out.println("There is no path between " + startingNode + " to " + destination);
        } else {
            System.out.println("The path from " + startingNode + " to node " + destination + " is " + path);
            System.out.println(map.get(destination).distance);
        }
    }
}
