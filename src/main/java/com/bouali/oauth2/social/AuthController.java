package com.bouali.oauth2.social;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @GetMapping("/auth/google")
    public String authGoogle() {
        return "auth/google";
    }

    @GetMapping("/login/oauth2/code/google")
    public String loginGoogle() {
        return "login/oauth2/code/google";
    }

}
