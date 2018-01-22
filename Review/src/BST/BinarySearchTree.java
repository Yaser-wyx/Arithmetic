package BST;

import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-15
 * @Time: 11:24
 * To change this template use File | Settings | File Templates.
 * @desc 二分查找树
 */
public class BinarySearchTree {
    private Node root = null;//根节点
    private int size = 0;

    public void insert(int key, String value) {
        root = insert(root, key, value);
        size++;
    }

    private Node insert(Node node, int key, String value) {
        if (node == null) {
            return new Node(key, value);
        }
        if (key > node.key) {
            node.right = insert(node.right, key, value);
            return node;
        } else if (key == node.key) {
            node.value = value;
            return node;
        } else {
            node.left = insert(node.left, key, value);
            return node;
        }
    }

    public void delete(int key) {
        if (root != null)
            root = delete(root, key);
    }

    public void inOrder() {
        inorder(root);
    }

    private void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.println(node.value);
            inorder(node.right);
        }
    }

    public void show() {
        inorder(root);
    }

    public void leveloreder() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }

            System.out.println(node.value);

        }

    }

    private Node delete(Node node, int key) {
        if (node == null) {
            return null;
        }
        if (node.key == key) {
            if (node.left == null) {
                size--;
                return node.right;
            } else if (node.right == null) {
                size--;
                return node.left;
            }
            Node temp = new Node(min(node.right));
            temp.right = deleteMin(node.right);

            temp.left = node.left;
            return temp;
        } else if (node.key > key) {
            node.right = delete(node.right, key);
            return node;
        } else {
            node.left = delete(node.left, key);
            return node;
        }
    }

    private Node min(Node node) {
        if (node.left != null) {
            return min(node.left);
        }
        return node;
    }

    private Node deleteMin(Node node) {
        if (node.left != null) {
            node.left = deleteMin(node.left);
            return node;
        } else {
            size--;
            return node.right;
        }

    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
