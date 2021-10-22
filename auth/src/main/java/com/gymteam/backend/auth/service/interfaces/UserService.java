package com.gymteam.backend.auth.service.interfaces;

import com.gymteam.backend.auth.dto.bff.UserDto;
import com.gymteam.backend.auth.dto.bff.UserLoginRequest;


public interface UserService {

    UserDto getUserByEmailAndPassword(UserLoginRequest request);


}
