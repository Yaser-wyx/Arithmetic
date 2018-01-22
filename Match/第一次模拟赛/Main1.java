/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-21
 * @Time: 18:38
 * To change this template use File | Settings | File Templates.
 * @desc
 */

import java.util.*;

public class Main1 {
    private static HashMap<Integer, List<Integer>> apprentice = new HashMap<>();
    private static int[] result;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//行数为n-1
        int p = scanner.nextInt();//祖师爷武功排名
        boolean[] master = new boolean[n + 1];//为true就表示已经是师傅了
        result = new int[n + 1];
        master[p] = true;
        HashMap<Integer, List<Integer>> pair = new HashMap<>();
        int temp = 0;//保存关系没有确定的
        for (int i = 0; i < n - 1; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (master[a]) {
                //如果a是师父，就意味着b是徒弟
                if (apprentice.get(a) == null) {
                    List<Integer> list = new LinkedList<>();
                    list.add(b);
                    apprentice.put(a, list);
                } else {
                    apprentice.get(a).add(b);
                }
                master[b] = true;//当完一人的徒弟之后，再次出现必定是师父
            } else if (master[b]) {
                if (apprentice.get(b) == null) {
                    List<Integer> list = new LinkedList<>();
                    list.add(a);
                    apprentice.put(b, list);
                } else {
                    apprentice.get(b).add(a);
                }
                master[a] = true;
            } else {
                //两个人的关系不确定
                temp++;

                if (pair.get(a) == null) {
                    List<Integer> list = new LinkedList<>();
                    list.add(b);
                    pair.put(a, list);
                } else {
                    pair.get(a).add(b);
                }
            }
        }

        while (temp != 0) {//不断处理关系一开始不确定的，直至关系全部确定
            Set<Integer> key = pair.keySet();
            for (int a : key) {
                if (pair.get(a).isEmpty()) {
                    continue;
                }
                for (int i = 0; i < pair.get(a).size(); i++) {
                    int b = pair.get(a).get(i);
                    if (master[a]) {
                        //如果a是师父，就意味着b是徒弟
                        if (apprentice.get(a) == null) {
                            List<Integer> list = new LinkedList<>();
                            list.add(b);
                            apprentice.put(a, list);
                        } else {
                            apprentice.get(a).add(b);
                        }
                        master[b] = true;//当完一人的徒弟之后，再次出现必定是师父
                        pair.get(a).remove(i);
                        temp--;
                    } else if (master[b]) {
                        if (apprentice.get(b) == null) {
                            List<Integer> list = new LinkedList<>();
                            list.add(a);
                            apprentice.put(b, list);
                        } else {
                            apprentice.get(b).add(a);
                        }
                        master[a] = true;
                        pair.get(a).remove(i);
                        temp--;
                    }
                }

            }

        }

        Main1 main = new Main1();
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(p);
        main.find(p, linkedList);
        for (int i = 1; i <= n; i++) {
            System.out.print(result[i] + " ");
        }
    }


    public void find(int m, LinkedList<Integer> nums) {
        if (apprentice.get(m) == null) {
            return;
        }

        for (int a : apprentice.get(m)) {
            for (int i : nums) {
                if (a < i) {
                    result[i]++;
                }
            }
            nums.add(a);
            find(a, nums);
            nums.removeLast();
        }

    }
}

