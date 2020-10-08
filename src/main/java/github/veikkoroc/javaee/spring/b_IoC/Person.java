package github.veikkoroc.javaee.spring.b_IoC;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/25 12:38
 */
public class Person {
    private String name;
    private int age;
    /**
     * 这个人出版的书
     */
    private Book book;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, Book book) {
        this.name = name;
        this.age = age;
        this.book = book;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
