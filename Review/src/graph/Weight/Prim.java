package graph.Weight;

import Heap.IndexMinHeap;
import WeightedGraph.Edge;
import WeightedGraph.WeightGraph;

import java.util.Vector;


/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-16
 * @Time: 14:10
 * To change this template use File | Settings | File Templates.
 * @desc Prim 最小生成树算法
 */
public class Prim {
    private WeightGraph<Double> graph;
    private Edge<Double>[] edges;
    private IndexMinHeap minHeap;
    private double weight;
    private Vector<Edge<Double>> mst;
    private boolean visited[];

    public Prim(WeightGraph<Double> graph) {
        this.graph = graph;
        edges = new Edge[graph.getVertexNum()];
        minHeap = new IndexMinHeap(graph.getVertexNum());
        weight = 0.0;
        mst = new Vector<>();
        visited = new boolean[graph.getVertexNum()];

        visit(0);
        while (!minHeap.isEmpty()) {
            int index = minHeap.extractMinIndex();
            mst.add(edges[index]);
            visit(index);
        }

        for (Edge<Double> edge : mst) {
            weight = weight + edge.getWeight();
        }
    }

    public double getWeight() {
        return weight;
    }

    public Vector<Edge<Double>> getMst() {
        return mst;
    }

    public void show() {
        for (int i = 0; i < mst.size(); i++) {
            if (i != mst.size() - 1) {
                System.out.print(mst.elementAt(i) + "->");
            } else System.out.println(mst.elementAt(i));
        }
    }

    private void visit(int v) {
        visited[v] = true;
        for (Edge<Double> edge : graph.adj(v)) {
            int w = edge.other(v);
            if (!visited[w]) {
                if (edges[w] == null) {
                    edges[w] = edge;
                    minHeap.insert(w, edge.getWeight());
                } else if (edges[w].getWeight() > edge.getWeight()) {
                    edges[w] = edge;
                    minHeap.change(w, edge.getWeight());
                }
            }
        }
    }
}
