package com.gymteam.backend.auth.service.interfaces;

import com.gymteam.backend.auth.dto.*;

public interface UserService {

    UserDto getUserByEmailAndPassword(UserLoginRequest request);

    UserDto createUser(UserRegisterRequest request);
}
