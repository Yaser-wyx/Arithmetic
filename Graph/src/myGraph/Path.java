package myGraph;

import java.util.Arrays;
import java.util.Stack;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-08
 * @Time: 15:17
 * To changed this template use File | Settings | File Templates.
 * @desc 图的路径查找
 */
public class Path {
    private Graph graph;
    private boolean visted[];//某节点是否访问过了
    private int[] from;//保存的路径
    private boolean find;//保存从起点到终点的路径是否已经找到了

    public Path(Graph graph) {//初始化，传进来一张图
        assert graph != null;
        this.graph = graph;
    }

    //深度优先搜索
    private void dfs(int v, int w) {//查找从起点v到终点w之间的路径
        assert v >= 0 && v < graph.getVertexNum();
        visted[v] = true;//表示该节点已经访问过了。
        if (v == w) {//如果当前访问的就是终点，则返回
            find = true;//已经找到了
            return;
        }

        for (int i : graph.adj(v)) {//对v周围节点进行访问
            if (!visted[i]) {//如果未访问过则进行访问
                if (find)//如果已经找到了路径则无需再遍历
                    return;
                from[i] = v;//保存是从哪个节点访问这个被访问节点的
                dfs(i, w);
            }
        }
    }


    public boolean hasPath(int v, int w) {//判断v和w之间是否有路径
        assert w >= 0 && w < graph.getVertexNum();
        find = false;//将该变量初始化为未找到
        visted = new boolean[graph.getVertexNum()];//每次遍历前都要初始化
        from = new int[graph.getVertexNum()];
        Arrays.fill(from, -1);//填充
        dfs(v, w);
        return visted[w];//如果访问过了则表示有路径，否则就没有
    }

    public Vector<Integer> getpath(int v, int w) {//获取从v到w的路径
        Vector<Integer> path = new Vector<>();//最终返回的路径
        if (hasPath(v, w)) {//先判断有没有路径

            Stack<Integer> stack = new Stack<>();//设置一个栈
            int p = w;
            while (p != v && p != -1) {
                stack.push(p);//将路径从后向前放入栈中
                p = from[p];
            }
            stack.push(p);

            while (!stack.empty()) {
                path.add(stack.pop());//将路径顺序再倒过来
            }
        }
        return path;//返回路径
    }

    public void showpath(int v, int w) {

        Vector<Integer> vector = getpath(v, w);//获取路径
        if (vector != null) {
            for (int i = 0; i < vector.size(); i++) {//打印
                System.out.print(vector.elementAt(i));
                if (i != vector.size() - 1) {
                    System.out.print("->");
                }
            }
            System.out.println();

        } else {
            System.out.println(v + "到" + w + "之间没有路径");
        }
    }
}
