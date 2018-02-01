package HDU;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-02-01
 * @Time: 11:24
 * To change this template use File | Settings | File Templates.
 * @desc  此题有毒
 */
public class Pro1005 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while (in.hasNext()) {
            int A = in.nextInt();
            int B = in.nextInt();
            int n = in.nextInt();//读入数据
            if (A + B + n == 0) break;
            int[] nums = new int[49];//用于保存前两次的状态
            // f(n) = (A * f(n - 1) + B * f(n - 2)) mod 7.
            nums[1] = nums[2] = 1;
            for (int i = 3; i <= 48; i++) {
                nums[i] = (A * nums[i - 1] + B * nums[i - 2]) % 7;
            }
            if (n == 48) {
                System.out.println(nums[48]);
            } else
                System.out.println(nums[n % 48]);

        }
    }
}
