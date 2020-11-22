package github.veikkoroc.designpartten.structuraltype.proxy.jdk2;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/21 12:32
 */
public class UserServiceImpl implements UserService {
    @Override
    public String findUserById(int id) {
        System.out.println("UserServiceImpl被调用啦~ id = "+id);
        return "迪丽热巴~";
    }
}
