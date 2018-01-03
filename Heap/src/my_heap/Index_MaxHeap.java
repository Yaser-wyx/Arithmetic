package my_heap;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-01
 * @Time: 22:14
 * To change this template use File | Settings | File Templates.
 * @desc 最大索引堆
 */
public class Index_MaxHeap<T extends Comparable> {
    private T[] data;//存放数据
    private int count;//数据的个数
    private int[] indexes;//索引
    private int[] reverse;//索引数组的索引
    private int capacity;

    public Index_MaxHeap(int capacity) {
        this.capacity = capacity;
        data = (T[]) new Comparable[capacity + 1];
        count = 0;
        reverse = new int[capacity + 1];
        indexes = new int[capacity + 1];
    }

    public void insert(int index, T item) {
        assert count + 1 <= capacity;
        assert index + 1 >= 1 && index + 1 <= capacity;//防止数组越界
        index++;
        data[index] = item;//添加新的元素
        indexes[++count] = index;//index保存的是data的索引
        reverse[index] = count;//count保存的是indexes的索引
        shift_up(count);
    }

    private void shift_up(int index) {//index是在indexs里面的索引，indexes[index]是指data里面的索引
        while (index > 1 && data[indexes[index / 2]].compareTo(data[indexes[index]]) < 0) {//如果父节点小于子节点
            //交换二个索引的位置
            int cache = indexes[index / 2];
            indexes[index / 2] = indexes[index];
            indexes[index] = cache;
            reverse[indexes[index / 2]] = index / 2;//reverse的索引是data的索引，reverse的值是indexes的索引，reverse将二者相互关联了起来
            reverse[indexes[index]] = index;
            index /= 2;
        }
    }

    public T extractMax() {//抛出最大值
        assert count > 0;
        T temp = data[indexes[1]];//先保存要抛出的元素
        indexes[1] = indexes[count];//将根节点的值赋值为最后一个索引
        indexes[count] = 0;//清除原始数据
        reverse[indexes[1]] = 1;
        reverse[indexes[count--]] = 0;
        shift_down(1);
        return temp;

    }

    public int extractMaxIndex() {//抛出最大值索引
        assert count > 0;
        int temp = indexes[1] - 1;
        indexes[1] = indexes[count];
        indexes[count] = 0;
        reverse[indexes[1]] = 1;
        reverse[indexes[count--]] = 0;
        shift_down(1);
        return temp;

    }

    public T getMax() {//获取最大值
        assert count > 0;
        return data[indexes[1]];

    }

    public int getMaxIndex() {//获取最大值的索引
        assert count > 0;
        return indexes[1] - 1;

    }

    public T getItem(int index) {//通过索引查找数据
        assert contain(index);
        index++;
        return data[index];
    }

    public int getIndex(T item) {//通过数据查找索引
        assert count > 0;
        for (int i = 1; i <= count; i++) {
            if (data[indexes[i]].compareTo(item) == 0) {
                return indexes[i] - 1;
            }
        }
        return -1;

    }

    private boolean contain(int i) {//判断该元素是否存在
        assert i + 1 >= 1 && i + 1 <= capacity;
        return reverse[i + 1] != 0;
    }

    public void change(int index, T item) {
        assert contain(index);
        index++;
        data[index] = item;

        shift_down(reverse[index]);
        shift_up(reverse[index]);

    }

    private void shift_down(int index) {//index是指indexes里面的

        while (index * 2 <= count) {
            int bigger = index * 2;//找到较大的子节点
            if (bigger < count && data[indexes[bigger]].compareTo(data[indexes[bigger + 1]]) < 0) {
                bigger++;
            }
            //将父节点与较大的子节点比较
            if (data[indexes[bigger]].compareTo(data[indexes[index]]) > 0) {
                int cache = indexes[bigger];
                indexes[bigger] = indexes[index];
                indexes[index] = cache;
                reverse[indexes[index]] = index;
                reverse[indexes[bigger]] = bigger;
            } else {
                break;
            }


        }

    }
}
