import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-21
 * @Time: 16:25
 * To change this template use File | Settings | File Templates.
 * @desc
 */
public class Test10 {
    private ArrayList<Integer>[] apprentice;
    private boolean visited[];
    private int nums[];

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int p = scanner.nextInt();
        Test10 test10 = new Test10();
        test10.apprentice = new ArrayList[n + 1];
        test10.visited = new boolean[n + 1];
        test10.nums = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            test10.apprentice[i] = new ArrayList<Integer>();
        }

        for (int i = 1; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            test10.apprentice[a].add(b);
            test10.apprentice[b].add(a);//先保存为双向图
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(p);
        test10.find(p, arrayList);
        for (int i = 1; i < test10.nums.length; i++) {
            System.out.print(test10.nums[i]);
            if (i != test10.nums.length - 1) {
                System.out.print(" ");
            }
        }

    }


    public void find(int a, ArrayList<Integer> list) {
        if (visited[a])
            return;
        visited[a] = true;
        for (int b : apprentice[a]) {
            if (visited[b])
                continue;
            for (int f : list) {
                if (b < f) {
                    nums[f]++;
                }
            }
            list.add(b);
            find(b, list);
            list.remove(list.size() - 1);
        }

    }


}

