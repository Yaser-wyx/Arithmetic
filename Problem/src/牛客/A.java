package 牛客;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-02-09
 * @Time: 19:19
 * To change this template use File | Settings | File Templates.
 * @desc
 */
public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            double ta = in.nextDouble();
            double tb = in.nextDouble();
            double xa = Math.cos(ta);
            double ya = Math.sin(ta);
            double xb = Math.cos(tb);
            double yb = Math.sin(tb);
            String yes = "clockwise";
            String no = "counterclockwise";
            //判断象限
            if (xa <= 0 && ya >= 0) {
                //第二象限
                if (xb > xa && yb >= -ya) {
                    System.out.println(yes);
                } else {
                    System.out.println(no);
                }
            } else if (xa <= 0 && ya <= 0) {
                //第三象限
                if (xb <= -xa && yb > ya) {
                    System.out.println(yes);
                } else {
                    System.out.println(no);
                }
            } else if (xa >= 0 && ya >= 0) {
                //第一象限
                if (xb >= -xa && yb < ya) {
                    System.out.println(yes);
                } else {
                    System.out.println(no);
                }
            } else {
                //第四象限
                if (xb < xa && yb <= -ya) {
                    System.out.println(yes);
                } else {
                    System.out.println(no);
                }
            }
        }
    }
}
