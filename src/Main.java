import Algorithm.*;
import Graph.*;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {


        String WeightedDigraph = "metro.txt";
        String DiGraph = "graph-DFS-BFS.txt";


        DFS dfs = new DFS();

        System.out.println("Here, everything works with Strings : ");

        GraphFactory<String> stringGraphFactory = new StringGraphFactory();
        DiGraph diGraphString = stringGraphFactory.createDiGraphFromTextFile(DiGraph);
        WDiGraph wDiGraphString = stringGraphFactory.createWDiGraphFromTextFile(WeightedDigraph);
        DijkstraSP stringDijkstraSP = new DijkstraSP();

        /* Choose the nodes corresponding to your graph */
        System.out.println();
        System.out.println("Dijkstra : ");
        System.out.println();

        Long starttime = System.nanoTime();
        stringDijkstraSP.DijkstraSP(wDiGraphString, "7");
        stringDijkstraSP.shortestPath("1");
        stringDijkstraSP.distTo("1");
        Long endtime = System.nanoTime();
        System.out.println("Dijkstra Execution Time : " + (endtime - starttime));


        starttime = System.nanoTime();
        BellmanFord bellmanFord = new BellmanFord<>(wDiGraphString, "7");

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("BellmanFord : ");
        bellmanFord.printSP("21");
        endtime = System.nanoTime();
        System.out.println("BellmanFord Execution Time : " + (endtime - starttime));
        System.out.println();


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

        WeightedDigraph = "metro.txt";

        GraphFactory<Integer> integerGraphFactory = new IntegerGraphFactory();
        DiGraph diGraphInteger = integerGraphFactory.createDiGraphFromTextFile(DiGraph);
        WDiGraph wDiGraphInteger = integerGraphFactory.createWDiGraphFromTextFile(WeightedDigraph);
        DijkstraSP integerDijkstraSP = new DijkstraSP<>();

        System.out.println();
        System.out.println("Dijkstra : ");
        System.out.println();

        integerDijkstraSP.DijkstraSP(wDiGraphInteger, 7);
        integerDijkstraSP.shortestPath(1);
        integerDijkstraSP.distTo(1);


        BellmanFord bellmanFord1 = new BellmanFord<>(wDiGraphInteger, 7);

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("BellmanFord : ");
        bellmanFord1.printSP(21);

        System.out.println();
        System.out.println("DFS : ");

        System.out.println("DFS result from 0 (weighted graph) : " + dfs.dfsWD(wDiGraphInteger, 0));
        System.out.println("DFS result from 5 (weighted graph) : " + dfs.dfsWD(wDiGraphInteger, 5));
        System.out.println("DFS result from 0 (unweighted graph) : " + dfs.dfs(diGraphInteger, 0));
        System.out.println("DFS result from 5 (unweighted graph) : " + dfs.dfs(diGraphInteger, 5));
    }
}
