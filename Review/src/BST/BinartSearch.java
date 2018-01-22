package BST;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-15
 * @Time: 11:13
 * To change this template use File | Settings | File Templates.
 * @desc 二分查找
 */
public class BinartSearch {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid = l + (r - l) / 2;
        while (l <= r && nums[mid] != target) {
            if (target < nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
            mid = l + (r - l) / 2;

        }
        return mid;

    }
}
