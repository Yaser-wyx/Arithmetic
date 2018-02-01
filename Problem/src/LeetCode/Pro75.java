package LeetCode;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-30
 * @Time: 15:47
 * To change this template use File | Settings | File Templates.
 * @desc
 */
public class Pro75 {
    public static void main(String[] args) {
        int[] nums = {1, 0,1,1,2,2,0,0,0,1,2
                , 2};
        sortColors(nums);
        for (int i : nums) {

            System.out.print(i + " ");
        }
    }

    public static void sortColors(int[] nums) {
        int zero = -1;//最后一个0
        int two = nums.length;//第一个2
        for (int i = 0; i < two; i++) {
            if (nums[i] == 0) {

                nums[i] = nums[++zero];
                nums[zero] = 0;
            } else if (nums[i] == 2) {

                nums[i--] = nums[--two];
                nums[two] = 2;

            }
        }

    }
}
