package myGraph;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-08
 * @Time: 16:24
 * To change this template use File | Settings | File Templates.
 * @desc 使用BFS 求图的最短路径
 */
public class ShortestPath {

    private Graph graph;//图
    private boolean[] visted;//是否被访问
    private int[] from;//保存一个节点到起点的路径中，它的父节点是哪个
    private int[] ord;//计数，保存该节点到起点最短路径的长度

    public ShortestPath(Graph graph) {//初始化
        assert graph != null;
        this.graph = graph;

    }

    private void bfs(int v, int w) {//使用广度优先，遍历与起点v相连的节点
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(v);//将起点添加到队列中
        visted[v] = true;//设为已经访问过
        while (!queue.isEmpty()) {//直到队列为空
            int s = queue.poll();//将队列顶的元素抛出
            Vector<Integer> vector = (Vector<Integer>) graph.adj(s);//将该节点元素周围的所有元素进行访问
            for (int i : vector) {
                if (!visted[i]) {//如果该节点元素没有访问
                    visted[i] = true;//设置为已访问
                    from[i] = s;//保存是从哪个节点访问这个被访问节点的
                    ord[i] = ord[s] + 1;//计数加一
                    queue.add(i);//将该节点加入到队列中，在下一次while循环中将开始访问该节点周围所有的节点
                }
                if (i == w) {//如果i这个节点已经是终点，则不需要再访问其他节点了。
                    return;
                }

            }
        }
    }

    public int MinLength(int v, int w) {//返回两个节点间最短路径的长度
        if (hasPath(v, w)) {
            return ord[w];
        } else {
            return 0;
        }
    }

    public boolean hasPath(int v, int w) {//v与w之间是否有路径
        assert w >= 0 && w < graph.getVertexNum();
        //初始化
        visted = new boolean[graph.getVertexNum()];
        from = new int[graph.getVertexNum()];
        ord = new int[graph.getVertexNum()];
        Arrays.fill(from, -1);
        Arrays.fill(ord, 0);

        bfs(v, w);
        return visted[w];//如果访问过了则表示有路径，否则就没有
    }

    public Vector<Integer> getPath(int v, int w) {
        //获取从v到w的路径
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

    public void showPath(int v, int w) {

        Vector<Integer> vector = getPath(v, w);//获取路径
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
