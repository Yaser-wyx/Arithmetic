package MyList;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-23
 * @Time: 11:48
 * To change this template use File | Settings | File Templates.
 * @desc 跳表
 */
public class SkipList<Key extends Comparable<? super Key>, Value extends Comparable<? super Value>> {

    private class SkipNode<Key extends Comparable<? super Key>, Value extends Comparable<? super Value>> {

        private Pair<Key, Value> pair;
        private SkipNode<Key, Value>[] next;//指针数组

        @Override
        public String toString() {
            return "SkipNode{" +
                    "pair=" + pair +
                    '}';
        }

        private SkipNode(Pair<Key, Value> pair, int MAX_LEVEL) {//初始化
            this.pair = pair;
            this.next = new SkipNode[MAX_LEVEL];
        }


    }

    private static final int MAX_LEVEL = 32;//跳表最大层数
    private int level = 0;//当前有效层数
    private SkipNode<Key, Value> head;//头部节点
    private SkipNode<Key, Value> tail;//尾部节点
    private SkipNode<Key, Value> last[];//用于暂时存储某一个节点在所有层中的前一个节点。
    private int size;

    public SkipList() {
        head = new SkipNode(null, MAX_LEVEL);
        tail = new SkipNode<>(null, 0);
        size = 0;
        //初始化头结点的每一层
        for (int i = 0; i < MAX_LEVEL; i++) {
            head.next[i] = tail;
        }
    }

    //是否包含节点
    public boolean contains(Key key) {

        return __find(key) != null;
    }

    //查找某一个节点的值
    public Value find(Key key) {
        SkipNode<Key, Value> node = __find(key);

        if (node == null || node.pair == null) {
            return null;
        }
        return node.pair.getValue();

    }

    //插入节点
    public void insert(Key key, Value value) {
        SkipNode<Key, Value> node = search(key);//查找该节点是否已经存在
        if (node.pair != null && node.pair.getKey() == key) {
            node.pair.setValue(value);//如果已经存在了，则更改其值
            return;
        }
        node = new SkipNode<>(new MutablePair<>(key, value), MAX_LEVEL);//新节点
        int new_level = level();
        if (new_level > level) {
            new_level = ++level;//新增节点所处的层级
            last[new_level] = head;
        }
        for (int i = new_level; i >= 0; i--) {//对要新增节点的前一个节点，更改其下一个节点的指向
            node.next[i] = last[i].next[i];
            last[i].next[i] = node;
        }
        size++;//增加节点个数
    }

    //删除指定节点
    public void erase(Key key) {
        SkipNode<Key, Value> node = search(key);
        if (node.pair.getKey() != key) {
            throw new NullPointerException("there's no such key!");
        }
        for (int i = 0; i <= level && last[i].next[i] == node; i++) {
            last[i].next[i] = node.next[i];
        }
        node = null;//删除节点
        //更新链表层级
        while (level > 0 && head.next[level] == tail) {
            level--;
        }
        size--;

    }

    public int Size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //新节点层级分配
    private int level() {
        int lev = 0;
        while (RandomUtils.nextInt() % 2 != 0) {
            lev++;
        }
        return lev < MAX_LEVEL ? lev : MAX_LEVEL;
    }

    private SkipNode<Key, Value> search(Key key) {
        last = new SkipNode[MAX_LEVEL];
        SkipNode<Key, Value> cur = head;
        for (int i = level; i >= 0; i--) {
            while (cur.next[i].pair != null && cur.next[i].pair.getKey().compareTo(key) < 0) {
                cur = cur.next[i];
            }
            last[i] = cur;//保存每一层最后一个小于key的节点
        }
        return cur.next[0];
    }

    //找到key对应的节点
    private SkipNode<Key, Value> __find(Key key) {

        SkipNode<Key, Value> cur = head;//设置当前节点
        for (int i = level; i >= 0; i--) {//从最顶层开始查找，直到最底层
            while (cur.next[i].pair != null && cur.next[i].pair.getKey().compareTo(key) < 0) {//如果下一个节点比key小则继续在该层查找
                cur = cur.next[i];//将当前节点后移
            }
            if (cur.next[i].pair != null && cur.next[i].pair.getKey() == key) {//如果找到节点则返回
                return cur.next[i];
            }
        }
        return null;

    }

    //打印每一层
    public void show() {
        //System.out.println("show");
        for (int i = level; i >= 0; i--) {
            for (SkipNode<Key, Value> node : getLevel(i)) {
                System.out.print(node + "  ");
            }
            System.out.println();
        }
    }

    //获取指定层的数据
    public List<SkipNode<Key, Value>> getLevel(int level) {
        //System.out.println("get");
        if (level > this.level) {
            return null;
        }
        ArrayList<SkipNode<Key, Value>> result = new ArrayList<>();
        SkipNode<Key, Value> cur = head;
        while (cur.next[level] != tail) {
            result.add(cur.next[level]);
            cur = cur.next[level];
        }
        //System.out.println(1);
        return result;
    }


}