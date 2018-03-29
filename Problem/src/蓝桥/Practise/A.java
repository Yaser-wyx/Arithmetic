package 蓝桥.Practise;

import java.util.Scanner;

//两仪剑法
public class A {
    static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            long n = scanner.nextLong();
            long m = scanner.nextLong();
            long res = n * m / gcd(Math.max(n, m), Math.min(n, m));
            System.out.println(res);
        }
    }
}
