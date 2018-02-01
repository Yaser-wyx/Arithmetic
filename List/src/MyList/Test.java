package MyList;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-23
 * @Time: 17:38
 * To change this template use File | Settings | File Templates.
 * @desc
 */
public class Test {
    public static void main(String[] args) {
        SkipList<Integer, String> SkipList = new SkipList<>();
        //SkipList.erase(0);
        for (int i = 0; i < 100; i++) {
            SkipList.insert(RandomUtils.nextInt(1, 100), RandomStringUtils.random(10, "asdasdasfagfashiughijmicmubvwyrg"));
            //System.out.println(i);
        }
        //System.out.println("end");
        SkipList.show();
        System.out.println("====================================================================================");
        int num = RandomUtils.nextInt(1, 100);
        System.out.println(num);
        if (SkipList.find(num) != null) {
            System.out.println(SkipList.find(num));
            SkipList.erase(num);
        }
        System.out.println("====================================================================================");

        SkipList.show();
    }
}
