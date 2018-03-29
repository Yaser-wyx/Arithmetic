package 蓝桥.March2017;

import java.util.Arrays;
import java.util.Scanner;

public class H {
    static int n;
    static int A[];

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    static int ngcd() {
        int a = A[0];
        int b = A[1];
        int c = gcd(a, b);
        for (int i = 2; i < A.length; i++) {
            c = gcd(c, A[i]);
        }
        return c;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        if (ngcd() != 1) {
            System.out.println("INF");
            return;
        }
        int len = 105 * 105;
        int dp[] = new int[len];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = A[i]; j < len; j++) {
                dp[j] = Math.max(dp[j], dp[j - A[i]] + A[i]);
            }
        }

        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (dp[i] < 0) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
