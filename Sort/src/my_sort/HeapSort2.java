package my_sort;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2017-12-30
 * @Time: 21:02
 * To change this template use File | Settings | File Templates.
 * @desc 优化版堆排序
 */
public class HeapSort2 extends Sort {

    @Override
    String getName() {
        return "HeapSort2";
    }

    @Override
        void Sort(Integer[] nums) {
            for (int i = (nums.length - 1) / 2; i >= 0; i--) {//从最后一个有孩子的叶子节点开始进行shiftDown操作
                ShiftDown(nums, i, nums.length - 1);
            }

            for (int i = nums.length - 1; i > 0; i--) {
                int temp = nums[0];
                nums[0] = nums[i];
                nums[i] = temp;
                ShiftDown(nums, 0, i - 1);//需要将i再减1是因为已经将未排序中最大的元素放在了未排序数中最后一个的位置，
                // 而且也不要对其再次进行shiftDown操作了
            }
        }

        private void ShiftDown(Integer[] nums, int index, int n) {//n代表最后一个元素的索引
            int temp = nums[index];
            while (index * 2 + 1 <= n) {//因为是从0开始进行编号的，所以左孩子的编号是2*index+1
                int bigger = index * 2 + 1;
                if (bigger + 1 <= n && nums[bigger] < nums[bigger + 1]) {
                    bigger++;
                }
                if (temp < nums[bigger]) {
                    nums[index] = nums[bigger];
                    index = bigger;
                } else {
                    break;
                }
            }
            nums[index] = temp;
        }
}
