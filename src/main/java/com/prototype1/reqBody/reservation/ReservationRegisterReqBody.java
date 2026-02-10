package com.prototype1.reqBody.reservation;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ReservationRegisterReqBody {
    private List<roomRow> roomList;
    private String guestName;
    private String guestPhone;
    private String guestEmail;
    private int adultCount;
    private int childCount;
    private Date checkInDate;
    private Date checkOutDate;
}