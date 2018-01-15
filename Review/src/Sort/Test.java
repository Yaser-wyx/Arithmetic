package Sort;

import Heap.MinHeap;
import org.apache.commons.lang3.RandomUtils;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-13
 * @Time: 12:04
 * To change this template use File | Settings | File Templates.
 * @desc
 */
public class Test {
    public static void main(String[] args) {
        int n = 1000;
        MinHeap minHeap = new MinHeap(n);
        for (int i = 0; i < n; i++) {
            minHeap.insert(RandomUtils.nextInt(0, n));
        }
        minHeap.print();

    }
}
