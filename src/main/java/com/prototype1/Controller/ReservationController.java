package com.prototype1.Controller;

import com.prototype1.common.SecuritySession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class ReservationController {
    @Autowired
    SecuritySession securitySession;

    @GetMapping("/toReservationSearch")
    public String toReservationSearch(Model model){
        model.addAttribute("username", securitySession.getUsername());
        return "reservationSearch";
    }

    @GetMapping("/toVacancySearch")
    public String toVacancySearch(Model model){
        model.addAttribute("username", securitySession.getUsername());
        return "vacancySearch";
    }

    @GetMapping("/toReservationRegister")
    public String toReservationRegister(Model model){
        model.addAttribute("username", securitySession.getUsername());
        return "reservationRegister.js";
    }

    @GetMapping("/toReservationUpdate")
    public String toReservationUpdate(Model model){
        model.addAttribute("username", securitySession.getUsername());
        return "reservationUpdate";
    }
}
