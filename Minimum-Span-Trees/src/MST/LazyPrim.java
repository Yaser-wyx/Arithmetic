package MST;

import WeightedGraph.Edge;
import WeightedGraph.WeightGraph;
import my_heap.MinHeap;

import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-09
 * @Time: 20:23
 * To change this template use File | Settings | File Templates.
 * @desc prim算法的简易版
 */
public class LazyPrim<Weight extends Number & Comparable> {
    private MinHeap<Edge<Weight>> minHeap;//最小堆，辅助数据结构
    private WeightGraph<Weight> graph;//图
    private boolean[] marked;//标记该节点是否访问过了
    private Vector<Edge<Weight>> mst;//最小生成树的边
    private Number weight;//整棵树的最小权值

    public LazyPrim(WeightGraph<Weight> graph) {
        this.graph = graph;//初始化
        minHeap = new MinHeap<>(graph.getEdgeNum());
        marked = new boolean[graph.getVertexNum()];
        mst = new Vector<>();
        weight = 0.0;

        //LazyPrim
        visited(0);//从起点开始遍历
        while (!minHeap.isEmpty()) {//如果最小堆未空，则对堆中每一条边进行遍历
            Edge<Weight> edge = minHeap.extractMin();//从堆中取出一条最小边
            if (!marked[edge.getW()] || !marked[edge.getV()]) {//判断两个点是否被访问过了，都访问过则将该边丢弃
                mst.add(edge);//是最小横切边，将其添加到最小生成树中
                //访问该边未访问过的节点
                if (!marked[edge.getW()]) {
                    visited(edge.getW());
                } else {
                    visited(edge.getV());
                }
            }
        }

        for (Edge edge : mst) {//将整棵树的权值相加
            weight = (double) weight + (double) edge.getWeight();
        }
    }

    private void visited(int v) {//辅助方法
        assert !marked[v];
        marked[v] = true;//标记已访问该节点
        for (Edge<Weight> edge : graph.adj(v)) {//对该点周围每一条边进行遍历
            if (!marked[edge.other(v)]) {//如果另一个节点还没有访问过
                minHeap.insert(edge);//该边为横切边，但未必是最小横切边，先将其添加到最小堆中
            }
        }
    }

    public Vector<Edge<Weight>> getMst() {//获取最小生成树
        return mst;
    }

    public Number getWeight() {//获取最小生成树的权值
        return weight;
    }
}
