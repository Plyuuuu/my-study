package github.veikkoroc.JavaSE.Stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 *  https://blog.csdn.net/mu_wind/article/details/109516995
 * Stream可以通过集合数组创建。
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2021/3/23 14:12
 */
public class CreatStream {

    public static void main(String[] args) {

        // Map<String,String> map = new HashMap<>();
        // map创建Stream 报错
        // map.stream

        // 创建一个集合
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        // 创建一个流
        Stream<String> stream = list.stream();

        // 筛选
        stream.filter(x ->x == "2").forEach(System.out::println);


    }

}
