package dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import pojo.User;

/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 19:14 2017/11/9
 * @Modified By:
 */
public class UserDAOImpl extends SqlSessionDaoSupport implements UserDAO {

    @Override
    public User findUserById(int id) throws Exception {
        //首先创建SqlSession
        SqlSession sqlSession = this.getSqlSession();

        String statement = "mapping.UserMapper.getUser";
        //根据id查询用户信息
        User user = sqlSession.selectOne(statement,id);

        return user;
    }
}
