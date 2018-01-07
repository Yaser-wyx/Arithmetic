package myUnion_Find;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-06
 * @Time: 17:34
 * To change this template use File | Settings | File Templates.
 * @desc union find 的优化版本，使用树形结构
 */
public class Quick_Union implements Union_Find {
    private int[] parent;//所有集合元素用数组表示，索引表示元素，值表示该元素的父节点(不同处)
    private int count;//元素个数

    public Quick_Union(int n) {
        count = n;
        parent = new int[count];
        for (int i = 0; i < count; i++) {
            parent[i] = i;//一个元素就是一个集合

        }
    }

    public int find(int p) {//查找p所在的集合
        assert p >= 0 && p < count;
        int p_parent = parent[p];//
        while (parent[p_parent] != p_parent) {//不断地向上查找父节点，直到根节点，因为根节点指向自己
            p_parent = parent[p_parent];//将p_parent的父节点赋值给p_parent，从而可以不断向上搜索
        }
        return p_parent;//此时p_parent已经指向了p的根节点
    }

    public void union(int p, int q) {//合并两个集合

        int p_Parent = find(p);//找到p元素的根节点
        int q_Parent = find(q);//找到q元素的根节点

        if (p_Parent != q_Parent) {//如果不在一个集合内
            parent[p_Parent] = q_Parent;//将一方的根节点赋值给另一方
        }
    }

    public boolean isConnected(int p, int q) {
        return find(q) == find(p);//判断是否连接
    }
}
