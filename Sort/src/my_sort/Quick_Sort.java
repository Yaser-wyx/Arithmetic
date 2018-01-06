package my_sort;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2017-12-24
 * @Time: 16:51
 * To change this template use File | Settings | File Templates.
 * @desc 单路快速排序
 */
public class Quick_Sort extends Sort {
    @Override
    String getName() {
        return "quick_sort";
    }

    @Override
    public void Sort(Integer[] nums) {
        quick_Sort(nums, 0, nums.length - 1);//对元素从0到n-1进行排序

    }

    //递归调用
    void quick_Sort(Integer[] nums, int l, int r) {
        if (l >= r) {
            return;
        }

        int p = partition(nums, l, r);//返回的索引左边都比nums[p]小，右边都比nums[p]大
        quick_Sort(nums, l, p - 1);
        quick_Sort(nums, p + 1, r);

    }

    //对nums[l...r]进行分类
    //返回索引p，使得nums[l..p-1]都小于nums[p],右边都大于num[p]
    int partition(Integer[] nums, int l, int r) {

        int k = l;//k表示比nums[p]小的最后一个元素,即nums[l....k]都是比temp小的数，nums[k+1.....r]都是大于等于temp的数
        int temp = nums[l];
        int random = (int) (Math.random() * (r - l + 1)) + l;//随机算法进行优化
        nums[l] = nums[random];
        nums[random] = temp;
        temp = nums[l];
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] <= temp) {
                int cache = nums[i];
                nums[i] = nums[k + 1];
                nums[k + 1] = cache;
                k++;
            }
        }
        nums[l] = nums[k];
        nums[k] = temp;
        return k;


    }
}
