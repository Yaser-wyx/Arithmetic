package my_sort;


/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2017-12-22
 * @Time: 21:04
 * To change this template use File | Settings | File Templates.
 * @desc
 */
public class Main {
    public static void main(String[] args) {
        //my_sort.Insert_sort insert_sort = new my_sort.Insert_sort();
        Sort[] sorts = {new HeapSort(), new Quick_sort2(), new Merge_Sort(), new HeapSort2()};
        Util util = new Util(sorts, 10, 1000000);
        util.Start();

    }
}
