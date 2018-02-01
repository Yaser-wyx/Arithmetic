package HDU;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-26
 * @Time: 15:44
 * To change this template use File | Settings | File Templates.
 * @desc
 */
public class Test {
    public static void main(String[] args) {

        arrange(0, new int[9]);
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

        for (int i = 0; i < 100; i++) {

            for (int s : list.get(i)) {
                System.out.print(s);
            }
            System.out.println();
        }

    }

    private static ArrayList<int[]> list = new ArrayList<>();
    private static boolean visited[] = new boolean[9];

    private static void arrange(int index, int[] num) {
        if (index == 9) {
            list.add(num);
            return;
        }
        for (int i = 0; i < 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                num[index] = i;
                arrange(index + 1, num);
                visited[i] = false;
            }
        }
    }
}