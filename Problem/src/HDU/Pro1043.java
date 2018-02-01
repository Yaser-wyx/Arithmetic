package HDU;

import java.io.BufferedInputStream;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-31
 * @Time: 15:09
 * To change this template use File | Settings | File Templates.
 * @desc 逆向打表+BFS+哈希
 */
public class Pro1043 {

    private static int[] move = {-1, -3, 1, 3};//移动数组
    private static int[] map;//存储八数码
    private static boolean[] visited;//判断是否已经访问过
    private static String[] path = new String[363000];//保存已经遍历过的状态，使用哈希进行空间压缩

    private static void init(Scanner in) {//初始化信息
        String[] line = in.nextLine().split("");//读取输入
        map = new int[9];
        int j = 0;
        for (int i = 0; i < line.length; i++) {
            if (line[i].equals(" ")) continue;
            if (line[i].equals("x")) {
                map[j++] = 0;
                continue;
            }
            map[j++] = Integer.parseInt(line[i]);
        }
    }

    private static void create() {
        int[] num = {1, 2, 3, 4, 5, 6, 7, 8, 0};
        int cantor = Cantor(num);

        path[cantor] = "lr";//初始状态
        visited = new boolean[363000];//用于判重
        node node = new node(num, new StringBuffer(""), cantor, 8);
        BFS(node);
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        create();//进行打表

        while (in.hasNext()) {
            init(in);//初始化
            //先判断是否为无解
            //判断是否为无解只需要判断逆序对的个数
            int cantor = Cantor(map);
            if (path[cantor] == null) {
                System.out.println("unsolvable");
                continue;
            }
            StringBuffer stringBuffer = new StringBuffer(path[cantor]);
            System.out.println(stringBuffer.reverse());


        }
    }

    private static void BFS(node temp) {
        Queue<node> queue = new LinkedList<>();
        queue.add(temp);
        while (!queue.isEmpty()) {
            node node = queue.poll();//抛出队首元素
            for (int i = 0; i < 4; i++) {
                int index = node.index;
                int new_index = index + move[i];//确定x下一个位置
                //判断当前位置是否可以移动
                if ((index == 2 || index == 5 || index == 8) && i == 2) continue;
                if ((index == 0 || index == 3 || index == 6) && i == 0) continue;
                if (new_index >= 0 && new_index <= 8) {
                    HDU.node new_node = new node(node.state, node.path, node.index, node.cantor);//定义新的节点
                    //更新数据
                    new_node.state[index] = new_node.state[new_index];//直接赋值
                    new_node.state[new_index] = 0;
                    new_node.index = new_index;
                    int cantor = Cantor(new_node.state);//计算该状态的康托展开
                    if (visited[cantor]) continue;//如果该状态已经访问过，直接进入下一个状态
                    new_node.cantor = cantor;
                    visited[cantor] = true;
                    switch (move[i]) {
                        case 1:
                            new_node.path.append("l");
                            break;
                        case -1:
                            new_node.path.append("r");
                            break;
                        case -3:
                            new_node.path.append("d");
                            break;
                        case 3:
                            new_node.path.append("u");
                            break;
                        default:
                            break;
                    }
                    path[cantor] = new_node.path.toString();
                    queue.add(new_node);
                }
            }
        }

    }

    private static int Cantor(int[] a) {//计算该状态的康托展开
        int res = 0;
        int fac[] = {1, 1, 2, 6, 24, 120, 720, 5040, 40320};//0到9各个数的阶乘
        for (int i = 0; i < a.length; i++) {
            int temp = 0;//比a[i]小的数的个数
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) temp++;//在i之前出现过比a[i]小的数要去掉
            }
            res += temp * fac[a.length - i - 1];//计算
        }
        return res + 1;//返回a在全排列中排第几位

    }

}

class node {
    int[] state;//当前状态
    StringBuffer path;//路径
    int index;//x的位置
    int cantor;//康托展开

    public node(int[] state, StringBuffer path, int cantor, int index) {
        this.state = new int[state.length];
        System.arraycopy(state, 0, this.state, 0, state.length);
        this.path = new StringBuffer(path);
        this.index = index;
        this.cantor = cantor;
    }

    public node() {
    }

    @Override
    public String toString() {//打印节点的路径
        return path.toString();
    }
}