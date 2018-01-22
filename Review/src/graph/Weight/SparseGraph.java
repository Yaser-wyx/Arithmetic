package graph.Weight;

import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-16
 * @Time: 12:05
 * To change this template use File | Settings | File Templates.
 * @desc 邻接链表实现的有权图
 */
public class SparseGraph implements WeightGraph {
    private int VertexNum;//节点数
    private int EdgeNum;//边数
    private Vector<Edge>[] graph;//图
    private boolean directed;//是否为有向图

    public SparseGraph(int vertexNum, boolean directed) {//初始化
        this.VertexNum = vertexNum;
        this.directed = directed;
        graph = new Vector[vertexNum];
        EdgeNum = 0;
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new Vector<>();
        }
    }

    @Override
    public int getVertexNum() {
        return VertexNum;
    }

    @Override
    public int getEdgeNum() {
        return EdgeNum;
    }

    @Override
    public void addEdge(Edge edge) {
        if (!hasEdge(edge.getV(), edge.getW())) {//还没有边，则将边添加
            graph[edge.getV()].add(new Edge(edge));
            if (!directed&&edge.getV()!=edge.getW()){
                graph[edge.getW()].add(new Edge(edge));
            }
        }
    }

    @Override
    public boolean hasEdge(int v, int w) {
        for(Edge edge:graph[v]){
            if (edge.getOther(v)==w){
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterable<Edge> adj(int v) {
        return graph[v];
    }

    @Override
    public void show() {
        for(int i=0 ; i<graph.length ; i++){
            for(int j=0 ; j< graph[i].size(); j++){
                if (j!=graph[i].size()-1){
                    System.out.print(graph[i].elementAt(j) + "->");
                }else System.out.println(graph[i].elementAt(j));
            }
        }
    }
}
