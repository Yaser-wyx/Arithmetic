package myTree;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-03
 * @Time: 16:51
 * To change this template use File | Settings | File Templates.
 * @desc 二分查找
 */
public class BinarySearch<T extends Comparable> {
    //二分查找，在arr里面查找target，并返回索引
    public int search1(T[] arr, T target) {//迭代版
        int l = 0;//左边界
        int r = arr.length - 1;//右边界
        while (l <= r) {//查找条件
            int mid = l + (r - l) / 2;//中间，此处不使用(l+r)/2是因为该方法在l和r都很大的情况下会出现精度溢出的问题
            if (arr[mid].compareTo(target) == 0) {//找到怎返回索引
                return mid;
            } else if (arr[mid].compareTo(target) < 0) {//如果比目标小则在右半部分继续查找
                l = mid + 1;//更新左边界
            } else {//如果比目标大则在左半部分继续查找
                r = mid - 1;//更新右边界
            }
        }
        return -1;//如果没有找到就返回-1
    }

    public int search2(T[] arr, T target, int l, int r) {//递归版，思想与迭代版一致
        int mid = l + (r - l) / 2;
        if (arr[mid].compareTo(target) == 0) {
            return mid;
        } else if (arr[mid].compareTo(target) < 0) {
            return search2(arr, target, mid + 1, r);
        } else {
            return search2(arr, target, l, mid - 1);
        }
    }

}
