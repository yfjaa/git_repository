package com.baidu.controller;

import com.baidu.pojo.User;
import com.baidu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }
    @RequestMapping("/login")
    public String Login(User user, Model model, HttpServletResponse response,String auto){
        User login = userService.Login(user);
        model.addAttribute("user",login);
        if(login!=null){
            if(auto.equals("on")){
                Cookie cookie1=new Cookie("username",user.getUserName());
                cookie1.setMaxAge(7*24*3600);
                response.addCookie(cookie1);
                Cookie cookie2=new Cookie("password",user.getPassword());
                cookie2.setMaxAge(7*24*3600);
                response.addCookie(cookie2);
                Cookie cookie3=new Cookie("auto","on");
                cookie3.setMaxAge(7*24*3600);
                response.addCookie(cookie3);
            }else{
                Cookie cookie1=new Cookie("username",null);
                response.addCookie(cookie1);
                Cookie cookie2=new Cookie("password",null);
                response.addCookie(cookie2);
                Cookie cookie3=new Cookie("auto",null);
                response.addCookie(cookie3);
            }
        return "main";
        }
        return "redirect:toLogin";
    }
}
