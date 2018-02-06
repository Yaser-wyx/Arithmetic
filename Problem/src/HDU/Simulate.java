package HDU;

import org.apache.commons.lang3.RandomUtils;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-02-04
 * @Time: 8:57
 * To change this template use File | Settings | File Templates.
 * @desc
 */
class nn {
    int money;
    int last;
    int state;

    public nn(int money, int last, int state) {
        this.money = money;
        this.last = last;
        this.state = state;
    }
}

public class Simulate {
    public static void main(String[] args) {
        int ko = 0;
        int ss = 0;
        for (int a = 0; a < 100; a++) {
            int sum = 2000;
            int which = RandomUtils.nextInt(0, 2);
            for (int j = 0; j < 100; j++) {

                int x = 10;//投注次数
                int start;
                if (sum == 0 || sum < 20) {
                    ko++;
                    break;
                }
                if (sum < 200) {
                    start = sum;//初始资金
                    sum = 0;
                } else {
                    start = 200;
                    sum -= 200;
                }
                int money = 40;//启投资金
                boolean win = false;
                for (int i = 0; i < x; i++) {
                    //开始投注
                    int state = which % 2;
                    which = RandomUtils.nextInt(1, 17);
                    if (start == 0) break;
                    start -= money;//减去投注资金

                    if (which % 2 == 1) {//假设的状态与真实状态一致
                        //赢
                        win = true;
                        start += money * 2;

                        break;
                    } else {
                        //输
                        money *= 2;
                        if (money > 100)
                            money = 100;
                        if (start < money) {
                            money = start;
                        }

                    }

                    if (win) {

                        money = 20;//恢复初始状态
                        win = false;
                    }


                }
                //System.out.println(start);
                sum += start;
            }
            System.out.println("---------------------------");
            System.out.println(sum);
            ss += sum;
        }
        System.out.println();
        System.out.println(ko);
        System.out.println("平均：" + (ss / 100));
    }
}
