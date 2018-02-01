package MyList;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-22
 * @Time: 22:25
 * To change this template use File | Settings | File Templates.
 * @desc 双向链表
 */
public class DoubleList<T> {
    private DoubleNode<T> head;//头结点
    private int size;
    private DoubleNode<T> end;//尾节点

    public DoubleList() {
        head = new DoubleNode<>(null, null, null);
        head.next = head;
        head.prev = head;
        end = head;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //获取第几个节点的值
    public T get(int index) {

        return getNode(index).data;

    }

    //获取第几个节点的值
    private DoubleNode<T> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        DoubleNode<T> node;
        if (index < size / 2) {
            node = head.next;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = end;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }
        return node;

    }

    //在末尾添加节点
    public void appendLast(T data) {
        DoubleNode<T> newNode = new DoubleNode(data, end, head);
        end.next = newNode;
        head.prev = newNode;
        end = newNode;
        size++;
    }

    //在index之前插入节点
    public void insert(int index, T data) {
        DoubleNode<T> node = getNode(index);
        DoubleNode<T> newNode = new DoubleNode<>(data, head, node);
        head.next = newNode;
        node.prev = newNode;
        size++;
    }

    public void insertFirst(T data) {
        insert(0, data);
    }

    public void del(int index) {
        DoubleNode<T> node = getNode(index);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node = null;
        size--;
    }

    public void delFirst() {
        del(0);
    }

    public int Size() {
        return size;
    }

    public void delLast() {
        del(size - 1);
    }

    public T getFirst() {
        return get(0);
    }

    public T getLast() {
        return get(size - 1);
    }
}
