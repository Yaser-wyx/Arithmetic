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
        while (true) {
            int now = in.nextInt();//当前x的位置
            in.nextLine();
            String map[] = in.nextLine().split(" {2}");//原始
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
    }
}
