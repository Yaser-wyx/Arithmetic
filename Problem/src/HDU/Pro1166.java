package HDU;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-25
 * @Time: 21:15
 * To change this template use File | Settings | File Templates.
 * @desc
 */

class segTree {
    private int[] arr;
    private int[] sum;

    segTree(int l, int r, int[] arr) {
        this.arr = arr;
        sum = new int[(r - l) << 2];
        build(l, r, 0);
    }

    void PushUp(int rt) {
        sum[rt] = sum[rt * 2 + 1] + sum[rt * 2 + 2];
    }

    void build(int l, int r, int rt) {
        if (l == r) {
            sum[rt] = arr[l];
            return;
        }
        int m = (l + r) >> 1;
        build(l, m, rt * 2 + 1);
        build(m + 1, r, rt * 2 + 2);
        PushUp(rt);
    }

    void update(int p, int add, int l, int r, int rt) {
        if (l == r) {
            sum[rt] += add;
            return;
        }

        int m = (l + r) >> 1;
        if (p > m) {
            update(p, add, m + 1, r, rt * 2 + 2);
        } else {
            update(p, add, l, m, rt * 2 + 1);
        }
        PushUp(rt);
    }

    int query(int L, int R, int l, int r, int rt) {
        if (L <= l && R >= r) {
            return sum[rt];
        }
        int m = (l + r) >> 1;
        int res = 0;
        if (L <= m) res += query(L, R, l, m, rt * 2 + 1);
        if (R > m) res += query(L, R, m + 1, r, rt * 2 + 2);
        return res;

    }
}

public class Pro1166 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());//几组数据
        for (int i = 1; i <= T; i++) {
            System.out.println("Case " + i + ":");
            int n = Integer.parseInt(br.readLine());//多少个工兵营地
            int nums[] = new int[n + 1];

            String cache[] = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                nums[j] = Integer.parseInt(cache[j - 1]);
            }
            segTree segmentTree = new segTree(1, n, nums);
            int a, b;

            String line = br.readLine();//命令
            String order = line.split(" ")[0];


            while (!order.equals("End")) {
                a = Integer.parseInt(line.split(" ")[1]);
                b = Integer.parseInt(line.split(" ")[2]);
                switch (order) {
                    case "Add":
                        segmentTree.update(a, b, 1, n, 0);
                        break;
                    case "Sub":
                        segmentTree.update(a, -b, 1, n, 0);
                        break;
                    case "Query":
                        System.out.println(segmentTree.query(a, b, 1, n, 0));
                        break;
                    default:
                        break;
                }
                line = br.readLine();//命令
                order = line.split(" ")[0];
            }
        }
    }
}
