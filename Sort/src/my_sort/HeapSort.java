package my_sort;

import my_heap.MaxHeap;


/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2017-12-30
 * @Time: 19:31
 * To change this template use File | Settings | File Templates.
 * @desc 简单堆排序
 */
public class HeapSort extends Sort {
    @Override
    String getName() {
        return "HeapSort";
    }

    @Override
    void Sort(Integer[] nums) {
        MaxHeap<Comparable> heap = new MaxHeap<>(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            nums[i] = (Integer) heap.extractMax();
        }

    }


}
