package LeetCode;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-30
 * @Time: 10:56
 * To change this template use File | Settings | File Templates.
 * @desc
 */
public class Pro283 {
    public static void main(String[] args) {
        int[] a = {0, 1, 0, 3, 12};
        moveZeroes(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    public static void moveZeroes(int[] nums) {
        int i = 0;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] != 0) {
                nums[i++] = nums[k];
            }
        }
        for (; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
