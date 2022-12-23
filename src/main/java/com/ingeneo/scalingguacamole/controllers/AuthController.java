package com.ingeneo.scalingguacamole.controllers;

import com.ingeneo.scalingguacamole.dtos.security.LoginResponseDto;
import com.ingeneo.scalingguacamole.services.ITokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final ITokenService tokenService;

    @Autowired
    public AuthController(@Autowired ITokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public LoginResponseDto loginUser(Authentication authentication) {
        String token = this.tokenService.generateToken(authentication);
        return LoginResponseDto.builder().token(token).build();
    }
}
