package github.veikkoroc.JavaSE.Stream;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2021/3/23 14:27
 */
public class Demo01 {
    public static void main(String[] args) {

        List<Person> list = new ArrayList<>();
        List<Person> list2 = new LinkedList<>();

        Person tom = new Person("1", "tom");
        Person jack = new Person("2", "jack");
        Person mary = new Person("3", "mary");

        list.add(tom);
        list.add(jack);
        list.add(mary);

        list2.add(tom);
        list2.add(jack);
        list2.add(mary);

        List<Person> collect = list.stream().filter(x -> x.getNo() != "2").collect(Collectors.toList());
        List<Person> collect2 = list2.stream().filter(x -> x.getNo() != "1").collect(Collectors.toList());

        // [Person(no=1, name=tom), Person(no=3, name=mary)]
        System.out.println(collect);
        // [Person(no=2, name=jack), Person(no=3, name=mary)]
        System.out.println(collect2);

    }
}
