package com.gymteam.backend.user.service.interfaces;

import com.gymteam.backend.user.entity.User;
import com.gymteam.backend.user.exception.NotFoundException;

import java.util.UUID;

public interface UserService {

    User getUser(UUID id) throws NotFoundException;

    void createUser(User user);

    User updateUser(User user) throws NotFoundException;
}
