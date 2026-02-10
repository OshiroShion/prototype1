package com.prototype1.repository;

import com.prototype1.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    List<UserInfo> findByUserId(String userid);
    List<UserInfo> findByUserName(String userName);
    @Transactional
    List<UserInfo> deleteByUserName(String userName);
}
