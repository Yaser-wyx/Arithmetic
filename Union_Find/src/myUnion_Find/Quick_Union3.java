package myUnion_Find;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-06
 * @Time: 18:27
 * To change this template use File | Settings | File Templates.
 * @desc union find 的优化版本，基于rank的优化
 */
public class Quick_Union3 {
    private int[] parent;
    private int count;
    private int[] rank;

    public Quick_Union3(int n) {
        count = n;
        rank = new int[count];
        parent = new int[count];
        for (int i = 0; i < count; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int p) {
        while (parent[p] != p) {
            p = parent[p];
        }
        return p;
    }

    public void union(int p, int q) {

        int p_Parent = find(p);//找到p的根节点
        int q_Parent = find(q);//找到q的根节点

        if (p_Parent != q_Parent) {//如果不在一个集合内部
            //判断哪一棵树的深度大
            if (rank[p_Parent] < rank[q_Parent]) {
                parent[p_Parent] = q_Parent;//p的深度小于q，则将p附加在q上
            } else if (rank[p_Parent] > rank[q_Parent]) {
                parent[q_Parent] = p_Parent;//p的深度大于q，则将q附加在p上
            } else {
                parent[q_Parent] = p_Parent;//两者深度一样，附加方式随意
                rank[p_Parent]++;//这里，我们选择将q附加在p上，所以更新p的深度，加一。
            }
        }
    }

    public boolean isConnected(int p, int q) {
        return find(q) == find(p);
    }
}
