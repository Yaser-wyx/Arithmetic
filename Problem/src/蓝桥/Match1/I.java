package 蓝桥.Match1;

import java.util.Scanner;

class node {
    int size = 0;
    int c = -1;
}

public class I {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        node node[] = new node[n];
        int last = -1;
        int now;
        int index = -1;
        for (int i = 0; i < n; i++) {
            now = scanner.nextInt();
            if (now == last) {
                node[index].size++;
                if (node[index].c == -1) {
                    node[index].c = now;
                }
            } else {
                last = now;
                index++;
                node[index] = new node();
                node[index].size = 1;
                node[index].c = now;
            }
        }
        int min = Integer.MAX_VALUE;
        int l = 0, r = 0;
        for (int i = 0; i <= index; i++) {
            int len = 0;
            int diff = 0;
            boolean vis[] = new boolean[m + 1];
            for (int j = i; j <= index; j++) {

                if (!vis[node[j].c]) {
                    diff++;
                    vis[node[j].c] = true;
                }
                len += node[j].size;
                if (diff == m) {
                    if (min > len) {
                        min = len;
                        l = i;
                        r = j;
                    }
                    break;
                }
            }
        }
        min -= ((node[l].size - 1) + (node[r].size - 1));
        System.out.println(min);

    }
}
