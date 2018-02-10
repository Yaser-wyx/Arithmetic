package HDU;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-02-09
 * @Time: 17:21
 * To change this template use File | Settings | File Templates.
 * @desc
 */
public class Pro1006 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        //秒钟走一度的时间
        double ss = 1.0 / 60.0;
        //秒钟走一度其他指针走的度数
        double s = 0.1;
        double m = 0.01 / 6.0;
        double h = 0.05 / 360.0;
        while (true) {
            int n = in.nextInt();
            if (n == -1) break;
            //三个指针当前在时钟上的位置，度数相对于整点
            double S = 0;
            double M = 0;
            double H = 0;
            double time_sum = 0;
            for (int i = 1; i <= 2592000; i++) {
                //秒针每走一度的情况
                S += s;
                H += h;
                M += m;
                //各指针走一圈的情况
                if (S >= 360) S = 0;
                if (M >= 360) M = 0;
                if (H >= 360) H = 0;
                double s_m = Math.abs(S - M);//秒针与分针的度数
                double s_h = Math.abs(S - H);//秒针与时针的度数
                double m_h = Math.abs(M - H);//分针与时针的度数
                if (s_m > 180) {//修正度数
                    s_m = Math.abs(360 - s_m);
                }
                if (s_h > 180) {
                    s_h = Math.abs(360 - s_h);
                }
                if (m_h > 180) {
                    m_h = Math.abs(360 - m_h);
                }

                if (s_h >= n && s_m >= n && m_h >= n) {
                    time_sum += ss;
                }
            }
            double res = time_sum / 432.0;
            System.out.println(String.format("%.3f", res));
        }
    }

}
