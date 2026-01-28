package com.prototype1.repository;

import com.prototype1.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    List<UserInfo> findByUserid(String userid);
    List<UserInfo> findByUsername(String username);
    @Transactional
    List<UserInfo> deleteByUsername(String username);
}
