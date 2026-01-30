package com.prototype1.Controller;

import com.prototype1.common.SecuritySession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class RoomController {
    @Autowired
    SecuritySession securitySession;

    @GetMapping("/toRoomSearch")
    public String toRoomSearch(Model model){
        model.addAttribute("username", securitySession.getUsername());
        return "RoomSearch";
    }

    @GetMapping("/toRoomRegister")
    public String toRoomRegister(Model model){
        model.addAttribute("username", securitySession.getUsername());
        return "RoomRegister";
    }

    @GetMapping("/toRoomUpdate")
    public String toRoomUpdate(Model model){
        model.addAttribute("username", securitySession.getUsername());
        return "RoomUpdate";
    }

    @GetMapping("/toRoomTypeSearch")
    public String toRoomTypeSearch(Model model){
        model.addAttribute("username", securitySession.getUsername());
        return "RoomTypeSearch";
    }

    @GetMapping("/toRoomTypeRegister")
    public String toRoomTypeRegister(Model model){
        model.addAttribute("username", securitySession.getUsername());
        return "RoomTypeRegister";
    }

    @GetMapping("/toRoomTypeUpdate")
    public String toRoomTypeUpdate(Model model){
        model.addAttribute("username", securitySession.getUsername());
        return "RoomTypeUpdate";
    }
}
