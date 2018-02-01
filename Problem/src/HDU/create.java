package HDU;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-31
 * @Time: 18:53
 * To change this template use File | Settings | File Templates.
 * @desc
 */
public class create {
    /* public static void main(String[] args) {
         Scanner in = new Scanner(new BufferedInputStream(System.in));
         int n = in.nextInt();
         for (int i = 0; i < n; i++) {
             boolean[] visted = new boolean[9];
             StringBuffer stringBuffer = new StringBuffer();
             int start = RandomUtils.nextInt(1, 9);//随机生成起点
             for (int j = 0; j < 9; j++) {
                 if (j == start) {
                     stringBuffer.append("x ");
                     continue;
                 }
                 int x = RandomUtils.nextInt(1, 9);
                 while (visted[x]) x = RandomUtils.nextInt(1, 9);
                 visted[x] = true;
                 stringBuffer.append(x).append(" ");
             }
             System.out.println(stringBuffer);
         }
     }*/
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        File file = new File("C:\\Users\\wanyu\\Desktop\\Test.txt");
        PrintWriter printWriter = new PrintWriter(file);
        int n = in.nextInt();
        printWriter.append(n + "\n");
        for (int i = 0; i < n; i++) {
            int c = RandomUtils.nextInt(1, 100);
            StringBuffer buffer = new StringBuffer();
            buffer.append(c).append("\n");
            for (int j = 0; j < c; j++) {
                String brand = RandomStringUtils.random(10, "adsdhfayfgqwetuioasdfghjkxcvbnm");
                int price = RandomUtils.nextInt(1, 50);
                int capacity = RandomUtils.nextInt(100, 100000);
                buffer.append(brand).append(" ").append(price).append(" ").append(capacity).append("\n");
            }
            printWriter.append(buffer);
        }
        printWriter.flush();
        System.out.println("ok");
    }
}
