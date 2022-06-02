import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GraphFactory<V extends Comparable<V>> {

    public static <V extends Comparable<V>> Digraph<V> createDiGraphFromTextFile(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner sc = new Scanner(file);
        Digraph<V> graph = new Digraph<>();
        while (sc.hasNextLine()) {
            graph.m++;
            String[] currentLineNodes = sc.nextLine().split(" ");
            Edge<V> newEdge = new Edge<>((V) currentLineNodes[0], (V) (currentLineNodes[1]));
            graph.addEdge(newEdge);
        }
        sc.close();
        return graph;
    }

    public static <V extends Comparable<V>> WDigraph<V> createWDiGraphFromTextFile(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner sc = new Scanner(file);
        WDigraph<V> graph = new WDigraph<>();
        while (sc.hasNextLine()) {
            graph.m++;
            String[] currentLineNodes = sc.nextLine().split(" ");
            DirectedEdge<V> newDirectedEdge = new DirectedEdge<>((V) currentLineNodes[0], (V) (currentLineNodes[1]), Double.parseDouble(currentLineNodes[2]));
            graph.addDirectedEdge(newDirectedEdge);
        }
        sc.close();
        return graph;
    }

    public GraphFactory(V type) {
    }
}
