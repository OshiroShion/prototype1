package com.prototype1.reqBody.user;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterReqBody {
    private String userName;
    private String password;
    private String position;
    private String role;
}
