package com.bouali.oauth2.social;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Collections;

//@Configuration(proxyBeanMethods = false)
@Configuration
public class OAuth2ClientConfig {

    // ⭐️ CORS 설정
    CorsConfigurationSource corsConfigurationSource() {
        return request -> {
            CorsConfiguration config = new CorsConfiguration();
            config.setAllowedHeaders(Collections.singletonList("*"));
            config.setAllowedMethods(Collections.singletonList("*"));
            config.setAllowedOriginPatterns(Collections.singletonList("http://localhost:3000")); // ⭐️ 허용할 origin
            config.setAllowCredentials(true);
            return config;
        };
    }



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .cors(corsConfigure -> corsConfigure.configurationSource(corsConfigurationSource()))
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizationRequests ->
                        authorizationRequests
                                .requestMatchers("/login/oauth2/code/google").permitAll()
                                .requestMatchers("/oauth2/authorization/google").authenticated() // OAuth2 인증이 필요한 특정 경로
                                .anyRequest().permitAll()) // 다른 모든 요청은 일단 허용
                .oauth2Login(oauth2Login -> oauth2Login.successHandler(new MyCustomSuccessHandler())); // OAuth2 인증 성공 핸들러
//                .addFilterBefore(new JwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class); // JWT 인증 필터 추가


        return http.build();

    }



}
