package com.gymteam.backend.bff.service.interfaces;

import com.gymteam.backend.bff.dto.Admin;
import com.gymteam.backend.bff.dto.User;
import com.gymteam.backend.bff.dto.auth.*;
import com.gymteam.backend.bff.exception.auth.PasswordMismatchException;

public interface AuthService {

    AuthToken signInAdmin(AdminLoginRequest request);

    Admin signUpAdmin(AdminRegisterRequest request) throws PasswordMismatchException;

    AuthToken signInUser(UserLoginRequest request);

    User signUpUser(UserRegisterRequest request) throws PasswordMismatchException;
}
