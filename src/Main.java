import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        GraphFactory<String> graphFactory = new GraphFactory<>();
        Digraph myDiGraph = graphFactory.createDiGraphFromTextFile("graph-DFS-BFS.txt");
        DFS myDfs = new DFS<>();
        WDigraph myWDiGraph = graphFactory.createWDiGraphFromTextFile("graph-WDG.txt");
        DijkstraSP dijkstraSP = new DijkstraSP();

        dijkstraSP.DijkstraSP(myWDiGraph, "3");
        dijkstraSP.shortestPath("3", "5");



        System.out.println("DFS result from 0 (weighted graph) : " + myDfs.dfsWD(myWDiGraph, "0"));
        System.out.println("DFS result from 5 (weighted graph) : " + myDfs.dfsWD(myWDiGraph, "5"));
        System.out.println("DFS result from 0 (unweighted graph) : " + myDfs.dfs(myDiGraph, "0"));
        System.out.println("DFS result from 5 (unweighted graph) : " + myDfs.dfs(myDiGraph, "5"));

    }
}
