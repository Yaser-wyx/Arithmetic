package LeetCode;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-30
 * @Time: 11:19
 * To change this template use File | Settings | File Templates.
 * @desc
 */
public class Pro27 {
    public static void main(String[] args) {
        int[] a = {1};
        System.out.println(removeElement(a, 1));
        for (int i : a) {
            System.out.print(i + " ");
        }
    }


    public static int removeElement(int[] nums, int val) {
        int end = -1;//最后一个非val
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[++end] = nums[i];
            }
        }
        return end + 1;
    }
}
