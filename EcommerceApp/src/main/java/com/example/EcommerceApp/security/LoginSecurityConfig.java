package com.example.EcommerceApp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Controller;

@Configuration
@EnableWebSecurity
public class LoginSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests(auth ->
                        auth
                                .requestMatchers("/","/login").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(
                        form->
                                form
                                        .loginPage("/login")
                                        .loginProcessingUrl("/doLogin")
                                        .defaultSuccessUrl("/dashboard")
                                        .failureForwardUrl("/login?error=true")
                                        .permitAll()
                );
        return http.build();
    }
}
