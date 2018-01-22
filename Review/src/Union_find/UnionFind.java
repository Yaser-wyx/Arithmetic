package Union_find;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-15
 * @Time: 14:54
 * To change this template use File | Settings | File Templates.
 * @desc 并查集
 */
public class UnionFind {
    private int[] parent;
    private int count;
    private int rank[];

    public UnionFind(int size) {
        count = size;
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int p) {
        while (parent[p] != p) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int p_parent = find(p);
        int q_parent = find(q);
        if (q_parent != p_parent) {
            if (rank[p_parent] > rank[q_parent]) {
                parent[q_parent] = p_parent;
            } else if (rank[p_parent] < rank[q_parent]) {
                parent[p_parent] = q_parent;
            } else {
                rank[p_parent]++;
                parent[q_parent] = p_parent;
            }
        }
    }
}
