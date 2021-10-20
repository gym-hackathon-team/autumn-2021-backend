package com.gymteam.backend.user.mapper.interfaces;

import com.gymteam.backend.user.dto.UserDto;
import com.gymteam.backend.user.entity.User;

public interface UserMapper {

    User convertToEntity(UserDto dto);

    UserDto convertToDto(User dto);
}
