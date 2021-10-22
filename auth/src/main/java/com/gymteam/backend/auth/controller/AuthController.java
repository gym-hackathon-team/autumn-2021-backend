package com.gymteam.backend.auth.controller;

import com.gymteam.backend.auth.dto.bff.TokenDto;
import com.gymteam.backend.auth.dto.bff.UserDto;
import com.gymteam.backend.auth.dto.bff.UserLoginRequest;
import com.gymteam.backend.auth.dto.bff.UserRegisterRequest;
import com.gymteam.backend.auth.entity.Token;
import com.gymteam.backend.auth.service.interfaces.TokenService;
import com.gymteam.backend.auth.service.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final UserService userService;

    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<TokenDto> signInUser(@RequestBody UserLoginRequest request) {
        try {
            UserDto user = userService.getUserByEmailAndPassword(request);
            Token token = tokenService.create(user);
            TokenDto tokenDto = new TokenDto(token.getValue());
            return new ResponseEntity<>(tokenDto, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> signUpUser(@RequestBody UserRegisterRequest request) {
        try {
            return new ResponseEntity<>(userService.createUser(request), HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
