package LeetCode;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-30
 * @Time: 12:36
 * To change this template use File | Settings | File Templates.
 * @desc
 */
public class Pro80 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(nums));
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int end = -1;
        int n = 0;
        int now = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length&&nums[i]>=now; i++) {
            if (nums[i] > now) {
                nums[++end] = nums[i];
                now = nums[i];
                n = 1;
            } else if (nums[i] == now && n < 2) {
                n++;
                nums[++end] = nums[i];
            }
        }

        return ++end;

    }
}
