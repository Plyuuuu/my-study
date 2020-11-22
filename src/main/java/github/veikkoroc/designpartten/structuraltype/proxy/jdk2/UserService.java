package github.veikkoroc.designpartten.structuraltype.proxy.jdk2;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/21 12:29
 */
public interface UserService {
    /**
     * 查询用户通过id
     * @param id
     * @return
     */
    String findUserById(int id);
}
