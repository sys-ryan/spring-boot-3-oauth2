package com.bouali.oauth2.social;

import com.bouali.oauth2.social.dto.AuthResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

public class MyCustomSuccessHandler implements AuthenticationSuccessHandler {
    private ObjectMapper objectMapper = new ObjectMapper();
    private JwtUtil jwtUtil = new JwtUtil();

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

        String name = "";
        String email = "";


        switch (provider) {
            case "google":
                name = principal.getAttribute("name");
                email = principal.getAttribute("email");

                System.out.println("name: " + name);
                System.out.println("email: " + email);
                break;
        }

        // TODO: check if user already exists

        // TODO: if user does not exist, create user

        // TODO: if user exists, update user

        // TODO: create JWT token

        String jwt = jwtUtil.generateToken(principal.getAttribute("email"), principal.getAttribute("name"));

        System.out.println("jwt: " + jwt);


        // TODO: check - cloud server 에서 access token, refresh token 어떻게 내려주는지...

        AuthResponseDto authResponse = new AuthResponseDto();
        authResponse.setSuccess(true);
        authResponse.setMessage("Login Success");
        authResponse.setAccessToken(jwt);
        authResponse.setName(name);
        authResponse.setEmail(email);

        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(authResponse));
//        response.
//        response.sendRedirect("http://localhost:3000/login/success" + "?name=" + principal.getAttribute("name") + "&email=" + principal.getAttribute("email") + "&provider=" + provider + "&time=" + new Date().toString());




    }



}
