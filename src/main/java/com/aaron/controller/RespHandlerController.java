package com.aaron.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * springmvc中对于不使用注解方式的返回值的几种处理方式
 * 1.使用ModelAndView对象
 * 2.返回值为String
 * 3.返回值为void
 */

@Controller
@RequestMapping("/respHandler")
public class RespHandlerController {
    /**
     * 使用ModelAndView 对象
     * 指定视图名称和数据模型
     * @return
     */
    @RequestMapping("/modelAndView")
    public ModelAndView modelAndView(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("modelAndView");
        mav.addObject("modelAndView","modelAndView");
        return mav;
    }

    /**
     * 请求转发
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/requestForward")
    public void respHandlerVoid1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/respHandler/modelAndView").forward(request,response);
    }

    /**
     * 请求重定向
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/responseRedirect")
    public void respHandlerVoid2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/respHandler/modelAndView");
    }

    /**
     * 相应json格式数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/responseJson")
    public void respHandlerVoid3(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String result = "{'张三':'23','Aaron':'26','json':'utf-8'}";
        //设置响应编码 utf-8
//        response.setCharacterEncoding("utf-8");
        //设置响应格式 json
        response.setContentType("application/json;charset=utf-8");
        //流对象进行写出
        response.getWriter().write(result);
    }

    /**
     * 使用String方式返回逻辑视图
     * @return
     */
    @RequestMapping("/respString")
    public String respHandlerString1(){
        return "modelAndView";
    }

    /**
     * 使用String方式进行请求转发
     * @return
     */
    @RequestMapping("/respStringForward")
    public String respHandlerString2(){
        return "forward:/respHandler/modelAndView";
    }

    /**
     * 使用String方式进行请求重定向
     * @return
     */
    @RequestMapping("/respStringRedirect")
    public String respHandlerString3(){
        return "redirect:/respHandler/modelAndView";
    }

}
