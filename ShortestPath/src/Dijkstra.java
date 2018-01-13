import WeightedGraph.Edge;
import WeightedGraph.WeightGraph;
import my_heap.Index_MinHeap;

import java.util.Stack;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-10
 * @Time: 18:15
 * To change this template use File | Settings | File Templates.
 * @desc Dijkstra算法实现 求单源最短路径
 */
public class Dijkstra<Weight extends Number & Comparable> {
    private WeightGraph<Weight> graph;//传入的图
    private boolean[] marked;//用于标记是否被访问过
    private int s;//起点
    private Number[] distTo;//distTo[i]记录从起点到i的最短路径的权值
    private Edge<Weight>[] from;//from[i]记录从哪一条边到达该点的

    public Dijkstra(WeightGraph<Weight> graph, int s) {//初始化
        this.graph = graph;
        assert s >= 0 && s < graph.getVertexNum();
        this.s = s;
        marked = new boolean[graph.getVertexNum()];
        distTo = new Number[graph.getVertexNum()];
        from = new Edge[graph.getVertexNum()];
        for (int i = 0; i < graph.getVertexNum(); i++) {
            marked[i] = false;
            distTo[i] = 0.0;
        }

        Index_MinHeap<Weight> minHeap = new Index_MinHeap<>(graph.getVertexNum());//存放从起点到每个点的所需的最小费用
        //初始化起点
        distTo[s] = 0.0;
        marked[s] = true;
        from[s] = new Edge<>(s, s, (Weight) (Object) 0.0);
        minHeap.insert(s, (Weight) distTo[s]);//将起点加入到最小索引堆中

        while (!minHeap.isEmpty()) {//不断循环，直到堆中没有数据为止
            int v = minHeap.extractMinIndex();//获取到最小权值边对应的节点
            marked[v] = true;//标记该点已经访问过了
            //松弛操作
            for (Edge<Weight> edge : graph.adj(v)) {//遍历该节点周围的边
                int w = edge.other(v);//获取这个邻边端点是谁
                if (!marked[w]) {//判断该节点是否访问过

                    if (from[w] == null ||//确保还没有边可以到达该节点
                            (distTo[v].doubleValue() + edge.getWeight().doubleValue()) < distTo[w].doubleValue()) {//判断以该节点作为中间节点，是否可以使到达该节点的费用减少
                        //如果可以则进行更新操作
                        distTo[w] = distTo[v].doubleValue() + edge.getWeight().doubleValue();//将当前的最小值赋给distTo
                        from[w] = edge;//更新该点是从哪边遍历来的
                        if (minHeap.exist(w)) {//如果该点已经在堆中了
                            //改变值
                            minHeap.change(w, (Weight) distTo[w]);
                        } else {
                            //插入值
                            minHeap.insert(w, (Weight) distTo[w]);
                        }
                    }
                }


            }
        }


    }

    public Vector<Edge<Weight>> getPath(int w) {
        assert w >= 0 && w < graph.getVertexNum();
        assert hasPath(w);
        Vector<Edge<Weight>> path = new Vector<>();
        Stack<Edge<Weight>> temp = new Stack<>();
        Edge<Weight> edge = from[w];
        while (edge.getV() != s) {
            temp.push(edge);
            edge = from[edge.getV()];
        }
        temp.push(edge);//该处将起点加入进来

        while (!temp.empty()) {
            path.add(temp.pop());
        }

        return path;
    }

    public Number getDistTo(int w) {
        assert hasPath(w);
        return distTo[w];
    }

    public boolean hasPath(int w) {
        assert w >= 0 && w < graph.getVertexNum();
        return marked[w];

    }

    void showPath(int w) {

        assert w >= 0 && w < graph.getVertexNum();
        assert hasPath(w);

        Vector<Edge<Weight>> path = getPath(w);
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.elementAt(i).getV() + " -> ");
            if (i == path.size() - 1)
                System.out.println(path.elementAt(i).getW());
        }
    }
}
