package myUnion_Find;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-06
 * @Time: 16:50
 * To change this template use File | Settings | File Templates.
 * @desc union find 的简单实现,查找十分快为O(1)，但合并操作时间复杂度为O(N)
 */
public class Quick_Find implements Union_Find{
    private int[] id;//所有集合元素用数组表示，索引表示元素，值表示所属的集合名
    private int count;//元素个数

    public Quick_Find(int count) {//初始化
        this.count = count;
        id = new int[count];
        for (int i = 0; i < count; i++) {//初始时，每一个元素自身就是一个集合
            id[i] = i;
        }
    }

    public int find(int p) {//查找p这个元素所属的集合
        assert p >= 0 && p < count;
        return id[p];
    }

    public boolean isConnected(int p, int q) {//判断p和q这两个元素是否能连接
        int pId = find(p);
        int qId = find(q);

        return pId == qId;
    }

    public void union(int p, int q) {//将p这个元素所属的所有集合数据合并到q元素所属的集合里面
        assert p >= 0 && p < count && q >= 0 && q < count;
        int qId = find(q);
        int pId = find(p);
        if (qId == pId) {//如果已经在一个集合里面了就不需要合并操作了
            return;
        }

        for (int i = 0; i < count; i++) {//否则，将所有与p连接的元素合并到q所在的集合里面
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
    }

}
