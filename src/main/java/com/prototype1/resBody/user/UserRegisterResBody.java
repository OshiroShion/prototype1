package com.prototype1.resBody.user;

import com.prototype1.reqBody.user.UserRegisterReqBody;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterResBody {
    public UserRegisterResBody(UserRegisterReqBody req){
        this.userName = req.getUserName();
        this.password = req.getPassword();
        this.position = req.getPosition();
        this.role = req.getRole();
    }
    private int userId;
    private String userName;
    private String password;
    private String position;
    private String role;
}
