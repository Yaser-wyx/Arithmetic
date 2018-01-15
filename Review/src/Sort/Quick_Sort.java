package Sort;

import my_sort.Sort;
import org.apache.commons.lang3.RandomUtils;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-13
 * @Time: 12:35
 * To change this template use File | Settings | File Templates.
 * @desc 快速排序
 */
public class Quick_Sort {
    void sort(int[] nums) {
        quick_sort(nums, 0, nums.length - 1);
    }

    void quick_sort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }

        int p = partition(nums, l, r);
        quick_sort(nums, l, p - 1);
        quick_sort(nums, p + 1, r);

    }

    int partition(int[] nums, int l, int r) {
        int index = RandomUtils.nextInt(l, r);//随机化处理
        int temp = nums[index];
        nums[index] = nums[l];
        nums[l] = temp;
        int j = l;//[L.....J]表示小于nums[l]
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] < temp) {
                int cache = nums[i];
                nums[i] = nums[j + 1];
                nums[j + 1] = cache;
                j++;
            }
        }
        nums[l] = nums[j];
        nums[j] = temp;
        return j;
    }

}
