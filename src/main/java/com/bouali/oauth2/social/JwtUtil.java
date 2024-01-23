package com.bouali.oauth2.social;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {
    private String secret = "secret";
    private int jwtExpirationInMs = 3600000;

    public String generateToken(String email, String name) {

        Map<String, Object> payloads = new HashMap<>();
        payloads.put("email", email);
        payloads.put("name", name);

        return Jwts.builder()
                .setSubject(name)
                .setClaims(payloads)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationInMs))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
}
