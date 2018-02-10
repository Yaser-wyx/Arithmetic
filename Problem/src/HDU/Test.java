package HDU;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-26
 * @Time: 15:44
 * To change this template use File | Settings | File Templates.
 * @desc
 */
public class Test {
    private static int[] target_index = new int[9];//target的索引数组
    private static int[] origin = new int[8];//初始状态

    public static void main(String[] args) {
        int[] a = {1, 4, 2, 8, 6, 3};
        int[] nums = {1, 3, 5, 7, 9};
        System.out.println(-Arrays.binarySearch(nums, 0, nums.length, 8) - 1);
    }

    private static int H(int[] num) {//评估函数
        int h = 0;
        for (int i = 0; i < 8; i++) {
            int temp = Math.abs(target_index[num[i]] - i);
            h += temp;
        }
        return h;
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


    private static ArrayList<int[]> list = new ArrayList<>();
    private static boolean visited[] = new boolean[9];

    private static void arrange(int index, int[] num) {
        if (index == 9) {
            list.add(num);
            return;
        }
        for (int i = 0; i < 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                num[index] = i;
                arrange(index + 1, num);
                visited[i] = false;
            }
        }
    }
}