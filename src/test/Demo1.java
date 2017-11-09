package test;

import dao.UserDAO;
import mapping.UserMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.User;

/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 19:22 2017/11/9
 * @Modified By:
 */
public class Demo1 {

    private ApplicationContext applicationContext;

    @Before
    public void setUp()throws Exception{
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    //从spring容器中获取UserDao的这个bean
    @Test
    public void testFindUserById() throws Exception{
        UserDAO userDAO = (UserDAO)applicationContext.getBean("userDao");
        User user = userDAO.findUserById(1);

        System.out.println(user);
    }

    //整合mapper代理方法
    //①使用MapperFactoryBean
    @Test
    public void testFindUserById_mapper1() throws Exception{
        UserMapper userMapper = (UserMapper)applicationContext.getBean("userMapper");
        User user = userMapper.getUser(1);
        System.out.println(user);
    }

    //②使用MapperScannerConfigure
    @Test
    public void testFindUserById_mapper2() throws Exception{
        UserMapper userMapper = (UserMapper)applicationContext.getBean("userMapper");
        User user = userMapper.getUser(1);
        System.out.println(user);
    }
}
