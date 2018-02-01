package HDU;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-02-01
 * @Time: 12:47
 * To change this template use File | Settings | File Templates.
 * @desc 此题有毒
 */
public class Pro1070 {
    public static void main(String[] args) throws FileNotFoundException {
        //Scanner in = new Scanner(new BufferedInputStream(System.in));
        File file = new File("C:\\Users\\wanyu\\Desktop\\2.txt");
        PrintWriter printWriter = new PrintWriter(file);
        Scanner in = new Scanner(new File("C:\\Users\\wanyu\\Desktop\\Test.txt"));
        int T = Integer.parseInt(in.nextLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(in.nextLine());
            Milk milk = new Milk("", Integer.MAX_VALUE, 1);
            for (int j = 0; j < n; j++) {
                String line[] = in.nextLine().split(" ");
                int capacity = Integer.parseInt(line[2]);
                if (capacity < 200) continue;
                Milk temp = new Milk(line[0], Integer.parseInt(line[1]), capacity);
                if (milk.compareTo(temp) > 0) milk = temp;
            }

            printWriter.append(String.valueOf(milk)).append("\n");
        }
        printWriter.flush();

    }
}

class Milk implements Comparable {
    private String brand;
    private double price;//价格
    private double capacity;//容量
    private double everyday;//每天的花费

    public Milk(String brand, int price, int capacity) {
        this.brand = brand;
        this.price = price;
        this.capacity = capacity;
        double day = capacity / 200;
        if (day >= 6) {
            everyday = price / 5.0;
        } else {
            everyday = price / day;
        }
    }


    @Override
    public String toString() {
        return brand;
    }

    @Override
    public int compareTo(Object o) {
        Milk milk = (Milk) o;
        if (milk.everyday > this.everyday) {
            return -1;
        } else if (milk.everyday < this.everyday) {
            return 1;
        } else {
            if (milk.capacity > this.capacity) {
                return 1;
            } else if (milk.capacity < this.capacity) {
                return -1;
            }
        }
        return 0;
    }
}