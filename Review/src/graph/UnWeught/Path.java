package graph.UnWeught;

import UnweightedGraph.Graph;

import java.util.Arrays;
import java.util.Stack;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-15
 * @Time: 15:43
 * To change this template use File | Settings | File Templates.
 * @desc 求单源路径
 */
public class Path {
    private Graph graph;
    private boolean visited[];
    private int from[];
    private int s;//起点

    public Path(int s, Graph graph) {
        this.graph = graph;
        visited = new boolean[graph.getVertexNum()];
        from = new int[graph.getVertexNum()];
        Arrays.fill(from, -1);
        this.s = s;
        from[s] = s;
        dfs(s);
    }

    private void dfs(int s) {
        if (visited[s])
            return;
        for (int v : graph.adj(s)) {
            if (!visited[v]) {
                visited[s] = true;
                from[v] = s;
                dfs(v);
            }
        }
    }


    public Vector<Integer> getPath(int v) {//获取从s到v的路径
        if (hasPath(v)) {
            Vector<Integer> path = new Vector<>();//路径
            Stack<Integer> temp = new Stack<>();
            while (v != s) {
                temp.push(v);
                v = from[v];
            }
            temp.push(v);
            while (!temp.empty()) {
                path.add(temp.pop());
            }
            return path;

        } else return null;


    }

    public boolean hasPath(int v) {
        return visited[v];
    }

    public void showpath(int v) {
        Vector<Integer> path = getPath(v);
        if (path != null) {
            for (int i : path) {
                System.out.print(i + "  ");
            }
            System.out.println();
        } else {
            System.out.println("没有该路径" + s + "->" + v);
        }


    }


}
