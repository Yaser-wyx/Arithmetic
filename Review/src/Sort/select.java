package Sort;

import org.apache.commons.lang3.RandomUtils;


/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-13
 * @Time: 11:20
 * To change this template use File | Settings | File Templates.
 * @desc 选择排序
 */
public class select {
    void sort(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            int index = 0;
            for (int j = 0; j <= i; j++) {
                if (nums[j] > nums[index]) {
                    index = j;
                }
            }
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
        }
    }


}
