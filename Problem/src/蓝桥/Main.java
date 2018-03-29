package 蓝桥;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int add = scanner.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        for (int i = 1; i <= add; i++) {
            int k;
            for (k = n - 1; k >= 0 && nums[k - 1] > nums[k]; k--) ;  //定位第一个不可以增加的数
            k--;//最后一个可以增加的数
            int find = nums[k] + 1;
            int k2;
            for (k2 = n - 1; k2 > k; k2--) {
                if (nums[k2] == find) {
                    break;
                }
            }
            int temp = nums[k2];
            nums[k2] = nums[k];
            nums[k] = temp;//交换



        }

    }
}