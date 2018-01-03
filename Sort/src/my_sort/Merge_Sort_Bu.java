package my_sort;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2017-12-24
 * @Time: 15:10
 * To change this template use File | Settings | File Templates.
 * @desc 归并排序 迭代版
 */
public class Merge_Sort_Bu extends Sort {
    @Override
    String getName() {
        return "my_sort.Merge_Sort_Bu";
    }

    @Override
    void Sort(Integer[] nums) {
        for (int size = 1; size <= nums.length; size += size) {
            for (int j = 0; j + size < nums.length; j += size * 2) {
                merge_sort(nums, j, j + size - 1, Math.min(j + size * 2 - 1, nums.length - 1));
            }
        }
    }

    void merge_sort(Integer[] nums, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];
        System.arraycopy(nums, l, temp, 0, temp.length);
        int i = l;
        int j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                nums[k] = temp[j - l];
                j++;
            } else if (j > r) {
                nums[k] = temp[i - l];
                i++;
            } else if (temp[i - l] > temp[j - l]) {
                nums[k] = temp[j - l];
                j++;
            } else {
                nums[k] = temp[i - l];
                i++;
            }
        }
    }
}
