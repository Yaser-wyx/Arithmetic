package WeightedGraph;

import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-07
 * @Time: 19:00
 * To change this template use File | Settings | File Templates.
 * @desc 稠密图 使用邻接矩阵实现 有权图
 */
public class DenseWeight_Graph<Wegight extends Number & Comparable> implements WeightGraph {
    private int vertexNum;//顶点数
    private int edgeNum;//边数
    private boolean directed;//表示是否为有向图
    private Edge<Wegight>[][] g;//邻接矩阵


    public DenseWeight_Graph(int vertexNum, boolean directed) {//初始化
        this.vertexNum = vertexNum;
        this.directed = directed;
        this.edgeNum = 0;
        g = new Edge[vertexNum][vertexNum];
    }

    @Override
    public int getVertexNum() {//返回顶点数
        return vertexNum;
    }

    @Override
    public int getEdgeNum() {//返回边数
        return edgeNum;
    }

    @Override
    public void addEdge(Edge edge) {//添加一条边
        assert edge != null;
        assert edge.getV() >= 0 && edge.getV() < vertexNum;
        assert edge.getW() >= 0 && edge.getW() < vertexNum;

        if (!hasEdge(edge.getV(), edge.getW())) {
            g[edge.getV()][edge.getW()] = new Edge(edge);
            if (!directed && edge.getV() != edge.getW()) {
                g[edge.getW()][edge.getV()] = new Edge(edge.getW(), edge.getV(), edge.getWeight());
            }
            edgeNum++;

        }


    }

    @Override
    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < vertexNum && w >= 0 && w < vertexNum;
        return g[v][w] != null;//判断v和w之间是否有边
    }

    @Override
    public Iterable<Edge<Wegight>> adj(int v) {//返回v相邻节点边的迭代器
        assert v >= 0 && v < vertexNum;

        Vector<Edge<Wegight>> vector = new Vector<>();
        for (int i = 0; i < vertexNum; i++) {
            if (g[v][i] != null) {
                vector.add(g[v][i]);
            }
        }
        return vector;

    }

    @Override
    public void show() {//打印
        for (int i = 0; i < vertexNum; i++) {
            for (int j = 0; j < vertexNum; j++) {
                if (g[i][j] != null) {
                    System.out.printf("%#.2f\t", g[i][j].getWeight());
                } else {
                    System.out.print("NULL\t");
                }

            }
            System.out.println();
        }
    }
}
