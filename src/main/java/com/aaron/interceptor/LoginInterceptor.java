package com.aaron.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * Handler执行前调用,应用场景:登录认证,身份授权
     * 返回值是true放行,返回时false不放行
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String requestURI = httpServletRequest.getRequestURI();
        //无须登录就可以访问放行
        if((requestURI.indexOf("login")) > -1){
            return true;
        }
        //用户存在session中放行
        String username = (String) httpServletRequest.getSession().getAttribute("username");
        if(username != null && username.length()>0){
            return true;
        }
        httpServletResponse.sendRedirect("/user/loginPage");
        return false;
    }

    /**
     * 进入Handler开始执行,并且在返回ModelAndView之前调用
     * 应用场景:对ModelAndView对象操作,可以把公共模型数据传到前台,可以统一指定视图
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 执行完Handler之后调用
     * 应用场景:统一异常处理,统一日志处理
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
