package myTree;

import my_sort.Quick_Sort;
import org.apache.commons.lang3.RandomUtils;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-03
 * @Time: 17:17
 * To change this template use File | Settings | File Templates.
 * @desc
 */
public class Main1 {
    public static void main(String[] args) {
        BST<Integer, Integer> bst = new BST<>();
        int size = 100;
        for (int i = 0; i < size; i++) {
            bst.insert(RandomUtils.nextInt(0, 100),i );
        }
        System.out.println(bst.search(10));
        bst.remove(10);
        System.out.println("--------------------------");
        bst.inOrder();

    }
}
