import Algorithm.*;

import Edge.DirectedEdge;
import Graph.*;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        DFS dfs = new DFS();

        System.out.println("Here, everything works with Strings : ");

        GraphFactory<String> stringGraphFactory = new StringGraphFactory();
        DiGraph diGraphString = stringGraphFactory.createDiGraphFromTextFile("graph-DFS-BFS.txt");
        WDiGraph wDiGraphString = stringGraphFactory.createWDiGraphFromTextFile("metro.txt");
        DijkstraSP<String> stringDijkstraSP = new DijkstraSP();


        System.out.println();
        System.out.println("Dijkstra : ");
        System.out.println();


        stringDijkstraSP.DijkstraSP(wDiGraphString, "3");

        stringDijkstraSP.shortestPath("5");
        stringDijkstraSP.distTo("5");


        System.out.println();
        System.out.println("DFS : ");


        System.out.println("DFS result from 0 (weighted graph) : " + dfs.dfsWD(wDiGraphString, "0"));
        System.out.println("DFS result from 5 (weighted graph) : " + dfs.dfsWD(wDiGraphString, "5"));
        System.out.println("DFS result from 0 (unweighted graph) : " + dfs.dfs(diGraphString, "0"));
        System.out.println("DFS result from 5 (unweighted graph) : " + dfs.dfs(diGraphString, "5"));


        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("============================================================================");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("Here, everything works with Integers : ");

        GraphFactory<Integer> integerGraphFactory = new IntegerGraphFactory();
        DiGraph diGraphInteger = integerGraphFactory.createDiGraphFromTextFile("graph-DFS-BFS.txt");
        WDiGraph wDiGraphInteger = integerGraphFactory.createWDiGraphFromTextFile("metro.txt");
        DijkstraSP<Integer> integerDijkstraSP = new DijkstraSP<>();

        System.out.println();
        System.out.println("Dijkstra : ");
        System.out.println();

        integerDijkstraSP.DijkstraSP(wDiGraphInteger, 3);
        integerDijkstraSP.shortestPath(5);
        integerDijkstraSP.distTo(5);

        System.out.println();
        System.out.println("DFS : ");

        System.out.println("DFS result from 0 (weighted graph) : " + dfs.dfsWD(wDiGraphInteger, 0));
        System.out.println("DFS result from 5 (weighted graph) : " + dfs.dfsWD(wDiGraphInteger, 5));
        System.out.println("DFS result from 0 (unweighted graph) : " + dfs.dfs(diGraphInteger, 0));
        System.out.println("DFS result from 5 (unweighted graph) : " + dfs.dfs(diGraphInteger, 5));
    }
}
