package my_heap;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-09
 * @Time: 19:58
 * To change this template use File | Settings | File Templates.
 * @desc 最小堆 简易实现
 */
public class MinHeap<T extends Comparable> {
    private T[] data;
    private int count;

    public MinHeap(int capacity) {
        data = (T[]) new Comparable[capacity + 1];//从1开始
        this.count = 0;
    }

    public void insert(T element) {//插入节点
        assert count + 1 < data.length;
        data[++count] = element;
        shift_up(count);//维护最小堆
    }

    private void shift_up(int index) {

        while (index > 1 && data[index].compareTo(data[index / 2]) < 0) {//判断该节点是否小于其父节点
            T temp = data[index];//如果小于则交换二者
            data[index] = data[index / 2];
            data[index / 2] = temp;
            index /= 2;
        }
    }

    public T extractMin() {//抛出最小值
        T min = data[1];
        data[1] = data[count--];
        shift_down(1);//维护最小堆
        return min;//返回值

    }

    private void shift_down(int i) {

        while (i * 2 <= count) {
            int min = i * 2;
            if (data[min].compareTo(data[min + 1]) > 0 && min + 1 <= count) {//比较两个节点，哪个最小
                min++;
            }
            if (data[min].compareTo(data[i]) < 0) {//将最小的那个子节点与该节点比较
                T temp = data[i];//如果该节点大于子节点中的一个，则交换
                data[i] = data[min];
                data[min] = temp;
                i = min;
            } else break;//否则退出
        }
    }

    public boolean isEmpty() {//是否为空
        return count == 0;
    }

}
