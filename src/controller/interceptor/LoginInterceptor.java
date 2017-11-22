package controller.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 11:32 2017/11/22
 * @Modified By:
 */
public class LoginInterceptor implements HandlerInterceptor {
    //在执行handler之前来执行
    //1.用于用户认证校验2.用户权限校验
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{

        String url = request.getRequestURL().toString();

        //判断是否是公开地址
        //实际开发中需要将公开地址配置在配置文件中
        if(url.indexOf("login.action")>=0){
            //如果是公开地址则放行
            return true;
        }

        //判断用户身份在session中是否存在
        HttpSession session = request.getSession();
        String usercode = (String) session.getAttribute("usercode");

        //如果用户身份在session中存在则放行
        if(usercode!=null&&usercode!=""){
            return true;
        }

        //执行到这里就拦截，跳转到登录页面，用户进行登录
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        return false;
    }

    //在执行handler但是返回ModelAndView之前来执行
    //1.向页面提供一些公用的数据或配置一些视图信息，使用此方法实现从modelandview入手
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,Object handler,ModelAndView modelAndView) throws Exception{
        System.out.println("HandlerInterceptor1...postHandler");
    }

    //执行handler之后执行此方法
    //1.做系统统一异常处理2.进行方法执行性能监控，在prehandler中设置一个时间点，在afterCompletion设置一个时间点，两个时间点之差就是执行时长
    //3.实现系统统一日志记录
    @Override
    public void afterCompletion(HttpServletRequest request,HttpServletResponse response,Object handler,Exception ex) throws Exception{
        System.out.println("HandlerInterceptor1...afterCompletion");
    }
}
