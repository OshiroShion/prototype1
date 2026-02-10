package com.prototype1.restController;

import com.prototype1.reqBody.reservation.ReservationRegisterReqBody;
import com.prototype1.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReservationRestController {
    @Autowired
    ReservationService reservationService;

    @PostMapping("/reservationRegister")
    @ResponseBody
    public ReservationRegisterReqBody reservationUpdate(
            @RequestBody ReservationRegisterReqBody req){

        return reservationService.registerExe(req);
    }
}