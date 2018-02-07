package HDU;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-31
 * @Time: 18:41
 * To change this template use File | Settings | File Templates.
 * @desc
 */
public class solve {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        String line1[] = in.nextLine().split("");
        String line2[] = in.nextLine().split("");
        String options[] = in.nextLine().split("");
        String[] temp = new String[9];
        for (String s : options) {
            switch (s) {
                case "A":
                    temp = A(line1);
                    break;
                case "B":
                    temp = B(line1);
                    break;
                case "C":
                    temp = C(line1);
                    break;
            }
            line1 = temp;
        }

        for (String s : line1) {
            System.out.print(s);
        }

    }

    private static String[] A(String[] num) {//操作A：上下两行互换
        String temp[] = new String[8];
        int j = 7;
        for (int i = 0; i < 8; i++) {
            temp[i] = num[j--];
        }
        return temp;
    }

    private static String[] B(String[] num) {//操作B：每行同时循环右移一格
        String temp[] = new String[8];

        int j = 3;
        for (int i = 0; i < 4; i++) {
            temp[i] = num[j++];
            if (j == 4) j = 0;
        }
        j = 5;
        for (int i = 4; i < 8; i++) {
            temp[i] = num[j++];
            if (j == 8) j = 4;
        }
        return temp;
    }

    private static String[] C(String[] num) {//操作C：中间4个方块顺时针旋转一格
        String temp[] = new String[8];
        System.arraycopy(num, 0, temp, 0, 8);
        temp[1] = num[6];
        temp[2] = num[1];
        temp[5] = num[2];
        temp[6] = num[5];
        return temp;
    }
   /* public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while (true) {
            int now = in.nextInt();//当前x的位置
            in.nextLine();
            String map[] = in.nextLine().split(" ");//原始
            String line = in.nextLine();
            if (line.equals("unsolvable")) {
                System.out.println("unsolvable");
                continue;
            }
            String step[] = line.split("");//步骤

            for (int i = 0; i < step.length; i++) {
                switch (step[i]) {
                    case "u":
                        map[now] = map[now - 3];
                        map[now - 3] = "x";
                        now -= 3;
                        break;
                    case "l":
                        map[now] = map[now - 1];
                        map[now - 1] = "x";
                        now -= 1;
                        break;
                    case "r":
                        map[now] = map[now + 1];
                        map[now + 1] = "x";
                        now += 1;
                        break;
                    case "d":
                        map[now] = map[now + 3];
                        map[now + 3] = "x";
                        now += 3;
                        break;
                }
            }

            for (String s : map) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }*/
}
