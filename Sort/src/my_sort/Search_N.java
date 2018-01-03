package my_sort;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2017-12-27
 * @Time: 16:20
 * To change this template use File | Settings | File Templates.
 * @desc 查找第N大的数
 */
public class Search_N {
    private int[] nums;
    int n;

    public Search_N(int[] nums, int n) {
        this.n = n;
        this.nums = nums;
    }

    int search() {
        return pr_search(nums, 0, nums.length - 1);
    }

    private int pr_search(int[] nums, int l, int r) {

        int p = partitions(nums, l, r);
        if (p > n) {
            return pr_search(nums, l, p - 1);
        } else if (p < n) {
            return pr_search(nums, p + 1, r);
        } else {
            return nums[p];
        }

    }

    int partitions(int nums[], int l, int r) {
        int p = l + 1;
        int temp = nums[l];
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] < temp) {
                int cache = nums[i];
                nums[i] = nums[p];
                nums[p] = cache;
                p++;
            }
        }
        nums[l] = nums[p - 1];
        nums[p - 1] = temp;
        return p - 1;

    }
}
