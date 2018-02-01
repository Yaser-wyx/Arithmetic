package HDU;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-02-01
 * @Time: 14:21
 * To change this template use File | Settings | File Templates.
 * @desc
 */
public class compare {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("C:\\Users\\wanyu\\Desktop\\1.txt"));
        int test = 1000;//测试样例数
        String s1[] = new String[test];
        String s2[] = new String[test];
        int i = 0;
        while (in.hasNext()) {
            s1[i++] = in.nextLine();
        }
        in = new Scanner(new File("C:\\Users\\wanyu\\Desktop\\2.txt"));
        i = 0;
        while (in.hasNext()) {
            s2[i++] = in.nextLine();
        }

        for (int j = 0; j < test; j++) {
            if (!s1[j].equals(s2[j])) {
                System.out.println(j+1);
            }
        }
        System.out.println("ok");

    }
}
