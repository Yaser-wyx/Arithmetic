package MST;

import WeightedGraph.Edge;
import WeightedGraph.WeightGraph;
import my_heap.Index_MinHeap;

import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-10
 * @Time: 10:17
 * To change this template use File | Settings | File Templates.
 * @desc 正版prim算法
 */
public class Prim<Weight extends Number & Comparable> {
    private Index_MinHeap<Weight> index_minHeap;//辅助数据结构最小索引堆，用于保存到每个节点最小的权重
    private boolean[] marked;//是否访问过
    private WeightGraph<Weight> graph;//图
    private Number weight = 0.0;//权值
    private Vector<Edge<Weight>> mst;//最小生成树的边
    private Edge<Weight>[] edgeto;//保存到每个节点所经过的横切边

    public Prim(WeightGraph graph) {//初始化
        this.graph = graph;
        marked = new boolean[graph.getVertexNum()];
        mst = new Vector<>();
        edgeto = new Edge[graph.getVertexNum()];
        index_minHeap = new Index_MinHeap<>(graph.getVertexNum());
        //Prim算法
        visit(0);//访问起点
        while (!index_minHeap.isEmpty()) {//最小索引堆是否为空
            int index = index_minHeap.extractMinIndex();//从堆中拿出最小的边，该边一定是到对应节点的最小横切边
            assert edgeto[index] != null;
            mst.add(edgeto[index]);//将边加入到最小生成树中
            visit(index);//访问该节点
        }

        for (Edge<Weight> edge : mst) {//访问生成树中每一条边
            weight = (double) weight + edge.getWeight().doubleValue();//将每一条边的权值相加，获取整棵树的权值
        }
    }

    private void visit(int v) {//访问
        assert !marked[v];
        marked[v] = true;//标记该节点已经访问过

        for (Edge<Weight> edge : graph.adj(v)) {//遍历v节点的每一条边
            int w = edge.other(v);//获取与v节点同一边的另一节点w
            if (!marked[w]) {//如果w节点没有访问过，表示这是一个横切边

                if (edgeto[w] == null) {//如果还没有到w节点的边
                    //表示该节点还没有与之对应的横切边
                    edgeto[w] = edge;//将该边作为横切边保存
                    index_minHeap.insert(w, edge.getWeight());//保存到w节点的权重到最小索引堆
                } else if (edge.getWeight().compareTo(edgeto[w].getWeight()) < 0) {//当前的横切边的权重小于之前保存的横切边
                    edgeto[w] = edge;//更新数据
                    index_minHeap.change(w, edge.getWeight());//将新的横切边权重的值保存到相应节点
                }

            }
        }

    }

    public Vector<Edge<Weight>> getMst() {
        return mst;
    }

    public Number getWeight() {
        return weight;
    }
}
