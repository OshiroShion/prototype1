package com.prototype1.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // パスワードの暗号化
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                // ログインページの許可設定
                .formLogin(login -> login // フォーム認証を使う
                        .loginPage("/") // ログインページの設定
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/index", true)
                        .usernameParameter("userid")
                        .passwordParameter("password")
                        .permitAll())
                .logout(logout -> logout
                        .logoutSuccessUrl("/")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID"))

                // リクエストの許可設定
                .authorizeHttpRequests(authz -> authz
                        // index.html の参照権限
                        .requestMatchers("/")
                        .permitAll()
                        // index.html の参照権限
                        .requestMatchers("/index")
                        .hasAnyRole("USER","ADMIN")

                );

        return http.build();
    }

}
