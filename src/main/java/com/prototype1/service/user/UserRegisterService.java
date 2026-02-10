package com.prototype1.service.user;

import com.prototype1.entity.UserInfo;
import com.prototype1.repository.UserInfoRepository;
import com.prototype1.reqBody.user.UserRegisterReqBody;
import com.prototype1.resBody.user.UserRegisterResBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Service for registering user
 */
@Service
public class UserRegisterService {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserInfoRepository userInfoRepository;

    /**
     * Register new user
     * @param req UserRegisterReqBody HTTP request
     * @return res UserRegisterResBody  HTTP response
     */
    public UserRegisterResBody exe(UserRegisterReqBody req){
        //form new userInfo record
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(req.getUserName());
        userInfo.setPassword(passwordEncoder.encode(req.getPassword()));
        userInfo.setPosition(req.getPosition());
        userInfo.setRole(req.getRole());

        //insert record
        userInfoRepository.save(userInfo);

        //form response
        UserRegisterResBody res = new UserRegisterResBody(req);
        res.setUserId(userInfo.getUserId());

        return res;
    }
}
