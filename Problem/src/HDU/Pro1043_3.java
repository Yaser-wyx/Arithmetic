package HDU;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-02-05
 * @Time: 17:07
 * To change this template use File | Settings | File Templates.
 * @desc A*+Hash
 * 1.使用逆序对来判断是否有解
 * 2.有解的话使用A*进行路径搜索
 * 3.对于空间使用hash进行空间压缩
 */
public class Pro1043_3 {
    private static int[] map;
    private static int start;//起始点
    private static String[] path;//从起点到终点的路径
    private static int[] x = {0, 1, 2, 0, 1, 2, 0, 1, 2};//将一维数组转化为二维数组
    private static int[] y = {0, 0, 0, 1, 1, 1, 2, 2, 2};
    private static boolean[] visited;
    private static int[] move = {1, -1, 3, -3};
    private static int end;//结束状态

    private static void init(Scanner in) {//初始化，读取数据
        String[] line = in.nextLine().split("");
        map = new int[9];
        path = new String[363000];
        visited = new boolean[363000];
        int j = 0;
        for (String aLine : line) {
            if (aLine.equals(" ")) continue;
            if (aLine.equals("x")) {
                start = j;
                map[j++] = 9;
                continue;
            }
            map[j++] = Integer.parseInt(aLine);
        }

    }

    private static void A_Star(Node1 start) {//使用A*算法求解路径
        PriorityQueue<Node1> queue = new PriorityQueue<>();//优先队列
        queue.add(start);//加入初始节点
        path[start.cantor] = "";//初始化节点路径

        while (!queue.isEmpty()) {

            Node1 temp = queue.poll();//从队列中弹出f值最小的节点

            visited[temp.cantor] = true;
            //对其周围进行遍历,将符合要求的节点加入到队列中
            int index = temp.index;//x的位置
            for (int i = 0; i < 4; i++) {
                //确保边界
                if ((index == 0 || index == 3 || index == 6) && i == 1) continue;//左边界
                if ((index == 2 || index == 5 || index == 8) && i == 0) continue;//右边界
                int new_index = index + move[i];//新的x的位置
                if (new_index >= 0 && new_index <= 8) {
                    Node1 node = new Node1(new_index, temp.state, temp.cantor);//新的节点
                    node.state[index] = temp.state[new_index];
                    node.state[new_index] = 9;
                    node.index = new_index;
                    int cantor = cantor(node.state);//对应的hash值
                    node.cantor = cantor;
                    node.flush(temp.g + 1, h(node.state));//更新f值
                    if (!visited[cantor]) {//是否已经访问过了
                        long time1 = System.currentTimeMillis();
                        queue.add(node);//入队

                        switch (move[i]) {//更新路径
                            case 1:
                                path[cantor] = path[temp.cantor] + "r";
                                break;
                            case -1:
                                path[cantor] = path[temp.cantor] + "l";
                                break;
                            case -3:
                                path[cantor] = path[temp.cantor] + "u";
                                break;
                            case 3:
                                path[cantor] = path[temp.cantor] + "d";
                                break;

                        }
                        if (cantor == end) {//是否找到节点了
                            System.out.println(path[cantor]);
                            return;
                        }

                    }
                }

            }
        }


    }


    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("C:\\Users\\wanyu\\Desktop\\Test.txt"));
        end = cantor(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        int x = Integer.parseInt(in.nextLine());
        long time = System.currentTimeMillis();
        while (x != 0) {
            x--;

            init(in);
            if (judge()) {
                //构造初始节点
                Node1 node1 = new Node1(0, h(map), start, map, cantor(map));
                if (node1.cantor == end) {
                    System.out.println("lr");
                    continue;
                }
                A_Star(node1);//A*

                int sum = 0;
                for (boolean v : visited) {
                    if (v) sum++;
                }
                System.out.println("---" + sum + "---");
            } else {
                System.out.println("unsolvable");
            }
        }
        System.out.println("--------------------------");
        System.out.println(System.currentTimeMillis() - time);
        System.out.println("=================================");
        System.out.println(t);

    }

    private static long t = 0;

    //评估函数
    private static int h(int[] a) {//估计从当前节点到终点的代价
        //使用曼哈顿距离
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int n = a[i] - 1;
            int dis = Math.abs(x[i] - x[n]) + Math.abs(y[i] - y[n]);
            sum += dis;
        }

        return sum;

    }

    private static boolean judge() {//判断是否有解
        int sum = 0;
        for (int i = 0; i < map.length; i++) {
            if (map[i] == 9) continue;//跳过x的位置
            for (int j = i + 1; j < map.length; j++) {
                if (map[i] > map[j]) sum++;
            }
        }
        return (sum & 1) == 0;
    }

    private static int cantor(int[] num) {

        int sum = 0;
        int fac[] = {1, 1, 2, 6, 24, 120, 720, 5040, 40320};//0到9各个数的阶乘
        for (int i = 0; i < 8; i++) {
            int temp = 0;
            for (int j = i + 1; j < 9; j++) {
                if (num[i] > num[j]) temp++;
            }
            sum += temp * fac[8 - i];
        }
        return sum;

    }
}

class Node1 implements Comparable<Node1> {
    //A*算法的评估函数F=G+H
    //G表示从起点到当前节点的实际代价，H表示从当前节点到终点的估计代价
    int f, g, h;//评估函数
    int index;//x所在的位置
    int state[];//当前节点的状态
    int cantor;//hash值

    Node1(int g, int h, int index, int[] state, int cantor) {
        this.index = index;
        this.cantor = cantor;
        this.state = new int[state.length];
        System.arraycopy(state, 0, this.state, 0, state.length);
        flush(g, h);
    }

    public void flush(int g, int h) {
        this.g = g;
        this.h = h * 10;
        this.f = g + h;//刷新f值
    }

    Node1(int index, int[] state, int cantor) {
        this.index = index;
        this.cantor = cantor;
        this.state = new int[state.length];
        System.arraycopy(state, 0, this.state, 0, state.length);
    }

    @Override
    public int compareTo(Node1 n) {
        return f - n.f;
    }
}