package myUnion_Find;

import org.apache.commons.lang3.RandomUtils;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-06
 * @Time: 17:14
 * To change this template use File | Settings | File Templates.
 * @desc
 */
public class Main {
    public static void main(String[] args) {
        int num = 1000000;
        Main main = new Main();
        int[] a = new int[num];
        int[] b = new int[num];
        int[] c = new int[num];
        int[] d = new int[num];
        for (int i = 0; i < num; i++) {
            a[i] = RandomUtils.nextInt(0, num - 1);
            b[i] = RandomUtils.nextInt(0, num - 1);
            c[i] = RandomUtils.nextInt(0, num - 1);
            d[i] = RandomUtils.nextInt(0, num - 1);
        }
        main.test5(num, a, b, c, d);

        main.test4(num, a, b, c, d);


    }

    void test5(int num, int[] a, int[] b, int[] c, int[] d) {
        long time = System.currentTimeMillis();
        Quick_Union5 quick_union5 = new Quick_Union5(num);
        for (int i = 0; i < num; i++) {

            quick_union5.union(a[i], b[i]);

        }

        for (int i = 0; i < num; i++) {

            quick_union5.isConnected(c[i], d[i]);
        }
        System.out.println("quick_union5所耗时间为：" + (System.currentTimeMillis() - time));
    }


    void test1(int num, int[] a, int[] b, int[] c, int[] d) {

        long time = System.currentTimeMillis();
        Quick_Find quick_find = new Quick_Find(num);
        for (int i = 0; i < num; i++) {
            quick_find.union(a[i], b[i]);

        }

        for (int i = 0; i < num; i++) {

            quick_find.isConnected(c[i], d[i]);
        }
        System.out.println("quick_find所耗时间为：" + (System.currentTimeMillis() - time));
    }


    void test3(int num, int[] a, int[] b, int[] c, int[] d) {

        long time = System.currentTimeMillis();
        Quick_Union3 quick_union3 = new Quick_Union3(num);
        for (int i = 0; i < num; i++) {

            quick_union3.union(a[i], b[i]);

        }

        for (int i = 0; i < num; i++) {

            quick_union3.isConnected(c[i], d[i]);
        }
        System.out.println("quick_union3所耗时间为：" + (System.currentTimeMillis() - time));
    }

    void test2(int num, int[] a, int[] b, int[] c, int[] d) {

        long time = System.currentTimeMillis();
        Quick_Union2 quick_union2 = new Quick_Union2(num);
        for (int i = 0; i < num; i++) {

            quick_union2.union(a[i], b[i]);

        }

        for (int i = 0; i < num; i++) {

            quick_union2.isConnected(c[i], d[i]);
        }
        System.out.println("quick_union2所耗时间为：" + (System.currentTimeMillis() - time));
    }

    void test4(int num, int[] a, int[] b, int[] c, int[] d) {

        long time = System.currentTimeMillis();
        Quick_Union4 quick_union4 = new Quick_Union4(num);
        for (int i = 0; i < num; i++) {

            quick_union4.union(a[i], b[i]);

        }

        for (int i = 0; i < num; i++) {

            quick_union4.isConnected(c[i], d[i]);
        }
        System.out.println("quick_union4所耗时间为：" + (System.currentTimeMillis() - time));
    }

}
