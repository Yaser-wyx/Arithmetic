package 蓝桥.Practise;

import java.util.Scanner;
//两仪剑法
public class A {
    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int res = n * m / gcd(Math.max(n, m), Math.min(n, m));
            System.out.println(res);
        }
    }
}
