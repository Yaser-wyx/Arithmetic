package my_sort;

import org.apache.commons.lang3.RandomUtils;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2017-12-27
 * @Time: 12:38
 * To change this template use File | Settings | File Templates.
 * @desc 双路快速排序
 */
public class Quick_sort2 extends Sort {

    @Override
    String getName() {
        return "Quick_sort2";
    }

    @Override
    void Sort(Integer[] nums) {
        quick_sort(nums, 0, nums.length - 1);
    }

    void quick_sort(Integer[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition2(nums, l, r);
        quick_sort(nums, l, p - 1);
        quick_sort(nums, p + 1, r);

    }

    int partition2(Integer nums[], int l, int r) {
        //随机化处理
        int random = RandomUtils.nextInt(l, r);
        int temp = nums[random];
        nums[random] = nums[l];
        nums[l] = temp;
        temp = nums[l];

        int k = l + 1;//设置索引，从l到k的数都是小于等于temp的
        int j = r;//设置索引，从j到r的数都是大于等于temp的
        boolean is_left = true;//设置从那边开始遍历
        while (k <= j) {//设置边界条件
            if (is_left) {
                if (nums[k] >= temp) {
                    is_left = false;//如果nums[k]大于等于temp说明这个数需要放在右边区域
                } else {
                    k++;//否则k索引加一
                }
            } else {
                if (nums[j] <= temp) {
                    is_left = true;//如果nums[k]小于等于temp说明该数需要放在左边区域
                    int cache = nums[k];//交换两者位置，即将之前遍历到的大于等于temp的数与当前小于等于temp的数交换位置。
                    nums[k] = nums[j];
                    nums[j] = cache;
                    k++;
                    j--;
                } else {
                    j--;
                }
            }
        }
        nums[l] = nums[j];//注意，该处是j的索引而不是k的索引，因为遍历到最后j与k会交换位置，即j=k-1，
        // 此时j才是比temp小的最后一个数，而k变成了比temp大的第一个数
        nums[j] = temp;
        return j;
    }
}
