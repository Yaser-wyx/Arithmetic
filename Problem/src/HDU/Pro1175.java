package HDU;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-02-06
 * @Time: 17:12
 * To change this template use File | Settings | File Templates.
 * @desc
 */
public class Pro1175 {
    private static int[][] puzzle;//连连看的数据
    private static int[][] query;//每一次查询的请求
    private static int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};//移动数组
    private static boolean[][] visited;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        //Scanner in = new Scanner(new File("C:\\Users\\wanyu\\Desktop\\Test.txt"));
        while (init(in)) {
            for (int[] aQuery : query) {
                int x1 = aQuery[0];
                int y1 = aQuery[1];
                int x2 = aQuery[2];
                int y2 = aQuery[3];
                if (puzzle[x1][y1] != puzzle[x2][y2] || puzzle[x1][y1] == 0 || puzzle[x2][y2] == 0) {
                    System.out.println("NO");
                    continue;
                }
                int temp = puzzle[x2][y2];
                puzzle[x2][y2] = 0;
                visited = new boolean[puzzle.length][puzzle[0].length];
                DFS(0, x1, y1, x2, y2, new int[]{0, 0});
                if (result) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
                result = false;
                puzzle[x2][y2] = temp;

            }
        }
    }

    /**
     * @param change 转向的次数
     * @param x1     当前的坐标
     * @param y1     当前的坐标
     * @param x2     目标坐标
     * @param y2     目标坐标
     * @param last   上一次到(x1,y1)的方向坐标
     */
    private static boolean result = false;

    private static void DFS(int change, int x1, int y1, int x2, int y2, int[] last) {
        if (x1 == x2 && y1 == y2) {
            result = true;
            return;
        }
        for (int i = 0; i < 4; i++) {
            //新的坐标
            int new_x = x1 + move[i][0];
            int new_y = y1 + move[i][1];
            if (new_x >= 1 && new_x < puzzle.length && new_y >= 1 && new_y < puzzle[0].length) {//判断新的坐标是否合法
                if (puzzle[new_x][new_y] == 0) {//是否可以移动
                    if (!visited[new_x][new_y]) {//是否已经访问过了
                        int temp = change;
                        if (Math.abs(last[0] + move[i][0]) == 1 && Math.abs(last[1] + move[i][1]) == 1) temp++;//变向了
                        if (temp == 2) {
                            if (new_x != x2 && new_y != y2) {
                                continue;
                            }
                        }

                        if (temp > 2) {
                            continue;
                        }
                        visited[new_x][new_y] = true;
                        DFS(temp, new_x, new_y, x2, y2, new int[]{move[i][0], move[i][1]});
                        if (result) return;
                        visited[new_x][new_y] = false;
                    }
                }
            }
        }
    }


    private static boolean init(Scanner in) {
        int n = in.nextInt();
        int m = in.nextInt();
        if (n + m == 0) return false;
        puzzle = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                puzzle[i][j] = in.nextInt();
            }
        }
        int q = in.nextInt();
        query = new int[q][4];//查询
        for (int i = 0; i < q; i++) {
            for (int j = 0; j < 4; j++) {
                query[i][j] = in.nextInt();
            }
        }
        return true;
    }
}
