import Algorithm.*;
import Graph.*;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        DFS dfs = new DFS();

        System.out.println("Here, everything works with Strings : ");

        GraphFactory<String> stringGraphFactory = new StringGraphFactory();
        DiGraph diGraphString = stringGraphFactory.createDiGraphFromTextFile("graph-DFS-BFS.txt");
        WDiGraph wDiGraphString = stringGraphFactory.createWDiGraphFromTextFile("WDG-Letters.txt");
        DijkstraSP<String> stringDijkstraSP = new DijkstraSP();


        System.out.println();
        System.out.println("Dijkstra : ");
        System.out.println();


        stringDijkstraSP.DijkstraSP(wDiGraphString, "A");
        stringDijkstraSP.shortestPath("D");
        stringDijkstraSP.distTo("D");

        System.out.println();
        System.out.println("DFS : ");


        System.out.println("DFS result from A (weighted graph) : " + dfs.dfsWD(wDiGraphString, "A"));
        System.out.println("DFS result from F (weighted graph) : " + dfs.dfsWD(wDiGraphString, "F"));
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
        WDiGraph wDiGraphInteger = integerGraphFactory.createWDiGraphFromTextFile("graph-WDG.txt");
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
