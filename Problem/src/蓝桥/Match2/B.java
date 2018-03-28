package 蓝桥.Match2;

import java.util.Calendar;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int values[] = new int[20];
        int weight[] = new int[20];
        for (int i = 0; i < 20; i++) {
            weight[i] = scanner.nextInt();
            values[i] = scanner.nextInt();
        }
        int dp[] = new int[501];
        for (int i = 0; i < 20; i++) {
            for (int v = 500; v >= weight[i]; v--) {
                dp[v] = Math.max(dp[v], dp[v - weight[i]] + values[i]);
            }
        }

        System.out.println(dp[500]);

    }
}
