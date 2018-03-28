package 蓝桥.Match1;

import java.util.Scanner;

public class J {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long k = scanner.nextLong();
        if (k == 1) {
            System.out.print("Impossible");
            return;
        }
        for (long n = 2; n <= k; n++) {
            for (long m = n - 1; m >= 1; m--) {
                long temp = 1;
                for (long j = m + 1; j <= n; j++) {
                    temp *= j;
                }
                if (temp > 2000000000) {
                    break;
                }
                if (temp == k) {
                    System.out.print(n + " " + m);
                    return;
                }
            }
        }
        System.out.print("Impossible");
    }
}
