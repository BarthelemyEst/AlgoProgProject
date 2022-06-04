package Graph;

import Edge.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StringGraphFactory extends GraphFactory<String>{
    @Override
    public <V extends Comparable<V>> DiGraph createDiGraphFromTextFile(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner sc = new Scanner(file);
        DiGraph<String, Edge<String>> graph = new DiGraph<String, Edge<String>>();
        while (sc.hasNextLine()) {
            graph.m++;
            String[] currentLineNodes = sc.nextLine().split(" ");
            Edge<String> newEdge = new Edge<>(currentLineNodes[0], currentLineNodes[1]);
            graph.addEdge(newEdge);
        }
        sc.close();
        return graph;
    }

    @Override
    public <V extends Comparable<V>> WDiGraph createWDiGraphFromTextFile(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner sc = new Scanner(file);
        WDiGraph<String, DirectedEdge<String>> graph = new WDiGraph<String, DirectedEdge<String>>();
        while (sc.hasNextLine()) {
            graph.m++;
            String[] currentLineNodes = sc.nextLine().split(" ");
            DirectedEdge<String> newDirectedEdge = new DirectedEdge<>(currentLineNodes[0], (currentLineNodes[1]), Double.parseDouble(currentLineNodes[2]));
            graph.addDirectedEdge(newDirectedEdge);
        }
        sc.close();
        return graph;
    }
}
