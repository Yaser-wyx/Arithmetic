package myUnion_Find;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-06
 * @Time: 18:25
 * To change this template use File | Settings | File Templates.
 * @desc union find 的优化版本，基于size的优化
 */
public class Quick_Union2 {
    private int[] parent;
    private int count;
    private int[] size;

    public Quick_Union2(int n) {
        count = n;
        size = new int[count];
        parent = new int[count];
        for (int i = 0; i < count; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int p) {
        while (parent[p] != p) {
            p = parent[p];
        }
        return p;
    }

    public void union(int p, int q) {

        int p_Parent = find(p);//先找到p元素的根节点
        int q_Parent = find(q);//先找到q元素的根节点


        if (p_Parent != q_Parent) {//如果不在一个集合内
            if (size[p_Parent] < size[q_Parent]) {//如果p_Parent的子节点数更少
                parent[p_Parent] = q_Parent;//将p_Parent的根节点改为q_Parent的根节点。
                size[q_Parent] += size[p_Parent];//更新size值
            } else {//如果q_Parent的子节点数更少
                parent[q_Parent] = p_Parent;//将q_Parent的根节点改为p_Parent的根节点。
                size[p_Parent] += size[q_Parent];//更新size值
            }
        }
    }

    public boolean isConnected(int p, int q) {
        return find(q) == find(p);

    }
}
