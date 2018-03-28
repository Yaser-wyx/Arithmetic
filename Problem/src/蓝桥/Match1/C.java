package 蓝桥.Match1;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {

        int nums[][] = new int[20][2];
        int temp[] = new int[20];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 20; i++) {
            String s = scanner.nextLine();
            String ss[] = s.split("/");
            nums[i][0] = Integer.parseInt(ss[0]);
            nums[i][1] = Integer.parseInt(ss[1]);
            temp[i] = nums[i][1];
        }
        Arrays.sort(temp);
        //求最小公倍数
        BigInteger base = new BigInteger(String.valueOf(temp[0]));
        BigInteger now = new BigInteger(String.valueOf(temp[0]));
        BigInteger zero = new BigInteger("0");
        for (int i = 1; i < 20; i++) {
            BigInteger num = new BigInteger(String.valueOf(temp[i]));
            while (!now.mod(num).equals(zero)) {
                now = now.add(base);
            }
            base = now;
        }
        BigInteger up = new BigInteger("0");
        for (int i = 0; i < 20; i++) {
            BigInteger first = new BigInteger(String.valueOf(nums[i][0]));
            BigInteger second = new BigInteger(String.valueOf(nums[i][1]));
            up = up.add(now.divide(second).multiply(first));
        }
        System.out.println(up + "/" + now);
    }
}
