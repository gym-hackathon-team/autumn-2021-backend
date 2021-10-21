package com.gymteam.backend.bff.service.impl;

import com.gymteam.backend.bff.client.AuthClient;
import com.gymteam.backend.bff.dto.Admin;
import com.gymteam.backend.bff.dto.User;
import com.gymteam.backend.bff.dto.auth.*;
import com.gymteam.backend.bff.exception.auth.PasswordMismatchException;
import com.gymteam.backend.bff.service.interfaces.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthClient authClient;

    @Override
    public AuthToken signInAdmin(AdminLoginRequest request) {
        Admin admin = new Admin();
        admin.setEmail(request.getEmail());
        admin.setPassword(request.getPassword());

        return authClient.signInAdmin(admin);
    }

    @Override
    public Admin signUpAdmin(AdminRegisterRequest request) throws PasswordMismatchException {
        if (!Objects.equals(request.getPassword(), request.getPasswordConfirmation())) {
            throw new PasswordMismatchException();
        }

        Admin admin = new Admin();
        admin.setEmail(request.getEmail());
        admin.setPassword(request.getPassword());
        admin.setFirstName(request.getFirstName());
        admin.setLastName(request.getLastName());

        return authClient.signUpAdmin(admin);
    }

    @Override
    public AuthToken signInUser(UserLoginRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        return authClient.signInUser(user);
    }

    @Override
    public User signUpUser(UserRegisterRequest request) throws PasswordMismatchException {
        if (!Objects.equals(request.getPassword(), request.getPasswordConfirmation())) {
            throw new PasswordMismatchException();
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());

        return authClient.signUpUser(user);
    }
}
