package com.prototype1.restController;

import com.prototype1.reqBody.user.UserRegisterReqBody;
import com.prototype1.resBody.user.UserRegisterResBody;
import com.prototype1.service.user.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {
    @Autowired
    UserRegisterService userRegisterService;

    @PostMapping("/userRegister")
    @ResponseBody
    public UserRegisterResBody userRegister(
            @RequestBody UserRegisterReqBody req){

            return userRegisterService.exe(req);
    }

}
