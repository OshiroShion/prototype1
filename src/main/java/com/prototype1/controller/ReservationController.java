package com.prototype1.controller;

import com.prototype1.common.SecuritySession;
import com.prototype1.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("")
public class ReservationController {
    @Autowired
    SecuritySession securitySession;
    @Autowired
    ReservationService reservationService;

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
        return "reservationRegister";
    }

    @GetMapping("/toReservationUpdate")
    public String toReservationUpdate(Model model){
        model.addAttribute("username", securitySession.getUsername());
        return "reservationUpdate";
    }
}
