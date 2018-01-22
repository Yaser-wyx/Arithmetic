package graph.Weight;

import WeightedGraph.WeightGraph;
import WeightedGraph.Edge;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-16
 * @Time: 23:07
 * To change this template use File | Settings | File Templates.
 * @desc 最短路径算法
 */
public class Bellman_Ford {
    private WeightGraph<Double> graph;
    private double distTo[];
    private int s;
    private Edge<Double> from[];

    public Bellman_Ford(WeightGraph<Double> graph, int s) {
        this.graph = graph;
        this.s = s;
        from = new Edge[graph.getVertexNum()];
        distTo = new double[graph.getVertexNum()];

    }

    private void __Bellman() {
        for (int pass = 1; pass < graph.getVertexNum() - 1; pass++) {
            for (int v = 0; v < graph.getVertexNum() - 1; v++) {
                for (Edge<Double> edge : graph.adj(v)) {
                    int w = edge.other(v);
                    if (from[v] != null) {
                        if (from[w] == null || distTo[w] > distTo[v] + edge.getWeight()) {
                            distTo[w] = distTo[v] + edge.getWeight();
                            from[w] = edge;
                        }
                    }
                }
            }
        }
    }
}