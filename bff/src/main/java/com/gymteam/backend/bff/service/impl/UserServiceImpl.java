package com.gymteam.backend.bff.service.impl;

import com.gymteam.backend.bff.client.UserClient;
import com.gymteam.backend.bff.dto.User;
import com.gymteam.backend.bff.service.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserClient userClient;

    @Override
    public User get(UUID id) {
        return userClient.getUser(id);
    }

    @Override
    public User update(User user) {
        return userClient.updateUser(user);
    }
}
