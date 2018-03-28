package 蓝桥.Match2;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        int matrix[][] = new int[3][3];
        int base[][] = new int[3][3];
        int last[][] = new int[3][3];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = scanner.nextInt();
                base[i][j] = matrix[i][j];
                last[i][j] = base[i][j];
            }
        }
        for (int m = 0; m < 4; m++) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int temp = 0;
                    for (int k = 0; k < 3; k++) {
                        temp += last[i][k] * base[k][j];
                    }
                    matrix[i][j] = temp;
                }
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    last[i][j] = matrix[i][j];
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}
