package com.gymteam.backend.bff.controller;

import com.gymteam.backend.bff.dto.Admin;
import com.gymteam.backend.bff.dto.User;
import com.gymteam.backend.bff.dto.auth.*;
import com.gymteam.backend.bff.exception.auth.PasswordMismatchException;
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

    @PostMapping("/admin/signin")
    public ResponseEntity<AuthToken> signInAdmin(@RequestBody AdminLoginRequest request) {
        try {
            return new ResponseEntity<>(authService.signInAdmin(request), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/admin/signup")
    public ResponseEntity<Admin> signUpAdmin(@RequestBody AdminRegisterRequest request) {
        try {
            return new ResponseEntity<>(authService.signUpAdmin(request), HttpStatus.OK);
        } catch (PasswordMismatchException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/user/login")
    public ResponseEntity<AuthToken> signInUser(@RequestBody UserLoginRequest request) {
        try {
            return new ResponseEntity<>(authService.signInUser(request), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/user/register")
    public ResponseEntity<User> signUpUser(@RequestBody UserRegisterRequest request) {
        try {
            return new ResponseEntity<>(authService.signUpUser(request), HttpStatus.OK);
        } catch (PasswordMismatchException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
