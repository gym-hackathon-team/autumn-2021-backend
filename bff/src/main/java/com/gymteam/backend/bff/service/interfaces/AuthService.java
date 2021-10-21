package com.gymteam.backend.bff.service.interfaces;

import com.gymteam.backend.bff.dto.Admin;
import com.gymteam.backend.bff.dto.User;
import com.gymteam.backend.bff.dto.auth.*;
import com.gymteam.backend.bff.exception.auth.FieldEmptyException;
import com.gymteam.backend.bff.exception.auth.FieldMissingException;
import com.gymteam.backend.bff.exception.auth.PasswordMismatchException;

public interface AuthService {

    AuthToken signInAdmin(AdminLoginRequest request) throws FieldMissingException, FieldEmptyException;

    Admin signUpAdmin(AdminRegisterRequest request) throws PasswordMismatchException, FieldMissingException, FieldEmptyException;

    AuthToken signInUser(UserLoginRequest request) throws FieldMissingException, FieldEmptyException;

    User signUpUser(UserRegisterRequest request) throws PasswordMismatchException, FieldMissingException, FieldEmptyException;
}
