package HDU;

import java.io.BufferedInputStream;
import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-02-08
 * @Time: 19:25
 * To change this template use File | Settings | File Templates.
 * @desc
 */
public class Pro1072 {
    private static int[][] map;//迷宫
    private static size start;//开始节点
    private static size end;//结束节点
    private static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};//移动数组


    private static void init(Scanner in) {//初始化
        int n = in.nextInt();
        int m = in.nextInt();
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = in.nextInt();
                if (map[i][j] == 2) start = new size(i, j, 6, 0);
                if (map[i][j] == 3) end = new size(i, j, 0, -1);
            }
        }
        map[start.x][start.y] = 1;

    }

    private static void BFS() {
        ArrayDeque<size> deque = new ArrayDeque<>();
        deque.add(start);
        while (!deque.isEmpty()) {
            size node = deque.poll();
            int x = node.x;
            int y = node.y;
            for (int i = 0; i < 4; i++) {
                int new_x = x + move[i][0];//新的位置
                int new_y = y + move[i][1];
                //判断是否合法
                if (new_x >= 0 && new_y >= 0 && new_x < map.length && new_y < map[0].length) {
                    if (map[new_x][new_y] != 0) {
                        int t = node.time - 1;//剩余时间
                        if (t == 0) continue;
                        int step = node.step + 1;//步数
                        if (map[new_x][new_y] == 4) {//加时
                            t = 6;
                            map[new_x][new_y] = 0;//设置为不可走
                        }
                        if (map[new_x][new_y] == 3 && t > 0) {
                            end.step = step;
                            return;
                        }
                        size size = new size(new_x, new_y, t, step);
                        deque.add(size);//入队
                    }
                }

            }
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int T = in.nextInt();
        while (T != 0) {
            T--;
            init(in);
            BFS();
            System.out.println(end.step);
        }
    }
}

class size {//节点位置
    int x;
    int y;
    int time;//剩余时间
    int step;//步数

    public size(int x, int y, int time, int step) {
        this.x = x;
        this.y = y;
        this.time = time;
        this.step = step;
    }
}