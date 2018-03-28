package 蓝桥.Match1;

import java.util.Scanner;

public class B {
    public static void main(String[] argv) {
        Scanner scanner = new Scanner(System.in);
        int res = 0;
        for (int i = 0; i < 20; i++) {
            int sex = scanner.nextInt();
            int high = scanner.nextInt();
            int weight = scanner.nextInt();
            if (sex == 1) {
                //男
                double stand = (high - 80) * 0.7;
                double low = stand * 0.9;
                double up = stand * 1.1;
                if (weight >= low && weight <= up) {
                    System.out.println(i);
                    res++;
                }
            } else {
                //男
                double stand = (high - 70) * 0.6;
                double low = stand * 0.9;
                double up = stand * 1.1;
                if (weight >= low && weight <= up) {
                    System.out.println(i);
                    res++;
                }
            }
        }
        System.out.println(res);

    }
}
