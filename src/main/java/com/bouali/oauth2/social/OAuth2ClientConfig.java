package com.bouali.oauth2.social;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration(proxyBeanMethods = false)
@Configuration
public class OAuth2ClientConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizationRequests ->
                        authorizationRequests
                                .requestMatchers("/oauth2/authorization/google").authenticated() // OAuth2 인증이 필요한 특정 경로
                                .anyRequest().permitAll()) // 다른 모든 요청은 일단 허용
                .oauth2Login(oauth2Login -> oauth2Login.successHandler(new MyCustomSuccessHandler())); // OAuth2 인증 성공 핸들러
        //     .addFilterBefore(new JwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class); // JWT 인증 필터 추가


        return http.build();

    }



}
