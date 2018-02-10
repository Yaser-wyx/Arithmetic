package HDU;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-02-08
 * @Time: 21:29
 * To change this template use File | Settings | File Templates.
 * @desc
 */
public class Pro1003 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int T = in.nextInt();
        for (int i = 1; i <= T; i++) {
            System.out.println("Case " + i + ":");
            int n = in.nextInt();
            int[] nums = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                nums[j] = in.nextInt();
            }
            DP(nums);
            if (i != T ) System.out.println();
        }
    }

    private static void DP(int[] nums) {
        int[] dp = new int[nums.length];//记录最大和值
        int max_index = 1;//最大值索引
        int[] index = new int[dp.length];
        index[0] = 1;
        //状态转移方程max{a[i],dp[i-1]+a[i]}
        for (int i = 1; i < nums.length; i++) {
            int x1 = dp[i - 1] + nums[i];
            //是继续接在前面的节点还是自己作为一个单独的起点
            if (x1 >= nums[i]) {
                //跟在别人后面
                index[i] = index[i - 1];
                dp[i] = x1;
            } else {
                //自己作为起点
                index[i] = i;
                dp[i] = nums[i];
            }
            if (dp[max_index] < dp[i]) {
                max_index = i;
            }
        }
        System.out.println(dp[max_index] + " " + index[max_index] + " " + max_index);
    }
}
