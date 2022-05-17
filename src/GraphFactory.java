import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GraphFactory {
	
	public static Digraph<String> createDiGraphFromTextFile(String path) throws FileNotFoundException {
		File file = new File(path);
		Scanner sc = new Scanner(file);
		Digraph<String> graph = new Digraph<String>();
		while (sc.hasNextLine()) {
			graph.m++;
			String[] currentLineNodes = sc.nextLine().split(" ");
			Edge<String> newEdge = new Edge<String>(currentLineNodes[0], (currentLineNodes[1]));
			graph.addEdge(newEdge);
		}
		sc.close();
		return graph;
	}
	
	public static WDigraph<String> createWDiGraphFromTextFile(String path) throws FileNotFoundException {
		File file = new File(path);
		Scanner sc = new Scanner(file);
		WDigraph<String> graph = new WDigraph<String>();
		while (sc.hasNextLine()) {
			graph.m++;
			String[] currentLineNodes = sc.nextLine().split(" ");
			DirectedEdge<String> newDirectedEdge = new DirectedEdge<String>(currentLineNodes[0], (currentLineNodes[1]), Double.parseDouble(currentLineNodes[2]));
			graph.addDirectedEdge(newDirectedEdge);
		}
		sc.close();
		return graph;
	}
}
