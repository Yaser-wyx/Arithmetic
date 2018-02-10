package 牛客;

import java.io.BufferedInputStream;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-02-09
 * @Time: 20:03
 * To change this template use File | Settings | File Templates.
 * @desc
 */
public class B {
    private static String[][] map;
    private static int[][] move = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    private static Queue<size> nodes = new ArrayDeque<>();//存放所有节点
    private static int[][] map2 = new int[4][4];//使用邻接矩阵进行表示

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int h = in.nextInt();
        int w = in.nextInt();
        in.nextLine();
        map = new String[h][w];
        for (int i = 0; i < h; i++) {
            String[] line = in.nextLine().split("");
            //初始化
            for (int j = 0; j < w; j++) {
                map[i][j] = line[j];
                if (!(map[i][j].equals("W") || map[i][j].equals("."))) {
                    size temp = new size(i, j);
                    nodes.add(temp);//用于构建带权图
                }
            }
        }
        BFS();
        if (map2[0][3] != 0 || (map2[0][1] != 0 && map2[1][2] != 0 && map2[2][3] != 0)) {
            //有出口只有两种情况
            //1.S->E
            //2.S->K->D->E
            int s_k_d_e = map2[0][1] + map2[1][2] + map2[2][3];
            if (map2[0][3] == 0) {
                //S到不了E
                System.out.println(s_k_d_e);
            } else {
                //S能到E
                if (map2[0][1] == 0 || map2[0][2] == 0 || map2[1][2] == 0 || map2[2][3] == 0 || map2[1][3] == 0) {
                    //S,K,D,E之间有断层
                    System.out.println(map2[0][3]);
                } else {
                    //S,K,D,E没有断层
                    //同时S能到E
                    if (map2[0][3] > s_k_d_e) {//判断谁更快
                        System.out.println(s_k_d_e);
                    } else {
                        System.out.println(map2[0][3]);
                    }
                }
            }
        } else {
            System.out.println(-1);
        }
    }

    private static int transform(String s) {
        switch (s) {
            case "S":
                return 0;
            case "K":
                return 1;
            case "D":
                return 2;
            case "E":
                return 3;
        }
        return -1;
    }

    private static void BFS() {
        while (!nodes.isEmpty()) {
            size now = nodes.poll();//取出一个节点
            boolean[][] visited = new boolean[map.length][map[0].length];
            ArrayDeque<size> queue = new ArrayDeque<>();
            queue.add(now);
            visited[now.x][now.y] = true;
            int[][] step = new int[map.length][map[0].length];//存放步数
            int v = transform(map[now.x][now.y]);
            while (!queue.isEmpty()) {
                size node = queue.poll();
                int x = node.x;
                int y = node.y;
                for (int i = 0; i < 4; i++) {
                    int new_x = x + move[i][0];
                    int new_y = y + move[i][1];
                    if (new_x >= 0 && new_y >= 0 && new_x < map.length && new_y < map[0].length) {
                        //是否合法
                        if (!map[new_x][new_y].equals("W")) {
                            //不是墙
                            if (!visited[new_x][new_y]) {
                                //未访问过
                                visited[new_x][new_y] = true;
                                int step_num = step[x][y] + 1;
                                step[new_x][new_y] = step_num;
                                size temp = new size(new_x, new_y);
                                if (!map[new_x][new_y].equals("D")) {
                                    queue.add(temp);//如果从其他节点到达门的时候，就不将其加入到队列中
                                }
                                String s = map[new_x][new_y];
                                if (!s.equals(".")) {
                                    int w = transform(s);
                                    map2[v][w] = step_num;
                                    map2[w][v] = step_num;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

class size {
    int x;
    int y;

    public size(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
