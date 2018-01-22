package graph.UnWeught;

import UnweightedGraph.Graph;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-15
 * @Time: 15:29
 * To change this template use File | Settings | File Templates.
 * @desc 深度优先遍历求连通分量
 */
public class Component {
    private Graph graph;//传入的图
    private int nums;//连通分量个数
    private boolean visited[];//该节点是否访问过
    private int id[];//所属的连通分量

    public Component(Graph graph) {
        this.graph = graph;
        visited = new boolean[graph.getVertexNum()];
        id = new int[graph.getVertexNum()];
        Arrays.fill(id, -1);
        nums = 0;
        for (int i = 0; i < graph.getVertexNum(); i++) {
            if (!visited[i]) {
                dfs(i);
                nums++;
            }

        }
    }

    private void dfs(int i) {
        visited[i] = true;
        id[i] = nums;
        for (int j : graph.adj(i)) {
            if (!visited[i]) {
                dfs(j);
            }
        }
    }

    public int getNums() {
        return nums;
    }
}
