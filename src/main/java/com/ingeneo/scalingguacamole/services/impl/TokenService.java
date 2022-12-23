package com.ingeneo.scalingguacamole.services.impl;

import com.ingeneo.scalingguacamole.services.ITokenService;
import com.ingeneo.scalingguacamole.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class TokenService implements ITokenService {

    private final JwtTokenUtil tokenUtil;

    @Autowired
    public TokenService(JwtTokenUtil tokenUtil) {
        this.tokenUtil = tokenUtil;
    }

    public String generateToken(Authentication authentication) {
        return tokenUtil.createJWT(authentication);
    }
}
