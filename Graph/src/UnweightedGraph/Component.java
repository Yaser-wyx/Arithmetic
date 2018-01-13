package UnweightedGraph;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-07
 * @Time: 21:47
 * To change this template use File | Settings | File Templates.
 * @desc 求图的连通分量
 */
public class Component {
    private int count;//连通分量的个数
    private boolean[] visted;//用于保存该元素是否被访问过了
    private Graph graph;//传入的图
    private int[] id;//表示该节点所属的连通分量是哪一个

    public Component(Graph graph) {
        this.graph = graph;
        count = 0;
        id = new int[graph.getVertexNum()];
        Arrays.fill(id, -1);//填充id为-1
        visted = new boolean[graph.getVertexNum()];

        //搜索连通分量
        for (int i = 0; i < graph.getVertexNum(); i++) {//遍历一遍图
            if (!visted[i]) {//如果该节点没有访问过
                dfs(i);//使用dfs对与该节点相连的节点全部访问一遍
                count++;//访问完count加一，同时进入下一个循环
            }
        }
    }

    public int getCount() {//获取连通分量的个数
        return count;
    }

    private void dfs(int v) {
        visted[v] = true;//设置该节点已经访问过了
        id[v] = count;//在同一个连通分量里面的节点，id是一致的。
        for (int g : graph.adj(v)) {//使用我们之前实现的迭代器，对与该节点相邻的节点遍历
            if (!visted[g]) {//如果该节点未访问过就进行访问，否则继续循环
                dfs(g);
            }

        }
    }

    public boolean isConnected(int v, int w) {//判断两个节点是否连通，只需要判断二者的连通分量id是否一致即可
        assert v >= 0 && v < graph.getVertexNum();
        assert w >= 0 && w < graph.getVertexNum();
        return id[v] == id[w];
    }


}
