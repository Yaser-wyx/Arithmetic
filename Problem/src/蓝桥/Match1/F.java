package 蓝桥.Match1;

import java.util.Scanner;

public class F {

    private static int x = 11;
    private static int nums[] = new int[x];
    private static boolean res = false;
    private static void judge(int n, int index) {
        if (n < 0) {
            return;
        }
        if (n == 0) {
            res = true;
            return;
        }
        for (int i = index; i < x && !res; i++) {
            judge(n - nums[i], i + 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        for (int i = 0; i < x; i++) {
            nums[i] = scanner.nextInt();
            sum += nums[i];
        }
        for (int i = 1; i <= sum; i++) {
            res = false;
            judge(i, 0);
            if (!res) {
                System.out.println(i);
            }
        }
    }
}
