package com.gymteam.backend.auth.service.impl;

import com.gymteam.backend.auth.client.UserClient;
import com.gymteam.backend.auth.dto.*;
import com.gymteam.backend.auth.service.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserClient userClient;

    @Override
    public UserDto getUserByEmailAndPassword(UserLoginRequest request) {
        return userClient.getUserByEmailAndPassword(request.getEmail(), request.getPassword());
    }

    @Override
    public UserDto createUser(UserRegisterRequest request) {
        UserDto userDto = new UserDto();
        userDto.setEmail(request.getEmail());
        userDto.setPassword(request.getPassword());
        userDto.setFirstName(request.getFirstName());
        userDto.setLastName(request.getLastName());

        return userClient.createUser(userDto);
    }
}
