package github.veikkoroc.designpartten.structuraltype.proxy.jdk.impl;

import github.veikkoroc.designpartten.structuraltype.proxy.jdk.api.UserDao;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/9 0:20
 */
public class UserDaoImpl implements UserDao {
    @Override
    public Boolean findUserById(String userId) {
        String id = "迪丽热巴";
        if (id.equals(userId)){
            System.out.println("查询用户："+userId+" 成功!");
            return true;
        }
        return false;
    }

    @Override
    public Boolean findUserById(int userId) {
        System.out.println("userId:"+userId);
        return true;
    }
}
