package com.gymteam.backend.bff.service.interfaces;

import com.gymteam.backend.bff.dto.auth.TokenDto;
import com.gymteam.backend.bff.dto.auth.UserDto;
import com.gymteam.backend.bff.dto.auth.UserLoginRequest;
import com.gymteam.backend.bff.dto.auth.UserRegisterRequest;
import com.gymteam.backend.bff.exception.auth.PasswordMismatchException;

public interface AuthService {

    TokenDto signInUser(UserLoginRequest request);

    UserDto signUpUser(UserRegisterRequest request) throws PasswordMismatchException;
}
