package 蓝桥.March2017;
import java.util.Scanner;

public class G {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line[] = scanner.nextLine().split("/");
        int days[] = new int[3];

        //年月日  月日年  日月年
        for (int i = 0; i < 3; i++) {
            days[i] = Integer.parseInt(line[i]);
        }

        if (days[0] < days[2]) {
            //输出最小的年份
            System.out.println("200" + days[0] + "-0" + days[1] + "-0" + days[2]);
            if (days[0] < days[1]) {
                System.out.println("200" + days[2] + "-0" + days[0] + "-0" + days[1]);
                System.out.println("200" + days[2] + "-0" + days[1] + "-0" + days[0]);
            }
        } else {
            if (days[0] < days[1]) {
                System.out.println("200" + days[2] + "-0" + days[0] + "-0" + days[1]);
                System.out.println("200" + days[2] + "-0" + days[1] + "-0" + days[0]);

            } else {
                System.out.println("200" + days[2] + "-0" + days[1] + "-0" + days[0]);
                System.out.println("200" + days[2] + "-0" + days[0] + "-0" + days[1]);
            }
            System.out.println("200" + days[0] + "-0" + days[1] + "-0" + days[2]);
        }


    }
}
