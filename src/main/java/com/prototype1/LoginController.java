package com.prototype1;

import com.prototype1.common.SecuritySession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class LoginController {
    @Autowired
    SecuritySession securitySession;

    @GetMapping("/")
    public String login(){
        return "login";
    }

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("username", securitySession.getUsername());
        return "index";
    }
}
