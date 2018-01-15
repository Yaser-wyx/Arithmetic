package Sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-13
 * @Time: 11:38
 * To change this template use File | Settings | File Templates.
 * @desc 归并排序
 */
public class merge_sort {
    void sort(int[] nums) {
        merge(nums, 0, nums.length - 1);
    }

    void merge(int[] nums, int l, int r) {//对数组从[L...R]进行分割
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        merge(nums, l, mid);
        merge(nums, mid + 1, r);
        __sort(nums, l, mid, r);

    }

    private void __sort(int[] nums, int l, int mid, int r) {
        int[] temp = Arrays.copyOfRange(nums, l, r + 1);//对从l到r的数据进行复制
        int i = l;
        int j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                nums[k] = temp[j - l];
                j++;
            } else if (j > r) {
                nums[k] = temp[i - l];
                i++;
            } else if (temp[i - l] < temp[j - l]) {
                nums[k] = temp[i - l];
                i++;
            } else if (temp[i - l] > temp[j - l]) {
                nums[k] = temp[j - l];
                j++;
            }

        }

    }

}
