package Sort;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-13
 * @Time: 11:04
 * To change this template use File | Settings | File Templates.
 * @desc 插入排序
 */
public class insert {
    void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int index = i;
            for (; index > 0 && temp < nums[index - 1]; index--) {
                nums[index] = nums[index - 1];
            }
            nums[index] = temp;
        }

    }
}
