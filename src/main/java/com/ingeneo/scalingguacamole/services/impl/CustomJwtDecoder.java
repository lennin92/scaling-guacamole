package com.ingeneo.scalingguacamole.services.impl;

import com.ingeneo.scalingguacamole.utils.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.stereotype.Component;

@Component
public class CustomJwtDecoder implements JwtDecoder {
    private final JwtTokenUtil tokenUtil;

    @Autowired
    public CustomJwtDecoder(JwtTokenUtil tokenUtil) {
        this.tokenUtil = tokenUtil;
    }

    @Override
    public Jwt decode(String token) throws JwtException {
        Claims claims = tokenUtil.decodeJWT(token);
        Jwt.Builder builder = Jwt.withTokenValue(token);
        for(String key: claims.keySet()){
            builder.claim(key, claims.get(key));
        }
        return builder.build();
    }
}
