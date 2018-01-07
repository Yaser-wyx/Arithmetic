package myTree;

import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-03
 * @Time: 18:18
 * To change this template use File | Settings | File Templates.
 * @desc 二分查找树
 */
public class BST<Key extends Comparable<Key>, Value> {
    private Node<Key, Value> root;//根节点
    private int count;//节点数

    public BST() {//初始化
        this.root = null;
        this.count = 0;
    }

    public int size() {
        return count;
    }

    public boolean IsEmpty() {
        return count == 0;
    }

    public void insert(Key key, Value value) {
        root = insert(root, key, value);

    }

    public boolean contain(Key key) {
        return contain(root, key);
    }

    public Value search(Key key) {
        return search(root, key);
    }

    //前序遍历
    public void preOrder() {
        preOrder(root);
    }

    //中序遍历
    public void inOrder() {
        inOrder(root);
    }

    //后序遍历
    public void postOrder() {
        postOrder(root);
    }

    //层次遍历
    public void levelOrder() {
        PriorityQueue<Node> queue = new PriorityQueue<>();//队列
        queue.add(root);//将根节点放入队列中
        while (!queue.isEmpty()) {//直到队列为空，遍历结束
            Node<Key, Value> node = queue.poll();//从队列中拿到一个元素
            if (node != null) {//如果该节点不为空
                if (node.left != null)
                    queue.add(node.left);//如果左节点存在，则将其入队
                if (node.right != null)
                    queue.add(node.right);//如果右节点存在，则将其入队
                System.out.println(node.key);
            }
        }
    }

    public Key Minimum() {
        return (Key) Mininum(root).key;
    }

    public Key Maximum() {
        return (Key) Maxinum(root).key;
    }

    //删除最小节点
    public void removeMin() {
        if (root != null) {
            root = removeMin(root);//更新删除最小节点后的根节点
        }
    }

    //删除最大节点
    public void removeMax() {
        if (root != null) {
            root = removeMax(root);//更新删除最大节点后的根节点
        }
    }

    //删除指定节点
    public void remove(Key key) {

        if (root != null) {
            root = remove(root, key);//更新删除节点后的根节点
        }
    }

    private Node remove(Node node, Key key) {
        //三种情况
        //1.左右节点均不存在
        //2.只存在左右节点中的一个
        //3.左右节点都存在
        if (node == null) {
            return null;//如果没有该节点，则返回空
        }
        //先找到要删除的节点
        if (node.key.compareTo(key) == 0) {//找到了要删除的节点

            //前两种情况的处理方式
            if (node.left == null) {
                //只有右孩子
                //注意，此处将左右孩子都没有的情况隐藏在里面了
                //因为如果左右孩子都没有，则会直接进入该分支，而因为右孩子也为空，所以直接返回null
                count--;
                return node.right;
            } else if (node.right == null) {
                //只有左孩子
                count--;
                return node.left;
            }

            //左右节点都存在
            Node<Key, Value> temp = new Node<>(Mininum(node.right));//先保存要删除的节点的后继节点
            temp.right = removeMin(node.right);//返回删除该后继节点后的根节点，注：该根节点就是要删除节点的右节点
            temp.left = node.left;//将要删除节点的左孩子赋值给后继节点
            return temp;//返回后继节点

        } else if (node.key.compareTo(key) > 0) {
            node.left = remove(node.left, key);
            return node;
        } else {
            node.right = remove(node.right, key);
            return node;
        }

    }


    private Node removeMax(Node node) {
        if (node.right == null) {
            count--;//减去节点个数
            return node.left;//如果left为空则直接返回空，否则将左节点放在node根节点的右子树上
        }
        node.right = removeMax(node.right);
        return node;

    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            count--;//减去节点个数
            return node.right;//如果right为空则直接返回空，否则将右节点放在node根节点的左子树上
        }
        node.left = removeMin(node.left);
        return node;
    }

    private Node Maxinum(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    private Node Mininum(Node node) {
        if (node.left == null) {
            return node;
        } else {
            return Mininum(node.left);
        }

    }

    //后序遍历
    private void postOrder(Node node) {

        if (node != null) {//当前节点不为空
            postOrder(node.left);//先访问左子树
            postOrder(node.right);//然后访问右子树
            System.out.println(node.key);//最后访问根节点
        }
    }

    //中序遍历
    private void inOrder(Node node) {
        if (node != null) {//当前节点不为空
            inOrder(node.left);//先访问左子树
            System.out.println(node.key);//访问当前节点，即根节点
            inOrder(node.right);//最后访问右子树
        }
    }

    //前序遍历
    private void preOrder(Node node) {
        if (node != null) {//当前节点不为空
            System.out.println(node.key);//先访问当前节点，其实就是根节点
            preOrder(node.left);//访问左子树
            preOrder(node.right);//访问右子树
        }
    }

    //在以root为根的二叉搜索树中查找键值为key的节点
    private Value search(Node node, Key key) {
        if (node == null) {
            return null;//如果该节点为null
        }
        if (node.key.compareTo(key) == 0) {
            return (Value) node.value;//找到了要查找的节点
        } else if (node.key.compareTo(key) < 0) {
            return search(node.right, key);//递归查找右子树
        } else {
            return search(node.left, key);//递归查找左子树
        }
    }

    //在以root为根的二叉搜索树中查找键值为key的节点
    private boolean contain(Node node, Key key) {
        if (node == null) {//如果节点为空，则说明对应为key值的节点不存在
            return false;
        }

        if (node.key.compareTo(key) == 0) {//如果key值一样则表明存在
            return true;
        } else if (node.key.compareTo(key) > 0) {//node的key值大于要查找的key值，则在左半部分继续查找
            return contain(node.left, key);
        } else {
            return contain(node.right, key);//node的key值小于要查找的key值，则在右半部分继续查找
        }
    }

    private Node insert(Node node, Key key, Value value) {

        if (node == null) {//递归终止条件，如果该节点为空，则直接新建节点
            count++;//新增了节点
            return new Node(key, value);
        }

        if (node.key.compareTo(key) == 0) {
            node.value = value;//更新value值
        } else if (node.key.compareTo(key) > 0) {//如果比node节点的key值小，则插入node的左子树中
            node.left = insert(node.left, key, value);
        } else {
            node.right = insert(node.right, key, value);//如果比node节点的key值大，则插入node的右子树中
        }
        return node;//返回插入后的根节点

    }
}

