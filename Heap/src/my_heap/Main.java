package my_heap;

import org.apache.commons.lang3.RandomUtils;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2017-12-28
 * @Time: 11:39
 * To change this template use File | Settings | File Templates.
 * @desc
 */
public class Main {
    public static void main(String[] args) {
        int nums = 10;
        MaxHeap<Integer> heap = new MaxHeap<>(nums);
        for (int i = 0; i < nums; i++) {
            heap.insert(RandomUtils.nextInt(0, 1230));
        }
        System.out.println("-------------------------");
        System.out.println(heap.extractMax());
        System.out.println("-------------------------");

    }


}
