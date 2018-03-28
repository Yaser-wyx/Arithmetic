package 蓝桥.Match2;

import java.util.Scanner;

public class I {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long c = scanner.nextLong();
        long ans1 = 1;
        long ans2 = 2;
        long mod = 1000000007;
        for (long i = 3; i <= n; i++) {
            long temp = ((a % mod) * ans2 % mod) % mod + ((b % mod) * (ans1) % mod + c % mod) % mod;
            ans1 = ans2;
            ans2 = temp;
        }
        System.out.println(ans2);
    }
}
