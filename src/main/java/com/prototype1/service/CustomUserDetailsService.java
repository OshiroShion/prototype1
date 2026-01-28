package com.prototype1.service;

import com.prototype1.common.CustomUserDetails;
import com.prototype1.entity.UserInfo;
import com.prototype1.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserInfoRepository userInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
        List<UserInfo> UserInfoL = userInfoRepository.findByUserid(userid);
        if(UserInfoL.isEmpty()){
            throw new UsernameNotFoundException("User not found for username : " + userid);
        }
        return new CustomUserDetails(UserInfoL.getFirst());
    }
}