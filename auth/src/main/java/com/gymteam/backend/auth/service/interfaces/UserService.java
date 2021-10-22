package com.gymteam.backend.auth.service.interfaces;

import com.gymteam.backend.auth.dto.bff.UserDto;
import com.gymteam.backend.auth.dto.bff.UserLoginRequest;
import com.gymteam.backend.auth.dto.bff.UserRegisterRequest;

public interface UserService {

    UserDto getUserByEmailAndPassword(UserLoginRequest request);

    UserDto createUser(UserRegisterRequest request);
}
