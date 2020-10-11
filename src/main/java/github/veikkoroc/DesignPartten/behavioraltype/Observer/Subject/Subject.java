package github.veikkoroc.DesignPartten.behavioraltype.Observer.Subject;

import github.veikkoroc.DesignPartten.behavioraltype.Observer.Observer.Observer;


import java.util.LinkedList;
import java.util.List;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/9 10:26
 */
public abstract class Subject {

    /**
     *  定义一个观察者的集合，存放所有观察者
     */
    protected List<Observer> observers = new LinkedList<>();

    /**
     * 添加观察者
     * @param observer
     */
    public void attach(Observer observer){
        observers.add(observer);

    }

    /**
     * 注销观察者
     * @param observer
     */
    public void detach(Observer observer){
        observers.remove(observer);
    }

    /**
     * 通知所有观察者
     */
    public abstract void observerNotify();

}
