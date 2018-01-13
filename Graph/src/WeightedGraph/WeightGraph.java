package WeightedGraph;

public interface WeightGraph<Weight extends Number & Comparable> {
    int getVertexNum();

    int getEdgeNum();

    void addEdge(Edge<Weight> edge);

    boolean hasEdge(int v, int w);

    Iterable<Edge<Weight>> adj(int v);

    void show();
}
