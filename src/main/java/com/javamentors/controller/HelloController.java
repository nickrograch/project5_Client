package com.javamentors.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        model.addAttribute("user", session.getAttribute("user"));
        return "hello";
    }
}
