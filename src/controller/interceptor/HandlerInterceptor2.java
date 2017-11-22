package controller.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 10:46 2017/11/22
 * @Modified By:
 */
public class HandlerInterceptor2 implements HandlerInterceptor {
    //在执行handler之前来执行
    //用于用户认证校验、用户权限校验
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        System.out.println("HandlerInterceptor2...preHandle");
        return false;
    }

    //在执行handler但是返回modelAndView之前来执行
    //如果需要向页面提供一些共用的数据或配置一些视图信息，使用此方法实现从modelAndView入手
    @Override
    public void postHandle(HttpServletRequest request,HttpServletResponse response,Object handler,ModelAndView modelAndView) throws Exception{
        System.out.println("HandlerInterceptor2...postHandler");
    }

    //在执行handler之后执行方法
    //做系统统一异常处理，进行方法执行性能监控，在prehandler中设置一个时间点，在afterCompletion中再设置一个时间点，两个时间点之差就是执行时长
    //实现系统统一日志记录
    @Override
    public void afterCompletion(HttpServletRequest request,HttpServletResponse response,Object handler,Exception ex) throws Exception{
        System.out.println("HandlerInterceptor2...afterCompletion");
    }
}
