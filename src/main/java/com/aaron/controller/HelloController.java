package com.aaron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloController {


    @ResponseBody
    @RequestMapping("/springmvc")
    public String hello(){
        return "hello springmvc";
    }


    @RequestMapping("/jsp")
    public String hellojsp(){
        return "hello";
    }
}
