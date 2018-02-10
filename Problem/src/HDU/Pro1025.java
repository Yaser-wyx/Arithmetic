package HDU;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-02-08
 * @Time: 22:45
 * To change this template use File | Settings | File Templates.
 * @desc
 */
public class Pro1025 {
    private static int[] index;

    private static void init(Scanner in) {

        int n = Integer.parseInt(in.nextLine());
        index = new int[n + 1];//代表poor与rich的关系映射
        for (int i = 1; i <= n; i++) {
            String line[] = in.nextLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            index[x] = y;
        }
    }

    private static int LIS() {
        int len = 1;//子序列的长度
        int[] dp = new int[index.length];//最长子序列最小末尾数组
        dp[1] = index[1];
        for (int i = 1; i < index.length; i++) {
            int temp = index[i];
            int n = binarysearch(dp, len, temp);//位置
            if (n > len) {
                //添加在末尾
                dp[n] = index[i];
                len++;
            } else if (n <= len) {
                //添加在中间
                dp[n] = index[i];
            }
        }
        return len;
    }

    private static int binarysearch(int[] nums, int r, int key) {
        int left = 1;
        int right = r;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < key) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int i = 1;
        while (in.hasNext()) {
            init(in);
            System.out.println("Case " + i + ":");
            int temp = LIS();
            if (temp > 1) {
                System.out.println("My king, at most " + temp + " roads can be built.");
            } else {
                System.out.println("My king, at most " + temp + " road can be built.");
            }
            System.out.println();
            i++;
        }
    }
}
