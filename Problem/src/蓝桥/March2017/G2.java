package 蓝桥.March2017;

import java.util.Arrays;
import java.util.Scanner;

public class G2 {
    public static void main(String[] args) {
        long nums[] = {0, 1, 26, 676, 17576, 456976, 11881376, 308915776};//对应位数的进制是多少
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        if (n < 27) {
            System.out.println((char) ('A' + n - 1));
        } else {
            int len = 2;
            int now_min = 27;
            for (int i = 3; i < 8 && n >= now_min + nums[i]; i++, len++) {
                now_min += nums[i];
            }
            int transform[] = new int[len];//每一位初始为A，表示第i位加几
            long now = now_min;//当前值
            for (int i = len; i >= 1; i--) {
                long temp = now - nums[i];//确定第len-i位的值，先减去该位的值
                for (int j = 2; j <= 26 && temp + j * nums[i] <= n; j++) {//如果第len-i位是j
                    transform[len - i]++;
                }
                now += transform[len - i] * nums[i];//加上第len-i位的值
            }
            for (int i : transform) {
                System.out.print((char) ('A' + i));//打印
            }
        }

    }
}
