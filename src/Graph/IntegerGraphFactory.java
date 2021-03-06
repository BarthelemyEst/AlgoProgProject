package Graph;

import Edge.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IntegerGraphFactory extends GraphFactory<Integer> {
    @Override
    public DiGraph createDiGraphFromTextFile(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner sc = new Scanner(file);
        DiGraph<Integer, Edge<Integer>> graph = new DiGraph<Integer, Edge<Integer>>();
        while (sc.hasNextLine()) {
            graph.m++;
            String[] currentLineNodes = sc.nextLine().split(" ");
            Edge<Integer> newEdge = new Edge<>(Integer.valueOf(currentLineNodes[0]), Integer.valueOf(currentLineNodes[1]));
            graph.addEdge(newEdge);
        }
        sc.close();
        return graph;
    }

    @Override
    public WDiGraph createWDiGraphFromTextFile(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner sc = new Scanner(file);
        WDiGraph<Integer, DirectedEdge<Integer>> graph = new WDiGraph<Integer, DirectedEdge<Integer>>();
        boolean dollarPassed = false;
        while (sc.hasNextLine()) {
            String[] currentLineNodes = sc.nextLine().split(" ");
            if (dollarPassed) {
                graph.m++;
                if (!graph.adjacencyList.containsKey(Integer.valueOf(currentLineNodes[0]))) {
                    graph.n++;
                }
                DirectedEdge<Integer> newDirectedEdge = new DirectedEdge<>(Integer.valueOf(currentLineNodes[0]), Integer.valueOf(currentLineNodes[1]), Double.parseDouble(currentLineNodes[2]));
                graph.addDirectedEdge(newDirectedEdge);
            } else if (currentLineNodes[0].equals("$")) {
                dollarPassed = true;
            }
        }
        sc.close();
        return graph;
    }
}
