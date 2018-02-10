package HDU;

import java.io.BufferedInputStream;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-02-02
 * @Time: 18:10
 * To change this template use File | Settings | File Templates.
 * @desc HDU1043 双向广搜+HASH
 */
public class Pro1043_2 {

    private static int[] move = {1, -3, -1, 3};//移动数组
    private static int[] map;//存储八数码
    private static boolean[] visited1;//判断从start扩展来的是否已经访问过
    private static boolean[] visited2;//判断从end扩展来的是否已经访问过
    private static String[] path;
    private static int start = 0;//起始点

    private static void init(Scanner in) {//初始化信息
        String[] line = in.nextLine().split("");//读取输入
        map = new int[9];
        path = new String[363000];
        visited1 = new boolean[363000];
        visited2 = new boolean[363000];
        int j = 0;
        for (String aLine : line) {
            if (aLine.equals(" ")) continue;
            if (aLine.equals("x")) {
                start = j;//起始点
                map[j++] = 0;
                continue;
            }
            map[j++] = Integer.parseInt(aLine);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while (in.hasNext()) {
            init(in);//初始化
            if (judge()) {//判断有无解
                //状态可达
                //进行双向广搜
                Node snode = new Node(map, Cantor(map), start);//初始化开始节点
                int[] num = {1, 2, 3, 4, 5, 6, 7, 8, 0};
                int cantor = Cantor(num);
                Node enode = new Node(num, cantor, 8);//初始化结束节点
                BFS(snode, enode);
            } else {
                //状态不可达
                System.out.println("unsolvable");
            }
        }
    }


    private static void BFS(Node start, Node end) {//双向广搜
        //两个初始点已访问
        visited1[start.cantor] = true;
        visited2[end.cantor] = true;
        //初始化两个节点的初始路径
        path[start.cantor] = "";
        path[end.cantor] = "";
        Deque<Node> Squeue = new ArrayDeque<>();
        Deque<Node> Equeue = new ArrayDeque<>();
        //添加节点
        Squeue.add(start);
        Equeue.add(end);

        while (!Squeue.isEmpty() && !Equeue.isEmpty()) {//两个同时不为空，同时对两个状态进行扩展
            //先扩展初始状态
            Node snode = Squeue.poll();
            int Sindex = snode.index;
            for (int i = 0; i < 4; i++) {
                //边界情况处理
                if ((Sindex == 0 || Sindex == 3 || Sindex == 6) && move[i] == -1) continue;
                if ((Sindex == 2 || Sindex == 5 || Sindex == 8) && move[i] == 1) continue;
                int newIndex = Sindex + move[i];//新的x的位置

                if (newIndex >= 0 && newIndex <= 8) {//新的位置是合法的
                    Node newNode = new Node(snode.state, snode.cantor, snode.index);//初始化新的节点
                    newNode.state[Sindex] = newNode.state[newIndex];
                    newNode.state[newIndex] = 0;
                    newNode.index = newIndex;
                    int cantor = Cantor(newNode.state);
                    if (!visited1[cantor]) { //是否访问过了
                        String p = path[snode.cantor] + transform(move[i], 1);//暂时保存路径
                        newNode.cantor = cantor;
                        visited1[cantor] = true;//设为已访问
                        if (visited2[cantor]) {
                            //如果该节点两边都扩展到了，则表示已经找到了
                            System.out.println(p + new StringBuilder(path[cantor]).reverse());
                            //因为从目标状态过来的，所以需要将路径进行翻转操作
                            return;
                        }
                        path[cantor] = p;//保存路径
                        Squeue.add(newNode);//入队
                    }
                }
            }
            //再扩展目标状态
            Node enode = Equeue.poll();
            int Eindex = enode.index;
            for (int i = 0; i < 4; i++) {
                //边界情况处理
                if ((Eindex == 0 || Eindex == 3 || Eindex == 6) && move[i] == -1) continue;
                if ((Eindex == 2 || Eindex == 5 || Eindex == 8) && move[i] == 1) continue;
                int newIndex = Eindex + move[i];//新的x的位置

                if (newIndex >= 0 && newIndex <= 8) {//新的位置是合法的
                    Node newNode = new Node(enode.state, enode.cantor, enode.index);//初始化新的节点
                    newNode.state[Eindex] = newNode.state[newIndex];
                    newNode.state[newIndex] = 0;
                    newNode.index = newIndex;
                    int cantor = Cantor(newNode.state);
                    if (!visited2[cantor]) { //是否访问过了

                        StringBuilder p = new StringBuilder(path[enode.cantor] + transform(move[i], 0));//暂时保存路径
                        newNode.cantor = cantor;
                        visited2[cantor] = true;//设为已访问
                        if (visited1[cantor]) {
                            //如果该节点两边都扩展到了，则表示已经找到了
                            System.out.println(path[cantor] + p.reverse());
                            return;
                        }
                        path[cantor] = p.toString();
                        Equeue.add(newNode);//入队
                    }
                }
            }
        }
    }

    /**
     * @param x     扩展方向
     * @param state 从开始还是结尾扩展而来的
     * @return 方向
     */
    private static String transform(int x, int state) {
        String res = "";
        if (state == 1) {//开始节点
            switch (x) {
                case 1:
                    res = "r";
                    break;
                case -1:
                    res = "l";
                    break;
                case 3:
                    res = "d";
                    break;
                case -3:
                    res = "u";
                    break;
            }
        } else {
            switch (x) {
                case 1:
                    res = "l";
                    break;
                case -1:
                    res = "r";
                    break;
                case 3:
                    res = "u";
                    break;
                case -3:
                    res = "d";
                    break;
            }
        }
        return res;

    }

    private static boolean judge() {//判断是否有解只需要判断逆序对的个数
        int num = 0;//逆序数和
        for (int i = 0; i < map.length - 1; i++) {
            if (map[i] == 0) continue;//如果是0就跳过
            for (int j = i + 1; j < map.length; j++) {
                if (map[i] > map[j] && map[j] != 0) {
                    num++;
                }
            }
        }
        return (num & 1) == 0;//如果是偶数，表示该状态可达
    }

    private static int Cantor(int[] nums) {//计算康托展开式
        int res = 0;
        int fac[] = {1, 1, 2, 6, 24, 120, 720, 5040, 40320};//0到9各个数的阶乘
        for (int i = 0; i < nums.length - 1; i++) {
            int sum = 0;//比nums[i]小的数
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) sum++;
            }
            res += sum * fac[nums.length - i - 1];
        }
        return res + 1;
    }
}

class Node {
    int state[];//状态
    int cantor;//hash值
    int index;//x的位置

    Node(int[] state, int cantor, int index) {
        this.state = new int[state.length];
        System.arraycopy(state, 0, this.state, 0, state.length);
        this.cantor = cantor;
        this.index = index;
    }
}
