package com.gymteam.backend.bff.controller;

import com.gymteam.backend.bff.dto.auth.TokenDto;
import com.gymteam.backend.bff.dto.auth.UserLoginRequest;
import com.gymteam.backend.bff.service.interfaces.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/user/login")
    public ResponseEntity<TokenDto> signInUser(@RequestBody UserLoginRequest request) {
        try {
            return new ResponseEntity<>(authService.signInUser(request), HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
