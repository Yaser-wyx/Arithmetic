package myGraph;

import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-07
 * @Time: 18:59
 * To change this template use File | Settings | File Templates.
 * @desc 稀疏图 使用邻接表来实现
 */
public class Sparse_Graph implements Graph {
    private int vertexNum;//顶点数
    private int edgeNum;//边数
    private boolean directed;//是否是有向图
    private Vector<Integer>[] g;//使用邻接表存储图

    public Sparse_Graph(int vertexNum, boolean directed) {//初始化邻接表
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

    public void addEdge(int v, int w) {//添加边
        assert v >= 0 && v < vertexNum;
        assert w >= 0 && w < vertexNum;

        if (!hasEdge(v, w)) {//如果边存在则不添加
            g[v].add(w);
            if (!directed && v != w) {//如果是无向图
                g[w].add(v);
            }
            edgeNum++;
        }

    }

    @Override
    public boolean hasEdge(int v, int w) {
        for (int i = 0; i < g[v].size(); i++) {
            if (g[v].elementAt(i) == w) {
                return true;
            }
        }
        return false;
    }

    public Iterable<Integer> adj(int v) {//返回v相邻节点的迭代器
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
