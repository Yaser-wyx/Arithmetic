package 蓝桥.Match1;

import java.util.Scanner;

public class G {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s[] = scanner.nextLine().split("");
        int max = 1;
        for (int i = 0; i < s.length; i++) {
            if (max >= (s.length - i + 1)) {
                break;
            }
            for (int j = s.length - 1; j >= i; j--) {
                if (max >= (j - i + 1)) {
                    break;
                }
                int l = i;
                int r = j;
                while (l <= r && s[l].equals(s[r])) {
                    l++;
                    r--;
                }
                if (l > r) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        System.out.println(max);
    }
}
