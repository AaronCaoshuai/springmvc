package com.aaron.controller;

import com.aaron.doamin.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class RestDemoController {

    @RequestMapping(value = "/{id}/{name}",method = RequestMethod.GET)
    public String demo1(@PathVariable("id") Integer id,@PathVariable("name")String name){
        System.out.println("param id :"+id+",name:"+name);
        return "get success";
    }

    /**
     * 这里只做模拟,post需要从请求体中获取数据,insert 操作
     * @param user
     * @return
     */
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String demo2(User user){
        System.out.println("param :" + user);
        return "post success";
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public String demo3(@PathVariable("id") Integer id,User user){
        System.out.println("param id :"+id + "user:"+user);
        return "put success";
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String demo4(@PathVariable("id") Integer id){
        System.out.println("param id :"+id);
        return "delete success";
    }
}
