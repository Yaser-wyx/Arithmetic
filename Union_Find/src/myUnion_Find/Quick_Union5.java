package myUnion_Find;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-06
 * @Time: 18:48
 * To change this template use File | Settings | File Templates.
 * @desc union find 的优化版本，采用了路径压缩(递归版)
 */
public class Quick_Union5 {


    private int[] parent;
    private int count;
    private int[] rank;

    public Quick_Union5(int n) {
        count = n;
        rank = new int[count];
        parent = new int[count];
        for (int i = 0; i < count; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int p) {
        if (parent[p] != p) {

            parent[p] = find(parent[p]);
        }
        return parent[p];
    }

    public void union(int p, int q) {

        int p_Parent = find(p);
        int q_Parent = find(q);


        if (p_Parent != q_Parent) {
            if (rank[p_Parent] < rank[q_Parent]) {
                parent[p_Parent] = q_Parent;

            } else if (rank[p_Parent] > rank[q_Parent]) {
                parent[q_Parent] = p_Parent;
            } else {
                parent[q_Parent] = p_Parent;
                rank[p_Parent]++;
            }
        }
    }

    public boolean isConnected(int p, int q) {
        return find(q) == find(p);

    }
}
