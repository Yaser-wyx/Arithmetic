package my_sort;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2017-12-22
 * @Time: 22:01
 * To change this template use File | Settings | File Templates.
 * @desc 插入排序
 */
public class Insert_sort extends Sort {
    @Override
    public String getName() {
        return "insert_sort";
    }

    public void Sort(Integer[] nums) {
        for (int i = 1; i < nums.length; i++) {//遍历的次数
            int temp = nums[i];
            int j = i;
            for (; j > 0 && temp < nums[j - 1]; j--) {//在已排序部分进行查找temp该插入的部分
                nums[j] = nums[j - 1];
            }
            nums[j] = temp;
        }
    }



}
