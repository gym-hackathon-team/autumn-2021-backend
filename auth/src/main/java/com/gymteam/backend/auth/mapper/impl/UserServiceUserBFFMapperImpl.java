package com.gymteam.backend.auth.mapper.impl;

import com.gymteam.backend.auth.dto.user.UserDto;
import com.gymteam.backend.auth.mapper.interfaces.UserServiceUserBffMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceUserBFFMapperImpl implements UserServiceUserBffMapper {



    @Override
    public com.gymteam.backend.auth.dto.bff.UserDto convertToUserBffDto(UserDto fromUserService) {
        com.gymteam.backend.auth.dto.bff.UserDto fromBff = new com.gymteam.backend.auth.dto.bff.UserDto();
        fromBff.setId(fromUserService.getId());
        fromBff.setEmail(fromUserService.getEmail());
        fromBff.setPassword(fromUserService.getPassword());
        fromBff.setFirstName(fromUserService.getFirstName());
        fromBff.setLastName(fromUserService.getLastName());
        return fromBff;
    }
}
