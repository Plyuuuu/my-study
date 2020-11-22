package github.veikkoroc.designpartten.structuraltype.proxy.jdk;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/21 14:30
 */
public class UserServiceImpl implements UserService {
    @Override
    public String getUser(int i) {
        System.out.println("获取用户...");
        return ""+i;
    }
}
