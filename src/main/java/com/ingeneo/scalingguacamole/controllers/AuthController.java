package com.ingeneo.scalingguacamole.controllers;

import com.ingeneo.scalingguacamole.dtos.UserDetailsImp;
import com.ingeneo.scalingguacamole.dtos.requests.LoginDto;
import com.ingeneo.scalingguacamole.dtos.responses.TokenDto;
import com.ingeneo.scalingguacamole.entities.User;
import com.ingeneo.scalingguacamole.services.impl.UserService;
import com.ingeneo.scalingguacamole.util.AuthTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthTokenUtils jwtTokenUtil;

    @Autowired
    private UserService userService;

    @PostMapping(value = "/token")
    public TokenDto authenticateUser(@RequestBody LoginDto loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenUtil.generateJwtToken(authentication);
        UserDetailsImp userDetails = (UserDetailsImp) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        return TokenDto.builder().token(jwt).build();
    }

    @PostMapping(value = "/registration")
    public Boolean createUser(@RequestBody LoginDto loginRequest) {
        User u = this.userService.createUser(loginRequest);
        return u==null ? false : true;
    }

}
