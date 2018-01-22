package graph.Weight;


import Union_find.UnionFind;
import WeightedGraph.Edge;
import WeightedGraph.WeightGraph;
import my_heap.MinHeap;

import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-16
 * @Time: 17:16
 * To change this template use File | Settings | File Templates.
 * @desc 最小生成树 kruskal版
 */
public class Kruskal {
    private double weight = 0.0;
    private Vector<Edge<Double>> mst;

    public Kruskal(WeightGraph<Double> graph) {
        MinHeap<Edge<Double>> minHeap = new MinHeap(graph.getEdgeNum());//存放所有的边，所以要开辟边数的空间
        for (int i = 0; i < graph.getVertexNum(); i++) {
            for (Edge<Double> edge : graph.adj(i)) {
                if (edge.getV() < edge.getW())
                    minHeap.insert(edge);
            }
        }
        mst = new Vector<>();
        UnionFind unionFind = new UnionFind(graph.getVertexNum());
        while (!minHeap.isEmpty() && mst.size() < graph.getVertexNum() - 1) {
            Edge<Double> edge = minHeap.extractMin();
            if (!unionFind.isConnected(edge.getV(), edge.getW())) {
                unionFind.union(edge.getV(), edge.getW());
                mst.add(edge);
            }
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
}
