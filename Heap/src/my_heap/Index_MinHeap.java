package my_heap;


/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-10
 * @Time: 8:50
 * To change this template use File | Settings | File Templates.
 * @desc 最小索引堆
 */
public class Index_MinHeap<T extends Comparable> {
    private T[] data;//数据
    private int[] indexes;//索引
    private int[] reverse;//逆索引
    private int count;//个数
    private int capacity;//容量

    public Index_MinHeap(int capacity) {
        this.capacity = capacity;//初始容量
        data = (T[]) new Comparable[capacity + 1];
        reverse = new int[capacity + 1];
        indexes = new int[capacity + 1];
    }

    public void insert(int index, T item) {
        assert count + 1 <= capacity;
        //在末尾处添加新的元素
        data[++index] = item;
        indexes[++count] = index;
        reverse[index] = count;
        shift_up(count);
    }

    public void change(int index, T item) {
        assert index + 1 > 0 && index + 1 <= capacity;
        index++;
        data[index] = item;
        shift_up(reverse[index]);
        shift_down(reverse[index]);

    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean exist(int i) {
        return reverse[i + 1] != 0;
    }

    public int extractMinIndex() {
        int index = indexes[1] - 1;
        indexes[1] = indexes[count--];
        reverse[indexes[1]] = 1;
        shift_down(1);
        return index;
    }

    public T getItem(int i) {
        assert i + 1 > 0 && i + 1 < capacity;
        return data[i + 1];

    }

    public T extractMin() {
        T temp = data[indexes[1]];
        indexes[1] = indexes[count--];
        reverse[indexes[1]] = 1;
        shift_down(1);
        return temp;
    }

    private void shift_up(int index) {
        assert index >= 1 && index <= capacity;
        while (index > 1 && data[indexes[index]].compareTo(data[indexes[index / 2]]) < 0) {
            int temp = indexes[index];
            indexes[index] = indexes[index / 2];
            indexes[index / 2] = temp;
            reverse[indexes[index]] = index;
            reverse[indexes[index / 2]] = index / 2;
            index /= 2;
        }
    }

    private void shift_down(int index) {
        assert index > 0 && index <= capacity;
        while (index * 2 <= count) {
            int min = index * 2;
            if (min + 1 <= count && data[indexes[min]].compareTo(data[indexes[min + 1]]) > 0) {
                min++;
            }
            if (data[indexes[index]].compareTo(data[indexes[min]]) > 0) {
                int temp = indexes[index];
                indexes[index] = indexes[min];
                indexes[min] = temp;
                reverse[indexes[index]] = index;
                reverse[indexes[min]] = min;
                index = min;
            } else {
                break;
            }
        }
    }

}
