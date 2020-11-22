package github.veikkoroc.designpartten.behavioraltype.Observer.Observer;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/9 10:34
 */
public class ObserveImpl implements Observer {

    @Override
    public void update(int i) {
        System.out.println(i+"收到通知~~");
    }
}
