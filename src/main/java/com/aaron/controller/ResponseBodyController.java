package com.aaron.controller;

import com.aaron.doamin.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用注解方式处理返回值 @ResponseBody
 */
@Controller
@RequestMapping("/responseBody")
//@RestController 也可以直接使用 @RestController注解来制定每个方法都是用@ResponseBody注解进行返回
public class ResponseBodyController {

    /**
     * 返回POJO类即java对象
     * @return
     */
    @RequestMapping("/pojo")
    @ResponseBody
    public User retPojo(){
        return new User("Aaron","123456","26");
    }

    /**
     * 返回POJO类即java对象
     * @return
     */
    @RequestMapping("/listPojo")
    @ResponseBody
    public List<User> retListPojo(){
        ArrayList<User> list = new ArrayList();
        User user1 = new User("Aaron","123456","26");
        User user2 = new User("张三","123456","26");
        list.add(user1);
        list.add(user2);
        return list;
    }

    /**
     * 返回字符串
     * @return
     * 使用produces 指定响应类型和编码
     */
    @RequestMapping(value = "/string",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String retString(){
        return "综合查询String";
    }

}
