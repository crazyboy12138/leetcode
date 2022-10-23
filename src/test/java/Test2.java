import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

import java.net.URLEncoder;
import java.util.*;

/**
 * TODO
 *
 * @author lintingmin
 * @date 2020-01-09
 */
public class Test2 {
    @Test
    public void test1() {
        System.out.println(9 & 1);
    }

    @Test
    public void test2() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(2);
        set.add(1);
        set.add(3);
        set.add(20);
        set.add(10);
        set.add(30);
        System.out.println(set);
        set.remove(20);
        System.out.println(set);
    }

//    @Test
    public void test3() {
        long times = 10000000000L;
        int sum = 0;

        long begin = System.currentTimeMillis();
        // 调用方法
        for(long i = 0; i < times; i++) {
            sum += getNum();
        }
        System.out.println("调用方法耗时: " + (System.currentTimeMillis() - begin));

        sum = 0;
        begin = System.currentTimeMillis();
        // 不调用方法
        for(long i = 0; i < times; i++) {
            sum += 1;
        }
        System.out.println("不调用方法耗时: " + (System.currentTimeMillis() - begin));

        System.out.println();

    }

    private int getNum() {
        return 1;
    }

    @Test
    public void test4() {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            list.add(i);
        }
        for (int i = 0; i < list.size(); i++) {
            if (i == 2) {
                list.remove(i);
            }
            System.out.print(list.get(i) + " ");
        }

    }

    @Test
    public void test5() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("ele1", "小樱");
        map.put("ele2", "若曦");
        map.put("ele3", "晴川");
        Set<String> set = map.keySet();
        System.out.println(set);


        List<String> lis = new ArrayList<>();
        lis.add("name");
        lis.addAll(set);
        System.out.println(lis);

    }


}
