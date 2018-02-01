package HDU;

import java.io.BufferedInputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-26
 * @Time: 23:11
 * To change this template use File | Settings | File Templates.
 * @desc
 */
public class Pro1002 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);
        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            String num[] = line.split(" ");
            BigInteger num1 = new BigInteger(num[0]);
            BigInteger num2 = new BigInteger(num[1]);
            printWriter.println("Case " + (i + 1) + ":");
            printWriter.print(num1 + " + " + num2 + " = ");
            printWriter.println(num1.add(num2));
            if (i != n - 1) printWriter.println();
            printWriter.flush();
        }


    }
}
