package myTree;


import org.apache.commons.lang3.RandomUtils;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-03
 * @Time: 17:17
 * To change this template use File | Settings | File Templates.
 * @desc
 */

public class Main1 {
    public static void main(String[] args) {
        int n = 100;
        int num[] = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = RandomUtils.nextInt(0, 1000);
        }
        ZKW zkw = new ZKW(n, num);
        int l = 13, r = 48;
        System.out.println(zkw.query(l, r));
        int ans = 0;
        for (int i = l; i <= r; i++) {
            ans += num[i - 1];
        }
        System.out.println(ans);
    }
}
