package dao;

import pojo.User;

/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 19:12 2017/11/9
 * @Modified By:
 */
public interface UserDAO {

    public User findUserById(int id) throws Exception;
}
