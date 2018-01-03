package my_sort;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2017-12-22
 * @Time: 21:05
 * To change this template use File | Settings | File Templates.
 * @desc 冒泡排序
 */
public class Bubble_Sort extends Sort {
    public void Sort(Integer[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {//最外层循环，控制遍历的范围[0~i]
            for (int j = 0; j < i; j++) {//在[0~i]的范围内不断查找这个范围内的最大值将之放在最后
                if (nums[j] > nums[j + 1]) {//如果前一个数大于后一个数，交换二者位置
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public String getName() {
        return "bubble_sort";
    }
}
