import java.util.*;

public class DijkstraSP {
    private static Map<String, MPD> map = new TreeMap<String, MPD>();
    List<String> nodesToVisit = new ArrayList<>();
    List<String> path = new ArrayList<>();
    List<DirectedEdge> Edges = new ArrayList<>();

    public List<String> DijkstraSP(WDigraph<String> wDigraph, String s) {
        map.put(s, new MPD(false, "-1", 0.0));
        nodesToVisit.add(s);

        if (verifyNonNegative(wDigraph)) {
            System.out.println("canceled because there are negative edge weight");
            return path;
        }
        for (String key : wDigraph.adjacencyList.keySet()) {
            ArrayList<DirectedEdge<String>> nodeAndEdges = wDigraph.adjacencyList.get(key);
            for (DirectedEdge<String> directedEdge : nodeAndEdges) {
                if (!s.toString().equals(directedEdge.from())) {
                    map.put(key, new MPD(false, "-1", Double.POSITIVE_INFINITY));
                }
            }
        }
        while (!nodesToVisit.isEmpty()) {
            double minimalDistance = Double.POSITIVE_INFINITY;
            String currentNode = s;

            for(int i = 0; i<nodesToVisit.size(); i++) {
                if(map.get(nodesToVisit.get(i)).distance < minimalDistance) {
                    minimalDistance = map.get(nodesToVisit.get(i)).distance;
                    currentNode = nodesToVisit.get(i);
                }
            }

            nodesToVisit.remove(currentNode);
            map.get(currentNode).marked = true;
            path.add(currentNode);

            for(DirectedEdge<String> directedEdge : wDigraph.adjacencyList.get(currentNode)) {
                Edges.add(directedEdge);
            }

            for(DirectedEdge<String> edge: Edges) {
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

    public static void shortestPath(String s, String d) {
        if(hasPathTo(d)) {
            if (s.equals(d)) {
                System.out.println("The destination is the starting node");
            } else {
                String path = "";
                String currentNode = d;
                while(!currentNode.equals(s) && currentNode != "-1") {
                    path = currentNode + " " + path;
                    currentNode = map.get(currentNode).previous;
                }
                path = s + " " + path;
                if(currentNode == "-1") {
                    System.out.println("there is no path between " + s + " and " + d);
                } else {
                    System.out.println("the path is : " + path);
                }
            }
        } else {
            System.out.println("there is no path between " + s + " and " + d);
        }
    }

    public static boolean hasPathTo(String v) {
        return map.get(v).marked;
    }

    public boolean verifyNonNegative(WDigraph<String> wDigraph) {
        boolean negativeEdgeWeight = false;
        Set<String> keys = wDigraph.adjacencyList.keySet();
        for (String key : keys) {
            ArrayList<DirectedEdge<String>> nodeAndEdges = wDigraph.adjacencyList.get(key);
            for (DirectedEdge<String> edge : nodeAndEdges) {
                if (edge.weight() < 0) {
                    negativeEdgeWeight = true;
                }
            }
        }
        return negativeEdgeWeight;
    }
}
