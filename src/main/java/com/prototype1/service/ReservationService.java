package com.prototype1.service;

import com.prototype1.reqBody.reservation.ReservationRegisterReqBody;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    public ReservationRegisterReqBody registerExe(ReservationRegisterReqBody req){
        return req;
    }
}
