package com.gymteam.backend.bff.service.impl;

import com.gymteam.backend.bff.client.AuthClient;
import com.gymteam.backend.bff.dto.Admin;
import com.gymteam.backend.bff.dto.User;
import com.gymteam.backend.bff.dto.auth.*;
import com.gymteam.backend.bff.exception.auth.FieldEmptyException;
import com.gymteam.backend.bff.exception.auth.FieldMissingException;
import com.gymteam.backend.bff.exception.auth.PasswordMismatchException;
import com.gymteam.backend.bff.service.interfaces.AuthService;
import feign.FeignException;
import feign.RetryableException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthClient authClient;

    @Override
    public AuthToken signInAdmin(AdminLoginRequest request) throws FieldMissingException, FieldEmptyException {
        if (request.getEmail() == null || request.getPassword() == null) {
            throw new FieldMissingException();
        }
        if (Objects.equals(request.getEmail(), "") || Objects.equals(request.getPassword(), "")) {
            throw new FieldEmptyException();
        }
        Admin admin = new Admin();
        admin.setEmail(request.getEmail());
        admin.setPassword(request.getPassword());


        return authClient.signInAdmin(admin);
    }

    @Override
    public Admin signUpAdmin(AdminRegisterRequest request) throws PasswordMismatchException, FieldMissingException, FieldEmptyException {
        if (request.getEmail() == null || request.getPassword() == null || request.getPasswordConfirmation() == null ||
                request.getFirstName() == null || request.getLastName() == null) {
            throw new FieldMissingException();
        }
        if (Objects.equals(request.getEmail(), "") || Objects.equals(request.getPassword(), "") || request.getPasswordConfirmation() == "" ||
                Objects.equals(request.getFirstName(), "") || Objects.equals(request.getLastName(), "")) {
            throw new FieldEmptyException();
        }

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
    public AuthToken signInUser(UserLoginRequest request) throws FieldMissingException, FieldEmptyException {

        if (request.getEmail() == null || request.getPassword() == null) {
            throw new FieldMissingException();
        }
        if (Objects.equals(request.getEmail(), "") || Objects.equals(request.getPassword(), "")) {
            throw new FieldEmptyException();
        }
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        return authClient.signInUser(user);
    }


    @Override
    public User signUpUser(UserRegisterRequest request) throws PasswordMismatchException, FieldMissingException, FieldEmptyException {

        if (request.getEmail() == null || request.getPassword() == null || request.getPasswordConfirmation() == null ||
                request.getFirstName() == null || request.getLastName() == null) {
            throw new FieldMissingException();
        }
        if (Objects.equals(request.getEmail(), "") || Objects.equals(request.getPassword(), "") || request.getPasswordConfirmation() == "" ||
                Objects.equals(request.getFirstName(), "") || Objects.equals(request.getLastName(), "")) {
            throw new FieldEmptyException();
        }
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
