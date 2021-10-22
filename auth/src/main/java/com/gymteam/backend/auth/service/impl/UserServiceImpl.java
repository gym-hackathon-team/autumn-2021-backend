package com.gymteam.backend.auth.service.impl;

import com.gymteam.backend.auth.client.UserClient;
import com.gymteam.backend.auth.dto.bff.UserDto;
import com.gymteam.backend.auth.dto.bff.UserLoginRequest;
import com.gymteam.backend.auth.dto.bff.UserRegisterRequest;
import com.gymteam.backend.auth.mapper.interfaces.UserServiceUserBffMapper;
import com.gymteam.backend.auth.service.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserClient userClient;

    private final UserServiceUserBffMapper mapper;

    @Override
    public UserDto getUserByEmailAndPassword(UserLoginRequest request) {
        return mapper.convertToUserBffDto(userClient.getUserByEmailAndPassword(request.getEmail(), request.getPassword()));
    }

    @Override
    public UserDto createUser(UserRegisterRequest request) {
        com.gymteam.backend.auth.dto.user.UserDto userDto = new com.gymteam.backend.auth.dto.user.UserDto();
        userDto.setEmail(request.getEmail());
        userDto.setPassword(request.getPassword());
        userDto.setFirstName(request.getFirstName());
        userDto.setLastName(request.getLastName());

        return mapper.convertToUserBffDto(userClient.createUser(userDto));
    }
}
