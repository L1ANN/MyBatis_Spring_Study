package mapping;

import pojo.User;
import pojo.UserQueryVo;

import java.util.List;

/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 18:37 2017/11/9
 * @Modified By:
 */
public interface UserMapper {
    public User getUser(int id) throws Exception;

    public List<User> findUserList(User user) throws Exception;

    public List<User> findUserList1(UserQueryVo userQueryVo) throws Exception;
}
