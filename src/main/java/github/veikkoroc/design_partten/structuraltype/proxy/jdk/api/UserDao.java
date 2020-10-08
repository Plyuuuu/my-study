package github.veikkoroc.design_partten.structuraltype.proxy.jdk.api;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/9 0:18
 */
public interface UserDao {
    /**
     * 通过id查询用户
     * @param userId
     * @return
     */
    Boolean findUserById(String userId);
}
