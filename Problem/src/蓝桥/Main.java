package 蓝桥;

import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String args[]) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter printWriter = new PrintWriter(new BufferedOutputStream(System.out));
        in.nextToken();
        int n = (int) in.nval;
        int a[] = new int[n];
        int b[] = new int[n];
        in.nextToken();
        int emperor = (int) in.nval;
        in.nextToken();//丢弃皇帝右手的
        BigInteger all = new BigInteger(Integer.toString(emperor));
        BigInteger temp;
        for (int i = 0; i < n; i++) {
            in.nextToken();
            a[i] = (int) in.nval;
            in.nextToken();
            b[i] = (int) in.nval;
            temp = new BigInteger(Integer.toString(a[i]));
            all = all.multiply(temp);
        }
        BigInteger ans = new BigInteger(all.toString());
        for (int i = 0; i < n; i++) {
            BigInteger temp_a = new BigInteger(Integer.toString(a[i]));
            BigInteger temp_b = new BigInteger(Integer.toString(b[i]));
            temp = all.divide(temp_a.multiply(temp_b));
            if (ans.compareTo(temp) > 0) {
                ans = temp;
            }
        }
        if (ans.compareTo(new BigInteger("0")) == 0) {
            ans = new BigInteger("1");
        }
        printWriter.println(ans);
        printWriter.flush();


    }
}