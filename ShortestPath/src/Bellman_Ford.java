import UnweightedGraph.Graph;
import WeightedGraph.Edge;
import WeightedGraph.WeightGraph;

import java.util.Arrays;
import java.util.Stack;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-10
 * @Time: 22:26
 * To change this template use File | Settings | File Templates.
 * @desc 求图的单源最短路径 有负权边
 */
public class Bellman_Ford<Weight extends Number & Comparable> {
    private WeightGraph<Weight> graph;//图的引用
    private int s;//起点
    private Number[] distTo;//distTo[i]记录从起点到节点V的最短路径的权值
    private Edge<Weight>[] from;//记录该顶点是从哪条边来的
    private boolean hasNegativeCycle;//是否有负权环


    public Bellman_Ford(WeightGraph<Weight> graph, int s) {//初始化
        this.graph = graph;
        this.s = s;
        distTo = new Number[graph.getVertexNum()];
        from = new Edge[graph.getVertexNum()];
        Arrays.fill(from, null);

        //Bellman-Ford算法
        distTo[s] = 0.0;//初始化起点
        from[s] = new Edge<>(s, s, (Weight) (Object) 0.0);

        for (int pass = 1; pass < graph.getVertexNum(); pass++) {//对图遍历V-1次
            //每遍历一次都要对图中的每一条边进行松弛操作
            for (int v = 0; v < graph.getVertexNum(); v++) {//访问图中的每一个节点
                for (Edge<Weight> edge : graph.adj(v)) {//对每一个节点的邻边进行访问
                    if (from[edge.getV()] != null)//判断节点V是否为空，V是每一条有向边的起点
                        if (from[edge.getW()] == null ||//如果节点W为空，表示该有向边还没有访问过
                                distTo[edge.getV()].doubleValue() + edge.getWeight().doubleValue() <
                                        distTo[edge.getW()].doubleValue()) {//判断进过节点V再到节点W是不是花费更少
                            from[edge.getW()] = edge;//是的话进行更新操作
                            distTo[edge.getW()] = distTo[v].doubleValue() + edge.getWeight().doubleValue();

                        }
                }
            }
        }

        hasNegativeCycle = detectNegativeCycle();//在进行一次松弛操作

    }

    private boolean detectNegativeCycle() {
        for (int v = 0; v < graph.getVertexNum(); v++) {//访问图中的每一个节点
            for (Edge<Weight> edge : graph.adj(v)) {//对每一个节点的邻边进行访问
                if (from[edge.getW()] == null ||//判断节点W是否还没有访问过
                        distTo[v].doubleValue() + edge.getWeight().doubleValue() <
                                distTo[edge.getW()].doubleValue()) {//判断是否还有更少的到达节点W
                    return true;//如果有就表明该图存在负权边，即不存在最短路径
                }
            }
        }
        return false;//否则就表明已经找到了图中的最短路径
    }

    public boolean HasNegativeCycle() {
        return hasNegativeCycle;
    }

    public Vector<Edge<Weight>> getPath(int w) {//返回最短路径
        assert w >= 0 && w < graph.getVertexNum();

        Vector<Edge<Weight>> path = new Vector<>();
        if (!hasNegativeCycle) {
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
        }
        return path;
    }

    public Number getDistTo(int w) {
        assert w >= 0 && w < graph.getVertexNum();
        assert !HasNegativeCycle();
        return distTo[w];
    }

    public boolean hasPath(int w) {
        assert w >= 0 && w < graph.getVertexNum();

        return !hasNegativeCycle && from[w] != null;

    }

    public void showPath(int w) {

        assert w >= 0 && w < graph.getVertexNum();
        assert !hasNegativeCycle;

        Vector<Edge<Weight>> path = getPath(w);
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.elementAt(i).getV() + " -> ");
            if (i == path.size() - 1)
                System.out.println(path.elementAt(i).getW());
        }
    }
}
