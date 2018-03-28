package 蓝桥.Match1;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        int size = 0;
        Scanner scanner = new Scanner(System.in);
        while (true) {

            String[] s = scanner.nextLine().split("");
            int nums[] = new int[18];
            for (int i = 0; i < 17; i++) {
                nums[i] = Integer.parseInt(s[i]);
            }
            int check = 0;
            int xishu[] = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
            for (int i = 0; i < 17; i++) {
                int temp = nums[i] * xishu[i];
                check += temp;
            }
            int z = check % 11;
            String ss[] = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
            if (!ss[z].equals(s[17])) {
                size++;
                System.out.println(size);
            }

        }
    }
}
