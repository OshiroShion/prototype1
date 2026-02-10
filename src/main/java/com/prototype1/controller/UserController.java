package com.prototype1.controller;

import com.prototype1.common.SecuritySession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class UserController {
    @Autowired
    SecuritySession securitySession;

    @GetMapping("/toUserSearch")
    public String toUserSearch(Model model){
        model.addAttribute("username", securitySession.getUsername());
        return "userSearch";
    }

    @GetMapping("/toUserRegister")
    public String toUserRegister(Model model){
        model.addAttribute("username", securitySession.getUsername());
        return "userRegister";
    }

    @GetMapping("/toUserUpdate")
    public String toUserUpdate(Model model){
        model.addAttribute("username", securitySession.getUsername());
        return "userUpdate";
    }
}
