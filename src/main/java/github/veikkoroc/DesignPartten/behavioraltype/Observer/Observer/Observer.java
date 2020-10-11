package github.veikkoroc.DesignPartten.behavioraltype.Observer.Observer;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/9 10:27
 */
public interface Observer {
    /**
     * 目标实体调用的响应方法
     * @param i
     */
    public void update(int i);
}
