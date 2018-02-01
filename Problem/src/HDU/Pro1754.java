package HDU;

import java.io.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-25
 * @Time: 18:18
 * To change this template use File | Settings | File Templates.
 * @desc
 */
public class Pro1754 {
    private static final int maxn = 200000;
    private static int[] max = new int[maxn << 2];
    static Scanner in = new Scanner(new InputStreamReader(System.in));

    static void pushUp(int rt) {
        max[rt] = Math.max(max[rt << 1], max[rt << 1 | 1]);
    }

    static void build(int l, int r, int rt) {
        if (l == r) {
            max[rt] = in.nextInt();
            return;
        }
        int mid = (l + r) >> 1;
        build(l, mid, rt << 1);
        build(mid + 1, r, rt << 1 | 1);
        pushUp(rt);
    }

    static int query(int L, int R, int l, int r, int rt) {
        if (L <= l && R >= r) {
            return max[rt];
        }
        int mid = (l + r) >> 1;
        int res = 0;
        if (L <= mid) res = Math.max(res, query(L, R, l, mid, rt << 1));
        if (R > mid) res = Math.max(res, query(L, R, mid + 1, r, rt << 1 | 1));
        return res;

    }

    static void update(int p, int add, int l, int r, int rt) {
        if (l == r) {
            max[rt] = add;
            return;
        }

        int mid = (l + r) >> 1;
        if (p > mid) update(p, add, mid + 1, r, rt << 1 | 1);
        else update(p, add, l, mid, rt << 1);
        pushUp(rt);
    }

    public static void main(String[] args)  {
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.hasNext()) {
            int n = in.nextInt();//人数
            int options = in.nextInt();//操作次数
            build(1, n, 1);//建树
            for (int i = 0; i < options; i++) {
                String c = in.next();
                int a = in.nextInt();
                int b = in.nextInt();
                if (c.equals("Q")) {
                    printWriter.write(query(a, b, 1, n, 1) + "\n");
                    printWriter.flush();
                } else {
                    update(a, b, 1, n, 1);
                }
            }
        }
        printWriter.close();
    }
}
