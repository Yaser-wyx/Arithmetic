package graph.Weight;

import WeightedGraph.WeightGraph;
import my_heap.Index_MinHeap;
import WeightedGraph.Edge;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-16
 * @Time: 18:41
 * To change this template use File | Settings | File Templates.
 * @desc 有向带权图 最短路径
 */
public class Dijkstra {
    private WeightGraph<Double> graph;
    private boolean visited[];
    private int s;//起点
    private Edge<Double> from[];
    private double distTo[];
    private Index_MinHeap<Double> minHeap;

    public Dijkstra(WeightGraph<Double> graph, int s) {
        this.graph = graph;
        this.s = s;
        visited = new boolean[graph.getVertexNum()];
        from = new Edge[graph.getVertexNum()];
        distTo = new double[graph.getVertexNum()];
        minHeap = new Index_MinHeap<>(graph.getVertexNum());
        __Dijkstra();
    }

    private void __Dijkstra() {
        from[s] = new Edge<>(s, s, 0.0);
        distTo[s] = 0.0;
        minHeap.insert(s, 0.0);
        while (!minHeap.isEmpty()) {
            int v = minHeap.extractMinIndex();
            visited[v] = true;
            for (Edge<Double> edge : graph.adj(v)) {
                int w = edge.other(v);
                if (!visited[w]) {
                    if (from[w] == null || distTo[w] > distTo[v] + edge.getWeight()) {
                        distTo[w] = distTo[v] + edge.getWeight();
                        from[w] = edge;
                        if (minHeap.exist(w)) {
                            minHeap.change(w, distTo[w]);
                        } else {
                            minHeap.insert(w, distTo[w]);
                        }

                    }
                }
            }
        }
    }
}
