package HDU;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-26
 * @Time: 15:18
 * To change this template use File | Settings | File Templates.
 * @desc
 */
public class pro1004 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new InputStreamReader(System.in));
        HashMap<String, Integer> map;
        int num;
        while ((num = in.nextInt()) != 0) {
            map = new HashMap<>();
            String temp_name = "";
            int temp = -1;
            for (int i = 0; i < num; i++) {
                String name = in.next();
                int n = map.get(name) == null ? 1 : map.get(name) + 1;

                if (n > temp) {
                    temp_name = name;
                    temp = n;
                }
                map.put(name, n);
            }
            System.out.println(temp_name);

        }
    }
}
