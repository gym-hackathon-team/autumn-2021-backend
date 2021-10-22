package com.gymteam.backend.bff.service.impl;

import com.gymteam.backend.bff.client.UserClient;
import com.gymteam.backend.bff.dto.UserDto;
import com.gymteam.backend.bff.service.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserClient userClient;

    @Override
    public UserDto get(UUID id) {
        return userClient.getUser(id);
    }

    @Override
    public UserDto update(UserDto userDto) {
        return userClient.updateUser(userDto);
    }
}
