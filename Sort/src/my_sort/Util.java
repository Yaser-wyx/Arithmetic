package my_sort;

import org.apache.commons.lang3.RandomUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2017-12-22
 * @Time: 21:11
 * To change this template use File | Settings | File Templates.
 * @desc 测试排序的性能，是否正确等的工具类
 */
public class Util {
    private Integer[] nums;//生成的随机数，用于排序的
    private Map<String, Long> times = new HashMap<>();
    private int count;
    private Sort[] sort;
    private Map<String, Integer[]> result = new HashMap<>();//名字对应于一列排好序的数

    Util(Sort[] sorts, int min, int max, int count) {

        this.sort = sorts;
        Create_num1(min, max, count);
        for (Sort s : sort) {
            result.put(s.getName(), Get_nums());
        }

    }

    Util(Sort[] sorts, int num, int count) {

        this.sort = sorts;
        Create_num2(num, count);
        for (Sort s : sort) {
            result.put(s.getName(), Get_nums());
        }

    }

    private void Create_num1(int min, int max, int count) {
        this.count = count;
        nums = new Integer[count];
        for (int i = 0; i < count; i++) {
            nums[i] = RandomUtils.nextInt(min, max);
        }
    }

    private void Create_num2(int num, int count) {
        this.count = count;
        nums = new Integer[count];
        for (int i = 0; i < count; i++) {
            nums[i] = i;
        }
        for (int i = 0; i < num; i++) {
            int index = RandomUtils.nextInt(0, count - 1);
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
        }


    }


    private Integer[] Get_nums() {
        Integer[] num = new Integer[count];
        System.arraycopy(nums, 0, num, 0, count);
        return num;
    }

    public void print(String name) {
        for (int i : result.get(name)) {
            System.out.println(i);
        }
    }

    private boolean Judge(Integer[] number) {
        for (int i = 1; i < count; i++) {
            if (number[i] < number[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public void Start() {
        for (Sort s : sort) {
            long time = System.currentTimeMillis();
            s.Sort(result.get(s.getName()));
            times.put(s.getName(), System.currentTimeMillis() - time);
        }
        for (Sort s : sort) {
            if (!Judge(result.get(s.getName()))) {
                System.out.println(s.getName() + "排序有误！");
            } else {
                System.out.println(s.getName() + "排序" + count + "个数用时：" + times.get(s.getName()));
            }

        }
    }

}
