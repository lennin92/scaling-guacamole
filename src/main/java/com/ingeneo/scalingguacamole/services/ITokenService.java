package com.ingeneo.scalingguacamole.services;

import org.springframework.security.core.Authentication;

public interface ITokenService {
    public String generateToken(Authentication authentication);
}
