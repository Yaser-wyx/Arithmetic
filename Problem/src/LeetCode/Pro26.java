package LeetCode;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-30
 * @Time: 12:25
 * To change this template use File | Settings | File Templates.
 * @desc
 */
public class Pro26 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 12, 15, 16, 16, 16, 22, 22, 22};
        System.out.println(removeDuplicates(nums));
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int end = -1;
        int now = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length && nums[i] >= now; i++) {
            if (nums[i] > now) {
                nums[++end] = nums[i];
                now = nums[i];
            }
        }

        return ++end;
    }
}
