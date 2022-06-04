package Graph;

import Edge.Edge;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class GraphFactory<V extends Comparable<V>> {
    public abstract <V extends Comparable<V>> DiGraph createDiGraphFromTextFile(String path) throws FileNotFoundException;
    public abstract <V extends Comparable<V>> WDiGraph createWDiGraphFromTextFile(String path) throws FileNotFoundException;
}
