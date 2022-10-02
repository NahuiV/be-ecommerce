package com.be.ecommerce.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        /**return http
                .authorizeHttpRequests().anyRequest().permitAll()
                .and().cors().
                .httpBasic().disable().formLogin().disable().build();
        **/
        http.cors().and().
        return null;
    }
}
