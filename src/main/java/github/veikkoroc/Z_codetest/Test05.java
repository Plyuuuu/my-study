package github.veikkoroc.Z_codetest;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/22 11:28
 */
public class Test05 {
    public static void main(String[] args) {

    }
}
class Person{
    String name = "No name";
    public Person(String nm){
        name = nm;
    }
    public Person(){}
}
class Employee extends Person{

    String empId = "000";

    public Employee(String nm) {
        empId = nm;
    }
}