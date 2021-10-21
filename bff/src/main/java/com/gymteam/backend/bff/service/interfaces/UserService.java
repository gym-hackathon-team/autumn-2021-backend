package com.gymteam.backend.bff.service.interfaces;

import com.gymteam.backend.bff.dto.User;

import java.util.UUID;

public interface UserService {

    User get(UUID id);

    User update(User user);
}
