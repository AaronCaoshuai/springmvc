package com.aaron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LoginController {

    @RequestMapping("/loginSuccess")
    public String loginSuccess(){
        return "loginSuccess";
    }

    @RequestMapping("/loginPage")
    public String loginJsp(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(HttpSession session,String username,String password){
        session.setAttribute(username,username);
        return "redirect:/user/loginSuccess";
    }

    @RequestMapping("/loginOut")
    public String loginOut(HttpSession session){
        session.invalidate();
        return "redirect:/user/loginPage";
    }

}
