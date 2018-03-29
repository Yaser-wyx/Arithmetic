package 蓝桥.March2017;

public class B {
    public static void main(String[] args) {
        find(0);
        System.out.println(sum/6);
    }

    private static boolean vis[] = new boolean[10];
    private static int nums[] = new int[9];

    public static void find(int n) {
        if (n == 9) {
            if (judge()) {
                sum++;
            }
            return;
        }
        for (int i = 1; i < 10; i++) {
            if (!vis[i]) {
                vis[i] = true;
                nums[n] = i;
                find(n + 1);
                vis[i] = false;
            }

        }
    }

    static int sum = 0;

    public static boolean judge() {
        int a = 0;
        for (int i = 0; i <= 3; i++) {
            a += nums[i];
        }
        int b = 0;
        for (int i = 3; i <= 6; i++) {
            b += nums[i];
        }

        int c = 0;
        for (int i = 6; i <= 8; i++) {
            c += nums[i];
        }
        c += nums[0];
        return a == b && a == c;

    }
}
