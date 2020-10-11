package github.veikkoroc.DesignPartten.behavioraltype.Observer;

import github.veikkoroc.DesignPartten.behavioraltype.Observer.Observer.ObserveImpl;
import github.veikkoroc.DesignPartten.behavioraltype.Observer.Subject.SubjectImpl;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/9 10:39
 */
public class Client {
    public static void main(String[] args) {
        SubjectImpl subject = new SubjectImpl();
        subject.attach(new ObserveImpl());
        subject.attach(new ObserveImpl());
        subject.attach(new ObserveImpl());
        subject.attach(new ObserveImpl());
        subject.observerNotify();
    }
}
