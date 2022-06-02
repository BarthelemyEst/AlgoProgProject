import java.util.*;

public class DijkstraSP<V extends Comparable<V>> {
    private Map<V, MPD<V>> map = new TreeMap();
    private List<V> nodesToVisit = new ArrayList<>();
    private List<V> path = new ArrayList<>();
    private List<DirectedEdge<V>> Edges = new ArrayList<>();
    V start;

    public List<V> DijkstraSP(WDigraph<V> wDigraph, V s) {
        this.start = s;
        map.put(s, new MPD(false, "-1", 0.0));
        nodesToVisit.add(s);

        if (verifyNonNegative(wDigraph)) {
            System.out.println("canceled because there are negative edge weight");
            return path;
        }
        for (V key : wDigraph.adjacencyList.keySet()) {
            ArrayList<DirectedEdge<V>> nodeAndEdges = wDigraph.adjacencyList.get(key);
            for (DirectedEdge<V> directedEdge : nodeAndEdges) {
                if (!s.equals(directedEdge.from())) {
                    map.put(key, new MPD(false, "-1", Double.POSITIVE_INFINITY));
                }
            }
        }
        while (!nodesToVisit.isEmpty()) {
            double minimalDistance = Double.POSITIVE_INFINITY;
            V currentNode = s;

            for(int i = 0; i<nodesToVisit.size(); i++) {
                if(map.get(nodesToVisit.get(i)).distance < minimalDistance) {
                    minimalDistance = map.get(nodesToVisit.get(i)).distance;
                    currentNode = nodesToVisit.get(i);
                }
            }

            nodesToVisit.remove(currentNode);
            map.get(currentNode).marked = true;
            path.add(currentNode);

            for(DirectedEdge<V> directedEdge : wDigraph.adjacencyList.get(currentNode)) {
                Edges.add(directedEdge);
            }

            for(DirectedEdge<V> edge: Edges) {
                if(map.get(edge.to()).distance > map.get(edge.from()).distance + edge.weight()) {
                    map.get(edge.to()).distance = map.get(edge.from()).distance + edge.weight();
                    map.get(edge.to()).previous = edge.from();
                }

                if(!map.get(edge.to()).marked && !nodesToVisit.contains(edge.to())) {
                    nodesToVisit.add(edge.to());
                }
            }
        }
        return path;
    }

    public void shortestPath(V d) {
        if(hasPathTo(d)) {
            if (this.start.equals(d)) {
                System.out.println("The destination is the starting node");
            } else {
                String path = "";
                V currentNode = d;
                while(!currentNode.equals(this.start) && currentNode != "-1") {
                    path = currentNode + " " + path;
                    currentNode = (V) map.get(currentNode).previous;
                }
                path = this.start + " " + path;
                if(currentNode == "-1") {
                    System.out.println("there is no path between " + this.start + " and " + d);
                } else {
                    System.out.println("the path is : " + path);
                }
            }
        } else {
            System.out.println("there is no path between " + this.start + " and " + d);
        }
    }

    public boolean hasPathTo(V v) {
        return map.get(v.toString()).marked;
    }

    public void distTo(V d) {
        System.out.println(map.get(d.toString()).distance);
    }

    public boolean verifyNonNegative(WDigraph<V> wDigraph) {
        boolean negativeEdgeWeight = false;
        Set<V> keys = wDigraph.adjacencyList.keySet();
        for (V key : keys) {
            ArrayList<DirectedEdge<V>> nodeAndEdges = wDigraph.adjacencyList.get(key);
            for (DirectedEdge<V> edge : nodeAndEdges) {
                if (edge.weight() < 0) {
                    negativeEdgeWeight = true;
                }
            }
        }
        return negativeEdgeWeight;
    }
}
