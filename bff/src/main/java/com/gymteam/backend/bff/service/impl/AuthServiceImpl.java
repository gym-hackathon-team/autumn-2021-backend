package com.gymteam.backend.bff.service.impl;

import com.gymteam.backend.bff.client.AuthClient;
import com.gymteam.backend.bff.dto.auth.TokenDto;
import com.gymteam.backend.bff.dto.auth.UserDto;
import com.gymteam.backend.bff.dto.auth.UserLoginRequest;
import com.gymteam.backend.bff.dto.auth.UserRegisterRequest;
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
    public TokenDto signInUser(UserLoginRequest request) {
        UserDto userDto = new UserDto();
        userDto.setEmail(request.getEmail());
        userDto.setPassword(request.getPassword());

        return authClient.signInUser(userDto);
    }

    @Override
    public UserDto signUpUser(UserRegisterRequest request) throws PasswordMismatchException {
        if (!Objects.equals(request.getPassword(), request.getPasswordConfirmation())) {
            throw new PasswordMismatchException();
        }

        UserDto userDto = new UserDto();
        userDto.setEmail(request.getEmail());
        userDto.setPassword(request.getPassword());
        userDto.setFirstName(request.getFirstName());
        userDto.setLastName(request.getLastName());

        return authClient.signUpUser(userDto);
    }
}
