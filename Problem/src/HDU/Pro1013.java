package HDU;

import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-26
 * @Time: 15:40
 * To change this template use File | Settings | File Templates.
 * @desc
 */
public class Pro1013 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new InputStreamReader(System.in));
        String line;
        while (true) {
            line = in.nextLine();
            if (line.length() == 1 && Integer.parseInt(line) == 0) break;
            while (true) {
                long temp = 0;
                for (String i : line.split("")) {
                    temp += Integer.parseInt(i);
                }
                if (temp < 10) {
                    System.out.println(temp);
                    break;
                } else {
                    line = String.valueOf(temp);
                }
            }
        }
    }
}
