package github.veikkoroc.designpartten.behavioraltype.Observer.Subject;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/9 10:36
 */
public class SubjectImpl extends Subject {
    @Override
    public void observerNotify() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update(i);
        }
    }
}
