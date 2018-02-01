package HDU;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @version 2017-5-14  下午8:05:52
 * @author<a href="mailto:953801304@qq.com">胡龙华</a>
 * @fileName p1070.java
 */

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\wanyu\\Desktop\\1.txt");
        PrintWriter printWriter = new PrintWriter(file);
        Scanner sc = new Scanner(new File("C:\\Users\\wanyu\\Desktop\\Test.txt"));

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String str1[] = new String[n];
            sc.nextLine();// 收掉前面的字符，后面才能正常收一行
            String str2 = "";// 用来记录牛奶的牌子
            double min = Double.MAX_VALUE;//用存  牛奶的最小价格（这是平均到天的价格）
            int v = 0; // 用来记录容量，平均算到每天价格相等时，选择容量大的
            for (int i = 0; i < n; i++) {
                str1[i] = sc.nextLine();
                String s[] = str1[i].split(" ");// 拆开，分别拿到 牌子、价格、容量、
                //卫条件，防止容量小于200ML
                if (Integer.parseInt(s[2]) < 200) {
                    continue;
                }
                // 牛奶超过1000ml 只能算5天  以为过期了。
                int day = Integer.parseInt(s[2]) / 200 < 5 ? Integer.parseInt(s[2]) / 200 : 5;//算下牛奶可以喝几天
                double money = Integer.parseInt(s[1]) * 1.0 / day;// 算平均到每天的价格
                if (money < min) { // 价格更低就把信息存起来
                    min = money;
                    str2 = s[0];
                    v = Integer.parseInt(s[2]);
                    // 平均每天价格相等，选择容量大的
                } else if (money == min && v < Integer.parseInt(s[2])) {
                    min = money;
                    str2 = s[0];
                    v = Integer.parseInt(s[2]);
                }
            }

            printWriter.append(str2).append("\n");
        }
        printWriter.flush();
    }

}