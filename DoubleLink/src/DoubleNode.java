/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-22
 * @Time: 22:26
 * To change this template use File | Settings | File Templates.
 * @desc 双向链表节点
 */
public class DoubleNode<T> {
    protected T data;//数据
    protected DoubleNode prev;//前一个节点
    protected DoubleNode next;//后继节点

    public DoubleNode(T data, DoubleNode prev, DoubleNode next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    DoubleNode(DoubleNode<T> node) {
        this.data = node.data;
        this.next = node.next;
        this.prev = node.prev;
    }
}
