package com.easyblog.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig  {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(auth -> auth
                        .requestMatchers("*/*").permitAll()
                        .anyRequest().authenticated())
                .httpBasic(withDefaults())
                .formLogin(withDefaults())
                .csrf(csrf -> csrf.disable());
        return http.build();
    }
}
