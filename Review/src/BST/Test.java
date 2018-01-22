package BST;

import Sort.Quick_Sort;
import org.apache.commons.lang3.RandomUtils;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-15
 * @Time: 11:21
 * To change this template use File | Settings | File Templates.
 * @desc
 */
public class Test {
    public static void main(String[] args) {
        int n = 100;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = RandomUtils.nextInt(0, n * 5);
        }
        Quick_Sort quick_sort = new Quick_Sort();
        quick_sort.sort(nums);
        int search = RandomUtils.nextInt(0, n);
        BinartSearch binartSearch = new BinartSearch();
        System.out.println(binartSearch.search(nums, nums[search]));
        System.out.println(search);

    }
}
