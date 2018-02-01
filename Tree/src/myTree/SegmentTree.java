package myTree;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-23
 * @Time: 22:00
 * To change this template use File | Settings | File Templates.
 * @desc 线段树 可以用于求区间最大值，最小值以及求和
 */
public class SegmentTree {
    private Node[] Tree;//使用数组表达线段树
    private int[] arry;//传入的数组

    private class Node {
        int left, right;//左右区间
        int value;//区间最值
        int add;//标记
    }

    public SegmentTree(int[] arry, int l, int r) {
        Tree = new Node[(r - l) * 4];
        for (int i = 0; i < Tree.length; i++) {
            Tree[i] = new Node();
        }
        this.arry = arry;
        build(0, l, r);
    }

    /**
     * 构建线段树
     *
     * @param rt 当前节点索引
     * @param l  区间
     * @param r  区间
     */
    private void build(int rt, int l, int r) {
        //初始化该节点的区间值
        Tree[rt].left = l;
        Tree[rt].right = r;
        if (l == r) {//如果是叶子节点则赋值
            Tree[rt].value = arry[l];
        } else {
            //否则，构建它的左右子区间
            int mid = (l + r) / 2;
            build(rt * 2 + 1, l, mid);
            build(rt * 2 + 2, mid + 1, r);
            Tree[rt].value = Tree[rt * 2 + 1].value + Tree[rt * 2 + 2].value;
        }
    }

    /**
     * 查询操作
     *
     * @param rt 当前节点索引
     * @param l  查询区域左边边界
     * @param r  查询区域右边边界
     * @return 查询的结果
     */
    public int query(int rt, int l, int r) {

        if (Tree[rt].left >= l && Tree[rt].right <= r) {
            //查询区间在当前节点的区间内
            return Tree[rt].value;
        }
        pushDown(rt);//在查询的时候查看是否需要将节点更新
        int mid = Tree[rt].left + ((Tree[rt].right - Tree[rt].left) / 2);
        int res = 0;
        if (l <= mid) {//如果查询区有一部分在左半区间
            res += query(rt * 2 + 1, l, r);//到该节点的左半区间查找
        }

        if (r > mid) {//如果查询区有一部分在右半区间
            res += query(rt * 2 + 2, l, r);//到该节点的右半区间查找
        }
        return res;//返回查询结果

    }

    /**
     * 单点更新
     *
     * @param i    更新的点
     * @param data 更新的值
     * @param rt   当前节点索引
     */
    public void update_one(int i, int data, int rt) {
        if (Tree[rt].left == Tree[rt].right && Tree[rt].left == i) {//找到了要更新的节点
            Tree[rt].value += data;
            return;
        }
        int mid = Tree[rt].left + ((Tree[rt].right - Tree[rt].left) / 2);
        if (i <= mid) {
            //左子树
            update_one(i, data, rt * 2 + 1);
        } else {
            //右子树
            update_one(i, data, rt * 2 + 2);
        }
        Tree[rt].value = Tree[rt * 2 + 1].value + Tree[rt * 2 + 2].value;//回溯处理
    }

    /**
     * 将当前节点的更新应用到左右子节点上
     *
     * @param rt 当前节点
     */

    private void pushDown(int rt) {
        if (Tree[rt].add != 0) {
            Tree[rt * 2 + 2].add += Tree[rt].add;//给左右子节点加上要更新的值，因为孩子节点可能多次延迟更新，所以要+=
            Tree[rt * 2 + 1].add += Tree[rt].add;
            Tree[rt * 2 + 1].value += (Tree[rt * 2 + 1].right - Tree[rt * 2 + 1].left + 1) * Tree[rt].add;//将这个区间整体的值加上data
            Tree[rt * 2 + 2].value += (Tree[rt * 2 + 2].right - Tree[rt * 2 + 2].left + 1) * Tree[rt].add;
            Tree[rt].add = 0;//标记清除
        }
    }

    /**
     * 更新区间
     *
     * @param L    要更新区间的左值
     * @param R    要更新区间的右值
     * @param data 要更新的值
     * @param rt   当前节点
     */
    public void update(int L, int R, int data, int rt) {
        if (L <= Tree[rt].left && R >= Tree[rt].right) {//当前区间在要更新的区间内部
            Tree[rt].add += data;
            Tree[rt].value += (Tree[rt].right - Tree[rt].left + 1) * data;//将这个区间整体的值加上data
            return;
        }
        pushDown(rt);//将标记下传
        int mid = Tree[rt].left + ((Tree[rt].right - Tree[rt].left) / 2);
        if (L <= mid) {
            //更新左子树部分
            update(L, R, data, rt * 2 + 1);
        }

        if (R > mid) {
            //更新右子树部分
            update(L, R, data, rt * 2 + 2);
        }

        Tree[rt].value = Tree[rt * 2 + 1].value + Tree[rt * 2 + 2].value;//回溯处理
    }
}
