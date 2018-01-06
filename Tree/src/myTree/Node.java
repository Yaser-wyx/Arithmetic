package myTree;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-03
 * @Time: 18:19
 * To change this template use File | Settings | File Templates.
 * @desc 二分查找树节点类
 */
public class Node<Key extends Comparable<Key>, Value> {
    protected Key key;
    protected Value value;
    protected Node<Key, Value> left;//左子树
    protected Node<Key, Value> right;//右子树节点

    public Node(Key key, Value value) {//初始化节点
        this.key = key;
        this.value = value;
        this.left = this.right = null;
    }

    public Node(Node<Key, Value> node) {//初始化节点
        this.key = node.key;
        this.value = node.value;
        this.left = node.right;
        this.left = node.left;
    }

}
