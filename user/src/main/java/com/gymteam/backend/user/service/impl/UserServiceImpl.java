package com.gymteam.backend.user.service.impl;

import com.gymteam.backend.user.entity.User;
import com.gymteam.backend.user.exception.NotFoundException;
import com.gymteam.backend.user.repository.UserRepository;
import com.gymteam.backend.user.service.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getUser(UUID id) throws NotFoundException {
        Optional<User> customerOptional = userRepository.findById(id);
        return customerOptional.orElseThrow(NotFoundException::new);
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User updateUser(User user) throws NotFoundException {
        // TODO Update Method instead mapping
        if (user.getId() == null) {
            throw new NotFoundException();
        }
        User existing = userRepository.findById(user.getId()).orElseThrow(NotFoundException::new);
        if (user.getEmail() == null) {
            user.setEmail(existing.getEmail());
        }
        if (user.getPassword() == null) {
            user.setPassword(existing.getPassword());
        }
        userRepository.save(user);
        return user;
    }
}
