package BST;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-15
 * @Time: 11:33
 * To change this template use File | Settings | File Templates.
 * @desc 二叉树节点
 */
public class Node {
    protected int key;
    protected Node right;
    protected String value;
    protected Node left;

    public Node(Node node) {
        this.right = node.right;
        this.key = node.key;
        this.value = node.value;
        this.left = node.left;
    }

    public Node(int key, String value) {
        this.key = key;
        this.value = value;
        this.right = this.left = null;


    }

}
