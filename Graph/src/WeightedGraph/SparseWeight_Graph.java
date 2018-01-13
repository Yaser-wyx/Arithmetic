package WeightedGraph;

import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-07
 * @Time: 18:59
 * To change this template use File | Settings | File Templates.
 * @desc 稀疏图 使用邻接表来实现 有权图
 */
public class SparseWeight_Graph<Weight extends Number & Comparable> implements WeightGraph {
    private int vertexNum;//顶点数
    private int edgeNum;//边数
    private boolean directed;//是否是有向图
    private Vector<Edge<Weight>>[] g;//使用邻接表存储图

    public SparseWeight_Graph(int vertexNum, boolean directed) {//初始化邻接表
        this.vertexNum = vertexNum;
        this.directed = directed;
        this.edgeNum = 0;
        g = new Vector[vertexNum];//初始化g数组
        for (int i = 0; i < vertexNum; i++) {
            g[i] = new Vector<>();//为每一个vector初始化
        }
    }

    public int getVertexNum() {
        return vertexNum;
    }

    public int getEdgeNum() {
        return edgeNum;
    }

    @Override
    public void addEdge(Edge edge) {
        assert edge.getW() >= 0 && edge.getW() < vertexNum;
        assert edge.getV() >= 0 && edge.getV() < vertexNum;

        g[edge.getV()].add(new Edge(edge));
        if (!directed && edge.getW() != edge.getV()) {
            g[edge.getW()].add(new Edge(edge.getW(), edge.getV(), edge.getWeight()));
        }
        edgeNum++;

    }


    @Override
    public boolean hasEdge(int v, int w) {
        for (int i = 0; i < g[v].size(); i++) {
            if (g[v].elementAt(i).other(v) == w) {
                return true;
            }
        }
        return false;
    }

    public Iterable<Edge<Weight>> adj(int v) {//返回v相邻节点边的迭代器
        assert v >= 0 && v < vertexNum;
        return g[v];//直接返回v这个链表即可。
    }

    public void show() {//打印图
        for (int i = 0; i < vertexNum; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < g[i].size(); j++) {
                System.out.print(g[i].elementAt(j) + "\t");
            }
            System.out.println();
        }
    }
}
