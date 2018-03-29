package 蓝桥.Practise;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        boolean prime[] = new boolean[n + 1];
        Arrays.fill(prime, true);
        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }
        int sum = 0;
        for (int y = 3; y < n; y++) {
            if (prime[y]) {
                for (int x = 3; x <= y; x++) {
                    if (prime[x] && x + y == n) {
                        sum++;
                    }
                }
            }
        }

        System.out.println(sum);
    }
}
