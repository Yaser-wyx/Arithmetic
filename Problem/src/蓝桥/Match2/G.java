package 蓝桥.Match2;

import java.util.Scanner;
import java.util.TreeSet;

public class G {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char c[] = scanner.nextLine().toCharArray();
        TreeSet<String> res = new TreeSet<>();
        for (int i = 0; i < c.length; i++) {
            for (int j = c.length - 1; j >= i; j--) {
                StringBuilder left = new StringBuilder();
                StringBuilder right = new StringBuilder();
                int l = i;
                int r = j;
                while (l < r && c[l] == c[r]) {
                    left.append(c[l]);
                    right.append(c[r]);
                    l++;
                    r--;
                }
                StringBuilder ans = new StringBuilder();
                //补全回文
                if (l > r) {
                    //产生了一个偶数位的回文串
                    ans.append(left).append(right.reverse());
                    res.add(ans.toString());
                } else if (l == r) {
                    //产生了一个奇数位的回文串
                    ans.append(left).append(c[l]).append(right.reverse());
                    res.add(ans.toString());
                }

            }
        }
        for (String s : res) {
            System.out.println(s);

        }
    }

}
