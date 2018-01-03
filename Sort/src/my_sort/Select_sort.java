package my_sort;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2017-12-22
 * @Time: 21:29
 * To change this template use File | Settings | File Templates.
 * @desc 选择排序
 */
public class Select_sort extends Sort {
    @Override
    public String getName() {
        return "select_sort";
    }

    public void Sort(Integer[] nums) {
        for (int i = 0; i < nums.length; i++) {//遍历的次数
            int min_index = i;//给min_index赋一个初始值
            for (int j = i; j < nums.length; j++) {//从i遍历到最后一个数，从这里面找到最小值，将该索引赋给min
                if (nums[j] < nums[min_index]) {//如果当前数比index所指向的数还要小，就将当前数的索引赋给index
                    min_index = j;
                }
            }
            //一次遍历完成后，将index与i的值交换
            int temp = nums[min_index];
            nums[min_index] = nums[i];
            nums[i] = temp;
        }
    }
}
