package HDU;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-02-06
 * @Time: 20:04
 * To change this template use File | Settings | File Templates.
 * @desc
 */
public class Pro1430 {
    private static int[] origin = new int[8];//初始状态
    private static String[] path;
    private static int end;
    private static boolean[] vis;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
//        Scanner in = new Scanner(new File("C:\\Users\\wanyu\\Desktop\\Test.txt"));
        create();
        path[0] = "";
        while (in.hasNext()) {
            init(in);
            System.out.println(path[end]);
        }
    }

    private static void create() {//打表操作
        int[] num = {1, 2, 3, 4, 5, 6, 7, 8};
        Node1430 start = new Node1430(num, 0);//初始化开始节点
        path = new String[40320];
        vis = new boolean[40320];
        BFS(start);
    }

    private static void BFS(Node1430 start) {
        ArrayDeque<Node1430> queue = new ArrayDeque<>();
        queue.add(start);
        path[start.cantor] = "";
        while (!queue.isEmpty()) {
            Node1430 node = queue.poll();
            int cantor = node.cantor;
            int[] temp1 = A(node.state);
            int[] temp2 = B(node.state);
            int[] temp3 = C(node.state);
            int cantor1 = Cantor(temp1);
            int cantor2 = Cantor(temp2);
            int cantor3 = Cantor(temp3);
            if (!vis[cantor1]) {
                vis[cantor1] = true;
                Node1430 node1 = new Node1430(temp1, cantor1);
                path[cantor1] = path[cantor] + "A";
                queue.add(node1);
            }

            if (!vis[cantor2]) {
                vis[cantor2] = true;
                Node1430 node2 = new Node1430(temp2, cantor2);
                path[cantor2] = path[cantor] + "B";
                queue.add(node2);
            }
            if (!vis[cantor3]) {
                vis[cantor3] = true;
                Node1430 node3 = new Node1430(temp3, cantor3);
                path[cantor3] = path[cantor] + "C";
                queue.add(node3);
            }
        }
    }


    private static void init(Scanner in) {
        String line1[] = in.nextLine().split("");
        String line2[] = in.nextLine().split("");
        for (int i = 0; i < 8; i++) {
            origin[i] = Integer.parseInt(line1[i]);
        }
        int target[] = new int[8];
        int index[] = new int[9];
        for (int i = 0; i < 8; i++) {
            target[i] = Integer.parseInt(line2[i]);
            index[target[i]] = i;
        }
        for (int i = 1; i < 9; i++) {
            target[index[origin[i - 1]]] = i;
            origin[i - 1] = i;
        }
        end = Cantor(target);//计算终点的康托展开
    }

    private static int[] A(int[] num) {//操作A：上下两行互换
        int temp[] = new int[8];
        int j = 7;
        for (int i = 0; i < 8; i++) {
            temp[i] = num[j--];
        }
        return temp;
    }

    private static int[] B(int[] num) {//操作B：每行同时循环右移一格
        int temp[] = new int[8];

        int j = 3;
        for (int i = 0; i < 4; i++) {
            temp[i] = num[j++];
            if (j == 4) j = 0;
        }
        j = 5;
        for (int i = 4; i < 8; i++) {
            temp[i] = num[j++];
            if (j == 8) j = 4;
        }
        return temp;
    }

    private static int[] C(int[] num) {//操作C：中间4个方块顺时针旋转一格
        int temp[] = new int[8];
        System.arraycopy(num, 0, temp, 0, 8);
        temp[1] = num[6];
        temp[2] = num[1];
        temp[5] = num[2];
        temp[6] = num[5];
        return temp;
    }

    private static int Cantor(int[] num) {//康托展开
        int sum = 0;
        int fac[] = {1, 1, 2, 6, 24, 120, 720, 5040, 40320};//0到9各个数的阶乘
        for (int i = 0; i < 7; i++) {
            int temp = 0;
            for (int j = i + 1; j < 8; j++) {
                if (num[i] > num[j]) temp++;
            }
            sum += temp * fac[7 - i];
        }
        return sum;
    }
}

class Node1430 {
    int[] state;
    int cantor;

    Node1430(int[] state, int cantor) {
        this.state = new int[8];
        System.arraycopy(state, 0, this.state, 0, state.length);
        this.cantor = cantor;
    }

}