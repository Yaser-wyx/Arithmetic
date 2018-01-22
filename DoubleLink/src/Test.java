import org.apache.commons.lang3.RandomUtils;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-22
 * @Time: 23:09
 * To change this template use File | Settings | File Templates.
 * @desc
 */
public class Test {
    public static void main(String[] args) {
        DoubleList<Integer> doubleList = new DoubleList<>();
        for (int i = 0; i < 100; i++) {
            doubleList.appendLast(RandomUtils.nextInt());
        }
        for (int i = 0; i < 100; i++) {
            System.out.println(i + " : " + doubleList.getFirst());
            doubleList.delFirst();
        }
    }
}
