package my_sort;

import org.apache.commons.lang3.RandomUtils;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2017-12-27
 * @Time: 15:52
 * To change this template use File | Settings | File Templates.
 * @desc 三路快速排序
 */
public class Quick_sort3 extends Sort {

    @Override
    String getName() {
        return "quick_sort3";
    }

    @Override
    void Sort(Integer[] nums) {
        quick_sort(nums, 0, nums.length - 1);
    }

    void quick_sort(Integer[] nums, int l, int r) {
        if (l >= r)
            return;
        int[] p = partitions(nums, l, r);
        quick_sort(nums, l, p[0]);
        quick_sort(nums, p[1], r);

    }

    int[] partitions(Integer[] nums, int l, int r) {
        int random = RandomUtils.nextInt(l, r);
        int temp = nums[l];
        nums[l] = nums[random];
        nums[random] = temp;
        temp = nums[l];

        int lt = l;//该索引表示[l...lt]都小于temp
        int gt = r + 1;//该索引表示[gt...r]都大于temp
        int i = lt + 1;//该索引表示[lt+1...i]都等于temp
        while (i < gt) {//使用i使用进行遍历
            if (nums[i] < temp) {//如果比temp小，就与第一个等于temp的位置交换
                int cache = nums[i];
                nums[i] = nums[lt + 1];
                nums[lt + 1] = cache;
                i++;//同时i索引与lt索引都自增1
                lt++;
            } else if (nums[i] > temp) {//如果比temp大，就与第一个大于temp之前的位置交换
                int cache = nums[i];
                nums[i] = nums[gt - 1];
                nums[gt - 1] = cache;
                gt--;//同时gt索引要自减
            } else {
                i++;
            }
        }
        nums[l] = nums[lt];
        nums[lt] = temp;
        return new int[]{lt, gt};

    }

}
