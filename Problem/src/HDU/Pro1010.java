package HDU;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-29
 * @Time: 18:59
 * To change this template use File | Settings | File Templates.
 * @desc
 */
public class Pro1010 {
    private static int[][] step;
    private static String[][] maze;
    private static int t;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));

        while (true) {


            ok = false;
            int n = in.nextInt();
            int m = in.nextInt();
            t = in.nextInt();
            if (n == 0 && m == 0 && t == 0) {
                break;
            }
            in.nextLine();//清除缓冲区的\n
            maze = new String[n][m];//迷宫
            step = new int[n][m];
            int num = 0;
            for (int i = 0; i < n; i++) {
                maze[i] = in.nextLine().split("");//读入迷宫
            }
            //起点坐标
            int x = 0;
            int y = 0;
            int ex = 0;
            int ey = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    step[i][j] = -1;
                    if (maze[i][j].equals("S")) {
                        x = i;
                        y = j;
                    } else if (maze[i][j].equals(".")) {
                        num++;
                    } else if (maze[i][j].equals("D")) {
                        ex = i;
                        ey = j;
                    }
                }
            }
            int min = Math.abs(ex - x) + Math.abs(ey - y);
            if (num + 1 < t || min > t || (min & 1) != (t & 1)) {//奇偶剪枝
                System.out.println("NO");
                continue;
            }
            step[x][y] = 0;
            find(x, y);
            if (ok) {
                System.out.println("YES");
            } else System.out.println("NO");
        }

    }

    private static int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static boolean ok = false;

    private static void find(int x, int y) {
        int now_x, now_y;
        for (int i = 0; i < 4; i++) {
            now_x = x + move[i][0];
            now_y = y + move[i][1];
            if (now_x < maze.length && now_y < maze[0].length && now_x >= 0 && now_y >= 0) {//确保边界
                if (maze[now_x][now_y].equals(".")) {//确保可走
                    int num = step[x][y] + 1;
                    if (num >= t) {
                        continue;
                    }
                    if (step[now_x][now_y] == -1) {
                        step[now_x][now_y] = num;
                        find(now_x, now_y);
                        step[now_x][now_y] = -1;
                        if (ok) return;
                    }
                } else if (maze[now_x][now_y].equals("D")) {//出口
                    int num = step[x][y] + 1;
                    if (num == t) {
                        ok = true;
                        return;
                    }

                }
            }
        }

    }

}
