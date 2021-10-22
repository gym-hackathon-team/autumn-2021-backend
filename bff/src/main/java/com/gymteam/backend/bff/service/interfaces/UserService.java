package com.gymteam.backend.bff.service.interfaces;

import com.gymteam.backend.bff.dto.user.UserDto;

import java.util.UUID;

public interface UserService {

    UserDto get(UUID id);

    UserDto update(UserDto userDto);
}
