package HDU;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-30
 * @Time: 16:46
 * To change this template use File | Settings | File Templates.
 * @desc
 */
public class Pro1016 {
    private static boolean[] prime = new boolean[40];
    private static boolean[] visited;
    private static int[] result;
    private static int n;
    private static PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

    private static void init() {
        for (int i = 2; i <= 39; i++) {
            boolean p = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    p = false;
                    break;
                }
            }
            prime[i] = p;
        }
    }

    public static void main(String[] args) {
        init();
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int x = 0;
        while (in.hasNext()) {
            x++;//第几个case

            long time = System.currentTimeMillis();
            n = in.nextInt();
            pw.println("Case " + x + ":");
            if (n == 1) {
                pw.println(1);
                pw.println(1);
                pw.println();
                pw.flush();
                continue;
            }
            if (n % 2 != 0) {
                pw.println();
                pw.flush();
                continue;
            }
            visited = new boolean[n + 1];
            result = new int[n + 1];
            result[1] = 1;
            find(2);
            pw.println();
            pw.flush();
        }
        pw.close();

    }

    private static void find(int index) {
        if (index > n) {
            //找到了一组
            //但还需要进行最后的判断
            if (!prime[result[index - 1] + 1]) return;
            for (int i = 1; i <= n; i++) {
                pw.print(result[i]);
                if (i != n) pw.print(" ");
            }
            pw.println();
            return;
        }
        for (int i = 2; i <= n; i++) {
            int x = result[index - 1] + i;
            if (!visited[i] && prime[x]) {//未访问过且同时是素数
                visited[i] = true;
                result[index] = i;
                find(index + 1);
                visited[i] = false;//回溯处理

            }
        }

    }

}
