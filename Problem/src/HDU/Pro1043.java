package HDU;

import java.io.BufferedInputStream;
import java.util.ArrayDeque;
import java.util.Scanner;

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
                map[j++] = 0;//对X进行转换
                continue;
            }
            map[j++] = Integer.parseInt(line[i]);
        }
    }

    private static void create() {//进行打表操作
        int[] num = {1, 2, 3, 4, 5, 6, 7, 8, 0};//以目标状态作为初始状态进行逆向打表
        int cantor = Cantor(num);//计算康拓展开
        path[cantor] = "lr";//初始状态
        visited = new boolean[363000];//用于判重
        Node2 node = new Node2(num, new StringBuffer(""), cantor, 8);//初始节点
        BFS(node);
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        create();//进行打表
        while (in.hasNext()) {
            init(in);//初始化
            int cantor = Cantor(map);//计算初始状态的康托
            if (path[cantor] == null) {//如果没有到该状态的路径表示无解
                System.out.println("unsolvable");
                continue;
            }
            StringBuffer stringBuffer = new StringBuffer(path[cantor]);
            //注意因为是以目标状态作为初始状态进行打表的
            // 所以该路径是从目标状态到初始状态的，所以在输出时需要进行反转
            System.out.println(stringBuffer.reverse());

        }
    }

    private static void BFS(Node2 start) {//使用BFS进行解答树的搜索
        ArrayDeque<Node2> queue = new ArrayDeque<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            Node2 node = queue.poll();//抛出队首元素
            for (int i = 0; i < 4; i++) {//对该节点进行扩展
                int index = node.index;
                int new_index = index + move[i];//确定x下一个位置
                //判断当前位置是否可以移动
                if ((index == 2 || index == 5 || index == 8) && i == 2) continue;
                if ((index == 0 || index == 3 || index == 6) && i == 0) continue;
                if (new_index >= 0 && new_index <= 8) {//边界处理
                    Node2 new_node = new Node2(node.state, node.path, node.index, node.cantor);//定义新的节点
                    //更新数据
                    new_node.state[index] = new_node.state[new_index];//直接赋值
                    new_node.state[new_index] = 0;
                    new_node.index = new_index;
                    int cantor = Cantor(new_node.state);//计算该状态的康托展开
                    if (visited[cantor]) continue;//如果该状态已经访问过，直接进入下一个状态
                    new_node.cantor = cantor;
                    visited[cantor] = true;//标记该状态已经访问过了
                    switch (move[i]) {//添加路径
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
                    path[cantor] = new_node.path.toString();//保存路径信息
                    queue.add(new_node);//将该节点添加到队列中
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

class Node2 {
    int[] state;//当前状态
    StringBuffer path;//路径
    int index;//x的位置
    int cantor;//康托展开

    public Node2(int[] state, StringBuffer path, int cantor, int index) {
        this.state = new int[state.length];
        System.arraycopy(state, 0, this.state, 0, state.length);
        this.path = new StringBuffer(path);
        this.index = index;
        this.cantor = cantor;
    }

}