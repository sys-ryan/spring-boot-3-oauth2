package com.bouali.oauth2.social;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import java.util.Date;

public class MyCustomSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {


//        System.out.println("name: " + authentication.getName());
//        System.out.println("credentials: " + authentication.getCredentials());
//        System.out.println("detail: " + authentication.getDetails());
//        System.out.println("principal: " + authentication.getPrincipal());
//        System.out.println("authorities: " + authentication.getAuthorities());

        OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;
        OAuth2User principal = oauthToken.getPrincipal();

        String provider = oauthToken.getAuthorizedClientRegistrationId();

        switch (provider) {
            case "google":
                String name = principal.getAttribute("name");
                String email = principal.getAttribute("email");

                System.out.println("name: " + name);
                System.out.println("email: " + email);
                break;
        }

        // TODO: check if user already exists

        // TODO: if user does not exist, create user

        // TODO: if user exists, update user



        response.sendRedirect("http://localhost:3000/login/success" + "?name=" + principal.getAttribute("name") + new Date().toString() + "&email=" + principal.getAttribute("email") + "&provider=" + provider);




    }



}
