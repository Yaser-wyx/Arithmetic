package graph.UnWeught;

import UnweightedGraph.Graph;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-16
 * @Time: 10:48
 * To change this template use File | Settings | File Templates.
 * @desc 单源最短路径
 */
public class ShortestPath {
    private int from[];
    private boolean visited[];
    private Graph graph;
    private int s;

    public ShortestPath(Graph graph, int s) {
        this.s = s;
        this.graph = graph;
        from = new int[graph.getVertexNum()];
        visited = new boolean[graph.getVertexNum()];
        Arrays.fill(from, -1);
        from[s] = s;
        bfs(s);

    }

    private void bfs(int s) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(s);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int w : graph.adj(v)) {
                if (!visited[w]) {
                    visited[w] = true;
                    from[w] = v;
                    queue.add(w);
                }
            }
        }
    }

    public Vector<Integer> getPath(int w) {
        if (hasPath(w)) {
            Vector<Integer> path = new Vector<>();
            Stack<Integer> temp = new Stack<>();
            while (w != s) {
                temp.add(w);
                w = from[w];
            }
            temp.add(w);
            while (!temp.isEmpty()) {
                path.add(temp.pop());
            }
            return path;
        } else return null;
    }

    public boolean hasPath(int w) {
        return visited[w];

    }

    public void show(int w) {
        Vector<Integer> path = getPath(w);
        if (path != null) {
            for (int i : path) {
                System.out.print(i + "  ");
            }
            System.out.println();
        } else {
            System.out.println("没有该路径" + s + "->" + w);
        }

    }
}
