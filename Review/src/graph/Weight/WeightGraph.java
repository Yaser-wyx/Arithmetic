package graph.Weight;


public interface WeightGraph {
    int getVertexNum();

    int getEdgeNum();

    void addEdge(Edge edge);

    boolean hasEdge(int v, int w);

    Iterable<Edge> adj(int v);

    void show();
}
