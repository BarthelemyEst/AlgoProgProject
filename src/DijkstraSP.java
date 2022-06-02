import java.util.ArrayList;
import java.util.Set;

public class DijkstraSP {

    public String DijkstraSP(WDigraph<String> wDigraph, int s) {
        if(verifyNonNegative(wDigraph)) {
            return "there are negative edges weight";
        }
        
        return "";
    }

    public boolean verifyNonNegative(WDigraph<String> wDigraph) {
        boolean negativeEdgeWeight = false;
        Set<String> keys = wDigraph.adjacencyList.keySet();
        System.out.println(wDigraph.adjacencyList);
        for(String key:keys) {
            ArrayList<DirectedEdge<String>> nodeAndEdges = wDigraph.adjacencyList.get(key);
            for(DirectedEdge<String> edge : nodeAndEdges) {
                if(edge.weight() < 0) {
                    negativeEdgeWeight = true;
                }
            }
        }
        return negativeEdgeWeight;
    }
}
