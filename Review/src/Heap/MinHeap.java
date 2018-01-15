package Heap;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-14
 * @Time: 20:44
 * To change this template use File | Settings | File Templates.
 * @desc 最小堆
 */
public class MinHeap {
    //从0开始计数的
    private int[] data;//数据
    private int index;//下一个数据索引
    private int capacity;//堆的容量

    public MinHeap(int capacity) {
        this.capacity = capacity;
        data = new int[capacity];
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public void insert(int item) {
        if (index < capacity) {
            data[index] = item;
            shift_up(index);
            index++;
        }

    }

    public int extractMin() {
        int res = data[0];
        data[0] = data[--index];
        shift_down(0);
        return res;
    }

    private void shift_down(int index) {
        int temp = data[index];
        while (index * 2 + 1 < this.index) {
            int smaller = index * 2 + 1;
            if (smaller < this.index && data[smaller] > data[smaller + 1]) {
                smaller++;
            }
            if (data[smaller] < temp) {
                data[index] = data[smaller];
                index = smaller;
            } else break;
        }
        data[index] = temp;
    }

    private void shift_up(int index) {
        int temp = data[index];
        while (index >= 1 && temp < data[(index - 1) / 2]) {
            data[index] = data[(index - 1) / 2];
            index = (index - 1) / 2;
        }
        data[index] = temp;

    }

    public void print() {
        while (!isEmpty()) {
            System.out.println(extractMin());
        }
    }

}
