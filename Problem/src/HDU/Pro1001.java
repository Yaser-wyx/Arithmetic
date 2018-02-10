package HDU;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-02-08
 * @Time: 21:18
 * To change this template use File | Settings | File Templates.
 * @desc
 */
public class Pro1001 {
    public static void main(String[] args) {
        long num;
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while (in.hasNext()) {
            num = in.nextLong();
            System.out.println(((1 + num) * num) / 2);
            System.out.println();
        }
    }
}
