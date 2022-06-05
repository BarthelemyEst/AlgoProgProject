import Algorithm.*;
import Graph.*;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        /* choose the graph you want to use for DFS and Dijkstra*/

        String WeightedDigraph = "graph-WDG.txt";
        String DiGraph = "graph-DFS-BFS.txt";


        DFS dfs = new DFS();

        System.out.println("Here, everything works with Strings : ");

        GraphFactory<String> stringGraphFactory = new StringGraphFactory();
        DiGraph diGraphString = stringGraphFactory.createDiGraphFromTextFile(DiGraph);
        WDiGraph wDiGraphString = stringGraphFactory.createWDiGraphFromTextFile(WeightedDigraph);
        DijkstraSP<String> stringDijkstraSP = new DijkstraSP();


        System.out.println();
        System.out.println("Dijkstra : ");
        System.out.println();


        /* Choose the nodes corresponding to your graph */

        stringDijkstraSP.DijkstraSP(wDiGraphString, "1");
        stringDijkstraSP.shortestPath("7");
        stringDijkstraSP.distTo("7");

        System.out.println();
        System.out.println("DFS : ");


        System.out.println("DFS result from A (weighted graph) : " + dfs.dfsWD(wDiGraphString, "0"));
        System.out.println("DFS result from F (weighted graph) : " + dfs.dfsWD(wDiGraphString, "5"));
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
        DiGraph diGraphInteger = integerGraphFactory.createDiGraphFromTextFile(DiGraph);
        WDiGraph wDiGraphInteger = integerGraphFactory.createWDiGraphFromTextFile(WeightedDigraph);
        DijkstraSP<Integer> integerDijkstraSP = new DijkstraSP<>();

        System.out.println();
        System.out.println("Dijkstra : ");
        System.out.println();

        integerDijkstraSP.DijkstraSP(wDiGraphInteger, 1);
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
