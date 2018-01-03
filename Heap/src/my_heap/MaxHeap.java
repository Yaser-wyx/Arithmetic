package my_heap;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2017-12-28
 * @Time: 11:21
 * To change this template use File | Settings | File Templates.
 * @desc 最大堆
 */
public class MaxHeap<T extends Comparable> {
    private T[] data;
    private int count;

    public MaxHeap(int capacity) {
        data = (T[]) new Comparable[capacity + 1];
    }

    public MaxHeap(T arr[]) {
        this(arr.length);
        System.arraycopy(arr, 0, data, 1, arr.length);//复制数组
        count = arr.length;
        Hepify();
    }

    private void Hepify() {
        int end = count / 2;//找到最后一个有孩子的节点

        while (end > 0) {
            shift_down(end--);//从这最后一个有孩子的节点开始做shift_down操作直到根节点
        }

    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(T item) {
        assert count + 1 <= data.length;
        data[++count] = item;
        shift_up();
    }

    private void shift_up() {//该方法是将最后一个元素不断向上交换，直到小于其父节点
        int index = count;
        while (index > 1 && data[index / 2].compareTo(data[index]) < 0) {
            swap(index, index / 2);
            index /= 2;
        }
    }

    public T extractMax() {//抛出元素
        if (count == 0)
            return null;
        T element = data[1];//根节点元素
        data[1] = data[count];//将根节点元素与最后一个元素进行调换位置
        data[count--] = null;//将最后一个元素设为空

        shift_down(1);
        return element;//返回保存的根节点
    }

    private void shift_down(int index) {//该操作在抛出元素后进行，为了将抛出后的堆重新排序
        //不断将index处的元素向下调换位置，直到该元素比两个子节点都大
        T value = data[index];
        while (index * 2 <= count) {
            int bigger = index * 2;
            if (bigger + 1 <= count && (data[bigger].compareTo(data[bigger + 1]) < 0)) {
                bigger++;//比较两个子节点，选出较大的那个和index处的元素进行比较
            }
            if (value.compareTo(data[bigger]) < 0) {//如果比较大的那个子节点小，则交换位置
                data[index] = data[bigger];
                index = bigger;
            } else {//否则就跳出循环
                break;
            }
        }
        data[index] = value;
    }


    private void swap(int i, int j) {
        T temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }


}
