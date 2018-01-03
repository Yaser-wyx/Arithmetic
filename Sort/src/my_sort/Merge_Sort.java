package my_sort;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2017-12-22
 * @Time: 23:05
 * To change this template use File | Settings | File Templates.
 * @desc 归并排序
 */
public class Merge_Sort extends Sort {
    @Override
    String getName() {
        return "merge_sort";
    }

    @Override
    void Sort(Integer[] nums) {
        merge(nums, 0, nums.length - 1);
    }

    void merge(Integer[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        merge(nums, l, mid);
        merge(nums, mid + 1, r);
        merge_sort(nums, l, mid, r);
    }

    void merge_sort(Integer[] nums, int l, int mid, int r) {
        Integer[] temp = new Integer[r - l + 1];
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
