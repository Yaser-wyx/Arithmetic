package UnweightedGraph;

public interface Graph {
    int getVertexNum();

    int getEdgeNum();

    void addEdge(int v, int w);

    boolean hasEdge(int v, int w);

    Iterable<Integer> adj(int v);

    void show();
}
