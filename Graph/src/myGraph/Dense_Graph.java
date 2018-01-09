package myGraph;

import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-07
 * @Time: 19:00
 * To change this template use File | Settings | File Templates.
 * @desc 稠密图 使用邻接矩阵实现
 */
public class Dense_Graph implements Graph {
    private int vertexNum;//顶点数
    private int edgeNum;//边数
    private boolean directed;//表示是否为有向图
    private boolean[][] g;//邻接矩阵


    public Dense_Graph(int vertexNum, boolean directed) {//初始化
        this.vertexNum = vertexNum;
        this.directed = directed;
        this.edgeNum = 0;
        g = new boolean[vertexNum][vertexNum];

    }

    public int getVertexNum() {//返回顶点数
        return vertexNum;
    }

    public int getEdgeNum() {//返回边数
        return edgeNum;
    }

    public void addEdge(int v, int w) {//添加一条边
        assert v >= 0 && v < vertexNum && w >= 0 && w < vertexNum;
        //如果v和w已经有边则不进行添加
        if (!hasEdge(v, w)) {

            g[v][w] = true;
            if (!directed) {
                //如果是无向图
                g[w][v] = true;
            }
            edgeNum++;
        }


    }

    public boolean hasEdge(int v, int w) {
        return g[v][w];//判断v和w之间是否有边
    }

    public Iterable<Integer> adj(int v) {
        assert v >= 0 && v < vertexNum;
        Vector<Integer> adjV = new Vector<>();
        for (int i = 0; i < vertexNum; i++) {
            if (g[v][i]) {
                adjV.add(i);
            }
        }
        return adjV;
    }

    public void show() {
        for (int i = 0; i < vertexNum; i++) {
            for (int j = 0; j < vertexNum; j++) {
                System.out.print(g[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
