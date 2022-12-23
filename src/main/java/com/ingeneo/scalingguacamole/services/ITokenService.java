package com.ingeneo.scalingguacamole.services;

import org.springframework.security.core.Authentication;

public interface ITokenService {
    String generateToken(Authentication authentication);
}
