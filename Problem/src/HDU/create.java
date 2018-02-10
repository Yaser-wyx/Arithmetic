package HDU;

import org.apache.commons.lang3.RandomUtils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-31
 * @Time: 18:53
 * To change this template use File | Settings | File Templates.
 * @desc
 */
public class create {
    /*    public static void main(String[] args) throws FileNotFoundException {
            Scanner in = new Scanner(new BufferedInputStream(System.in));
            int n = in.nextInt();
            File file = new File("C:\\Users\\wanyu\\Desktop\\Test.txt");
            PrintWriter printWriter = new PrintWriter(file);
            for (int i = 0; i < n; i++) {
                boolean vis[] = new boolean[9];
                for (int j = 0; j < 8; j++) {
                    int temp = RandomUtils.nextInt(1, 9);
                    while (vis[temp]) temp = RandomUtils.nextInt(1, 9);
                    vis[temp] = true;
                    printWriter.print(temp);
                }
                printWriter.println();
                vis = new boolean[9];
                for (int j = 0; j < 8; j++) {
                    int temp = RandomUtils.nextInt(1, 9);
                    while (vis[temp]) temp = RandomUtils.nextInt(1, 9);
                    vis[temp] = true;
                    printWriter.print(temp);
                }
                printWriter.println();

            }
            printWriter.flush();
        }*/
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        File file = new File("C:\\Users\\wanyu\\Desktop\\Test.txt");//测试用例输出的路径，按需修改
        PrintWriter printWriter = new PrintWriter(file);
        int n = in.nextInt();//输入测试用例的个数
        for (int i = 0; i < n; i++) {
            boolean[] visted = new boolean[9];
            StringBuffer stringBuffer = new StringBuffer();
            int start = RandomUtils.nextInt(1, 9);//随机生成起点
            for (int j = 0; j < 9; j++) {
                if (j == start) {
                    stringBuffer.append("x  ");
                    continue;
                }
                int x = RandomUtils.nextInt(1, 9);
                while (visted[x]) x = RandomUtils.nextInt(1, 9);
                visted[x] = true;
                stringBuffer.append(x);
                if (j != 8)
                    stringBuffer.append("  ");
            }
            stringBuffer.append("\n");
            printWriter.append(stringBuffer);
        }
        printWriter.flush();
    }
   /* public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        File file = new File("C:\\Users\\wanyu\\Desktop\\Test.txt");
        PrintWriter printWriter = new PrintWriter(file);
        int n = in.nextInt();
        printWriter.append(n + "\n");
        for (int i = 0; i < n; i++) {
            int c = RandomUtils.nextInt(1, 100);
            StringBuffer buffer = new StringBuffer();
            buffer.append(c).append("\n");
            for (int j = 0; j < c; j++) {
                String brand = RandomStringUtils.random(10, "adsdhfayfgqwetuioasdfghjkxcvbnm");
                int price = RandomUtils.nextInt(1, 50);
                int capacity = RandomUtils.nextInt(100, 100000);
                buffer.append(brand).append(" ").append(price).append(" ").append(capacity).append("\n");
            }
            printWriter.append(buffer);
        }
        printWriter.flush();
        System.out.println("ok");
    }*/
   /* public static void main(String[] args) throws FileNotFoundException {
        int T = RandomUtils.nextInt(1, 100);
        File file = new File("C:\\Users\\wanyu\\Desktop\\Test.txt");
        PrintWriter printWriter = new PrintWriter(file);
        printWriter.append(String.valueOf(T)).append("\n\n");
        for (int i = 0; i < T; i++) {
            int W = RandomUtils.nextInt(2, 51);
            int H = RandomUtils.nextInt(2, 51);
            int L = RandomUtils.nextInt(1, 1000000);
            int M = RandomUtils.nextInt(1, 11);
            printWriter.append(W + " " + H + " " + L + " " + M + "\n");
            for (int j = 0; j < M; j++) {
                int x = RandomUtils.nextInt(100, 1000);
                printWriter.append(x + "");
                if (j != M - 1) printWriter.append(" ");
            }
            printWriter.append("\n");
            String map[][] = new String[H][W];
            int start_x = RandomUtils.nextInt(1, H - 1);
            int start_y = RandomUtils.nextInt(1, W - 1);
            map[start_x][start_y] = "@";
            int end_x = RandomUtils.nextInt(1, H - 1);
            int end_y = RandomUtils.nextInt(1, W - 1);
            map[end_x][end_y] = "<";
            boolean visited[][] = new boolean[H][W];
            visited[start_x][start_y] = true;
            visited[end_x][end_y] = true;
            char c = 'A';
            for (int j = 0; j < M; j++) {
                int x = RandomUtils.nextInt(1, H - 1);
                int y = RandomUtils.nextInt(1, W - 1);
                while (visited[x][y]) {
                    x = RandomUtils.nextInt(1, H - 1);
                    y = RandomUtils.nextInt(1, W - 1);
                }
                map[x][y] = String.valueOf(c);
                c++;
            }
            for (int j = 0; j < H; j++) {
                for (int x = 0; x < W; x++) {
                    if (j == 0 || j == H - 1 || x == 0 || x == W - 1) {
                        map[j][x] = "*";
                    } else if (map[j][x] == null) {
                        int b = RandomUtils.nextInt(0, 4);
                        if (b == 0) {
                            map[j][x] = "*";
                        } else {
                            map[j][x] = ".";
                        }
                    }
                }

            }

            for (String[] str : map) {
                for (String s : str) {
                    printWriter.append(s);
                }
                printWriter.append("\n");
            }
            if (i != T - 1) printWriter.append("\n");
        }
        printWriter.flush();
    }*/
}
