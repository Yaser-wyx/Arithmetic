package 蓝桥;

import java.util.*;
import java.math.*;

public class Main {
    public static final int N = 10010;
    public static char[] str = new char[N];
    public static Stack<Integer> num = new Stack<Integer>();
    public static Stack<String> op = new Stack<String>();

    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static int priority(String c) {
        if (c.equals("*")) {
            return 2;
        }
        if (c.equals("+")) {
            return 1;
        }
        return 0;
    }

    public static void calculate() {
        int suma = 0, sumb = 0;
        int b = num.peek();
        num.pop();
        int a = num.peek();
        num.pop();
        switch (op.peek()) {
            case "+":
                num.push(a + b);
                break;
            case "*":
                num.push(a * b);
                break;
            case "S":
                while (b != 0) {
                    sumb += b % 10;
                    b /= 10;
                }
                while (a != 0) {
                    suma += a % 10;
                    a /= 10;
                }
                num.push(max(suma, sumb));
                break;
        }
        op.pop();
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int i = 0, j = 0, t = 0, n = 0, m = 0, tt = 0, tmp = 0;
        t = cin.nextInt();
        while (t-- != 0) {
            String s = cin.next();
            s += "=";
            str = s.toCharArray();

            while (!op.empty()) {
                op.pop();
            }
            while (!num.empty()) {
                num.pop();
            }
            int len = str.length;

            for (i = 0; i < len; i++) {
                if (str[i] >= '0' && str[i] <= '9') {
                    //sscanf(str + i, "%d%n", &tmp, &n);
                    //i += n - 1;
                    tmp = 0;
                    for (; i < len; ++i) {
                        if (str[i] >= '0' && str[i] <= '9') {
                            tmp = tmp * 10 + (int) (str[i] - '0');
                        } else {
                            break;
                        }
                    }
                    --i;
                    num.push(tmp);
                } else if (str[i] == '(') {
                    op.push(String.valueOf(str[i]));
                } else if (str[i] == ')') {
                    while (op.peek().equals("(") != true) {
                        calculate();
                    }
                    op.pop();
                } else if (str[i] == 'S') {
                    op.push("(");
                    op.push("S");
                    i += 4;
                } else if (str[i] == ',') {
                } else if (op.empty() || priority(String.valueOf(str[i])) > priority(op.peek())) {
                    op.push(String.valueOf(str[i]));
                } else {
                    while (false == op.empty() && priority(String.valueOf(str[i])) <= priority(op.peek())) {
                        calculate();
                    }
                    op.push(String.valueOf(str[i]));
                }
            }
            System.out.printf("%d\n", num.peek());
        }
    }
}