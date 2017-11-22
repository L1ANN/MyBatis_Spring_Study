package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 11:22 2017/11/22
 * @Modified By:
 */
@Controller
public class LoginController {

    //用户登录提交方法
    @RequestMapping("/login")
    public String login(HttpSession session, String usercode, String password) throws Exception{
        //调用service校验用户账号和密码的正确性
        //这个东西我们讲shiro的时候再写

        //如果service校验通过，将用户身份记录到session
        session.setAttribute("usercode",usercode);
        //重定向到商品查询页面
        return "redirect:/items/queryItems.action";
    }

    //用户登录注销方法
    @RequestMapping("/logout")
    public String logout(HttpSession session) throws Exception{
        //session失效
        session.invalidate();
        //重定向到商品查询页面
        return "redirect:/items/queryItems.action";
    }
}
