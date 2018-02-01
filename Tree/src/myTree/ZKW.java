package myTree;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-25
 * @Time: 22:59
 * To change this template use File | Settings | File Templates.
 * @desc 非递归版线段树
 */
public class ZKW {
    private int[] tree;
    private int M;

    public ZKW(int n, int arr[]) {

        int j = 0;
        tree = new int[n << 2];
        for (M = 1; M <= n + 1; M <<= 1) ;
        for (int i = M + 1; i <= M + n; i++) tree[i] = arr[j++];
        for (int i = M - 1; i != 0; i--) pushUp(i);
    }

    private void pushUp(int rt) {
        tree[rt] = tree[rt << 1] + tree[rt << 1 | 1];
    }

    public void update(int p, int data) {
        p += M;
        tree[p] = data;
        for (p >>= 1; p != 0; p >>= 1) pushUp(p);
    }

    public int query(int l, int r) {
        int res = 0;

        for (l = l + M - 1, r = r + M + 1; (l ^ r ^ 1) != 0; l >>= 1, r >>= 1) {
            if ((~l & 1) != 0) {
                res += tree[l ^ 1];
            }
            if ((r & 1) != 0) {
                res += tree[r ^ 1];
            }
        }

        return res;

    }

}
