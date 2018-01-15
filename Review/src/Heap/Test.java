package Heap;

import org.apache.commons.lang3.RandomUtils;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-15
 * @Time: 11:08
 * To change this template use File | Settings | File Templates.
 * @desc
 */
public class Test {
    public static void main(String[] args) {
        int n = 100;
        IndexMinHeap minHeap = new IndexMinHeap(n);
        for (int i = 0; i < n; i++) {
            minHeap.insert(i, RandomUtils.nextInt(0, n));
        }
        minHeap.print();

    }
}
