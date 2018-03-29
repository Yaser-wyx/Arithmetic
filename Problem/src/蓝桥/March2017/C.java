package 蓝桥.March2017;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = 1;
        int n = 29;
        double now[] = new double[30];
        double ans[] = new double[30];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < len; j++) {
                now[j] = scanner.nextDouble();
            }

            for (int j = 0; j < len; j++) {
                ans[j] += now[j] / 2;
                ans[j + 1] += now[j] / 2;
            }
            len++;
        }
        for (int i = 0; i <= n; i++) {
            System.out.print(ans[i] + " ");

        }

    }
}
