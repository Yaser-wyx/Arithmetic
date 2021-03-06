package HDU;

import java.io.BufferedInputStream;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-02-01
 * @Time: 16:22
 * To change this template use File | Settings | File Templates.
 * @desc
 */
public class Pro1044 {
    private static int W, H, L, M;
    private static int[] Jewels;
    private static char[][] map;
    private static Queue<Size> node;
    private static int[][] graph;
    private static int valuesum;

    private static void init(Scanner in) {//初始化
        node = new ArrayDeque<>();
        W = in.nextInt();//宽
        H = in.nextInt();//高
        L = in.nextInt();//时限
        M = in.nextInt();//珠宝个数
        Jewels = new int[M + 2];//存放珠宝的价值
        map = new char[H][W];//地图
        graph = new int[M + 2][M + 2];//使用邻接矩阵构建图，记录节点到节点之间的权值
        valuesum = 0;
        for (int i = 1; i <= M; i++) {
            Jewels[i] = in.nextInt();
            valuesum += Jewels[i];
        }
        in.nextLine();
        String[] line;
        for (int i = 0; i < H; i++) {
            line = in.nextLine().split("");//读入每一行
            for (int j = 0; j < W; j++) {
                map[i][j] = line[j].charAt(0);
                if (map[i][j] != '*' && map[i][j] != '.') {
                    node.add(new Size(i, j));//将珠宝，起点和终点都加入到队列中，作为构建带权无向图使用
                }
            }
        }
        create();
    }

    private static void create() {//使用BFS构建无向带权图
        //0作为起点，1~M作为珠宝，M+1作为终点
        int move[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};//移动数组
        while (!node.isEmpty()) {//获取任意节点之间的最短路径
            boolean visited[][] = new boolean[H][W];//该节点是否被遍历过
            Size now = node.poll();//从各个珠宝或起点终点节点中选取一个，开始使用BFS进行遍历
            Queue<Size> queue = new ArrayDeque<>();//存放以now作为起点开始遍历后的节点
            int v = transform(map[now.x][now.y]);//now节点在graph上的坐标
            visited[now.x][now.y] = true;//标记起点
            queue.add(now);
            int[][] map1 = new int[H][W];//一个节点对应一张图
            while (!queue.isEmpty()) {//BFS遍历
                Size temp = queue.poll();//弹出一个节点，对其周围进行遍历访问
                int x = temp.x;
                int y = temp.y;
                for (int i = 0; i < 4; i++) {
                    //新的坐标
                    int new_x = x + move[i][0];
                    int new_y = y + move[i][1];
                    //判断新的坐标是否合法
                    if (new_x >= 0 && new_x < H && new_y >= 0 && new_y < W && map[new_x][new_y] != '*') {
                        //合法的坐标
                        //判断是否访问过了
                        if (!visited[new_x][new_y]) {
                            //没有访问过
                            visited[new_x][new_y] = true;
                            map1[new_x][new_y] = map1[x][y] + 1;//从旧的节点过来+1
                            Size ns = new Size(new_x, new_y);
                            queue.add(ns);//将该节点保存
                            //判断是否为一个有意义的节点
                            if (map[new_x][new_y] != '.') {
                                int w = transform(map[new_x][new_y]);
                                //因为是无向图
                                if (graph[v][w] == 0) {
                                    graph[v][w] = map1[new_x][new_y];
                                    graph[w][v] = map1[new_x][new_y];
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static int transform(char c) {//转换
        int res = 0;
        if (c != '<' && c != '@') {
            res = c - 64;
        }
        if (c == '<') {
            res = M + 1;
        }
        if (c == '@') {
            res = 0;
        }
        return res;

    }

    private static boolean visited[];
    private static int max;

    private static void DFS(int now, int value, int time) {
        if (max == valuesum) return;
        if (now == M + 1) {
            max = Math.max(max, value);//到达终点了，看是否有更高的价值
            return;
        }
        for (int i = 0; i < M + 2; i++) {
            if (!visited[i]) {
                if (graph[now][i] != 0) {
                    //节点没有访问过
                    if (time + graph[now][i] <= L) {//没有超时
                        //可以访问
                        visited[i] = true;
                        DFS(i, value + Jewels[i], time + graph[now][i]);
                        visited[i] = false;

                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        //Scanner in = new Scanner(new File("C:\\Users\\wanyu\\Desktop\\Test.txt"));
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            in.nextLine();
            init(in);
            visited = new boolean[M + 2];
            visited[0] = true;
            max = -1;
            DFS(0, 0, 0);
            System.out.println("Case " + (i + 1) + ":");
            if (max == -1) {
                System.out.println("Impossible");
            } else {
                System.out.println("The best score is " + max + ".");
            }
            if (i != n - 1)
                System.out.println();
        }


    }
}

class Size {
    int x;//坐标
    int y;//坐标

    public Size(int x, int y) {
        this.x = x;
        this.y = y;
    }
}