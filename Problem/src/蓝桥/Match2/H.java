package 蓝桥.Match2;

import java.util.*;


class SuperStack {
    private Stack<Integer> stack = new Stack<>();

    private int[] re() {
        int temp[] = new int[stack.size()];
        int index = 0;
        while (!stack.isEmpty()) {
            temp[index++] = stack.pop();
        }
        for (int i = index - 1; i >= 0; i--) {
            stack.push(temp[i]);
        }
        return temp;
    }

    public void reverse() {
        int temp[] = re();
        stack.clear();
        for (int aTemp : temp) {
            stack.push(aTemp);
        }
    }

    public void pop() {
        stack.pop();
    }

    public void push(int x) {
        stack.push(x);
    }

    public void print() {
        if (stack.isEmpty()) {
            System.out.println();
            return;
        }
        int temp[] = re();
        for (int i = temp.length - 1; i >= 0; i--) {
            System.out.print(temp[i]);
            if (i != 0) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}

public class H {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        SuperStack superStack = new SuperStack();
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            switch (a) {
                case 1:
                    superStack.reverse();
                    break;
                case 2:
                    superStack.pop();
                    break;
                case 3:
                    int x = scanner.nextInt();
                    superStack.push(x);
                    break;
                case 4:
                    superStack.print();
                    break;
            }
        }
    }
}
