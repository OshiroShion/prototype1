package com.prototype1.common;

import com.prototype1.entity.UserInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {
    //private final User user;
    private final Collection<GrantedAuthority> authorities;
    private final UserInfo userInfo;

    public CustomUserDetails(UserInfo userInfo) {
        this.userInfo = userInfo;
        this.authorities = Collections.singletonList(new SimpleGrantedAuthority(userInfo.getRole()));
    }

    // ユーザーに付与された権限を返す
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getUsername() {
        return userInfo.getUserName();
    }

    // ユーザーパスワードを返す
    @Override
    public String getPassword() {
        return userInfo.getPassword();
    }

    // アカウントが期限切れでないかを示す
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // アカウントがロックされていないかを示す
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 資格情報が期限切れでないかを示す
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // アカウントが有効かを示す
    @Override
    public boolean isEnabled() {
        return true;
    }
}
