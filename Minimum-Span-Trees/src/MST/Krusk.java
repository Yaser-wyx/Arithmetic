package MST;

import WeightedGraph.Edge;
import WeightedGraph.WeightGraph;
import myUnion_Find.Quick_Union5;
import my_heap.MinHeap;

import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-10
 * @Time: 16:25
 * To change this template use File | Settings | File Templates.
 * @desc krusk算法实现
 */
public class Krusk<Weight extends Number & Comparable> {
    private Vector<Edge<Weight>> Mst;//最小生成树
    private Number weight = 0.0;//整棵树的权值

    public Krusk(WeightGraph<Weight> graph) {
        Mst = new Vector<>();//初始化最小生成树

        MinHeap<Edge<Weight>> minHeap = new MinHeap<>(graph.getEdgeNum());//用于存放图中的每一条边
        for (int i = 0; i < graph.getVertexNum(); i++) {//遍历图中每一个节点
            for (Edge<Weight> edge : graph.adj(i)) {//将每一个节点周围的临边进行遍历
                if (edge.getV() < edge.getW()) {//确保边只加入一次
                    minHeap.insert(edge);//将每一条边插入到最小堆中
                }
            }
        }
        Quick_Union5 union = new Quick_Union5(graph.getVertexNum());//使用并查集来判断生成树是否有环
        while (!minHeap.isEmpty() && Mst.size() < graph.getVertexNum() - 1) {//不断循环直到堆中没有边或生成树中边的个数等于顶点数-1
            Edge<Weight> edge = minHeap.extractMin();//获取到图中最小边
            if (!union.isConnected(edge.getV(), edge.getW())) {//使用并查集判断该边的两个是否已经相连
                union.union(edge.getV(), edge.getW());//将两者连接
                Mst.add(edge);//将该边添加到最小生成树中
            }
        }

        //计算权值
        for (Edge<Weight> edge : Mst) {
            weight = (double) weight + edge.getWeight().doubleValue();
        }

    }


    public Vector<Edge<Weight>> getMst() {
        return Mst;
    }

    public Number getWeight() {
        return weight;
    }
}
