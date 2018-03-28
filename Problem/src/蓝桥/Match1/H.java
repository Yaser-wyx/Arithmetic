package 蓝桥.Match1;

import java.util.Scanner;

public class H {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int index = 1;
        int map[][] = new int[n][m];
        int line = 1;
        for (int j = 0; j < m; j++) {
            if (line % 2 == 1) {
                //从上到下
                for (int i = 0; i < n; i++) {
                    map[i][j] = index++;
                }
            } else {
                //从下到上
                for (int i = n - 1; i >= 0; i--) {
                    map[i][j] = index++;
                }
            }
            line++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j]);
                if (j != m - 1) {
                    System.out.print(" ");
                }
            }
            if (i != n - 1) {
                System.out.println();
            }
        }
    }
}
