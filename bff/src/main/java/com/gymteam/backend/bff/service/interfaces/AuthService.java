package com.gymteam.backend.bff.service.interfaces;

import com.gymteam.backend.bff.dto.*;
import com.gymteam.backend.bff.exception.auth.PasswordMismatchException;

public interface AuthService {

    TokenDto signInUser(UserLoginRequest request);

    UserDto signUpUser(UserRegisterRequest request) throws PasswordMismatchException;
}
