package com.gymteam.backend.auth.mapper.interfaces;

import com.gymteam.backend.auth.dto.user.UserDto;

public interface UserServiceUserBffMapper {



    com.gymteam.backend.auth.dto.bff.UserDto convertToUserBffDto(UserDto fromUserService);
}
