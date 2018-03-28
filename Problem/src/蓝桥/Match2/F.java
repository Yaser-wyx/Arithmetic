package 蓝桥.Match2;

import java.util.Scanner;

public class F {
    static int dp[][] = new int[1001][1001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 20; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            dp[l][r] = 1;//初始化
        }
        for (int len = 1; len < 1000; len++) {//区间长度
            for (int l = 1; l + len <= 1000; l++) {//区间左端点
                int r = l + len;//区间右端点
                for (int m = l + 1; m <= r; m++) {//将区间从中间进行分割
                    dp[l][r] = Math.max(dp[l][m] + dp[m][r], dp[l][r]);
                }
            }
        }
        System.out.println(dp[1][1000]);
    }
}
