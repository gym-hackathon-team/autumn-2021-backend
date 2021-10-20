package com.gymteam.backend.user.controller;

import com.gymteam.backend.user.dto.UserDto;
import com.gymteam.backend.user.entity.User;
import com.gymteam.backend.user.exception.NotFoundException;
import com.gymteam.backend.user.mapper.interfaces.UserMapper;
import com.gymteam.backend.user.service.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    private final UserMapper userMapper;

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> read(@PathVariable UUID id) {
        try {
            return new ResponseEntity<>(userMapper.convertToDto(userService.getUser(id)), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<UserDto> create(@RequestBody UserDto dto) {
        try {
            User user = userMapper.convertToEntity(dto);
            userService.createUser(user);
            return new ResponseEntity<>(userMapper.convertToDto(user), HttpStatus.CREATED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/")
    public ResponseEntity<UserDto> update(@RequestBody UserDto dto) {
        try {
            User user = userService.updateUser(userMapper.convertToEntity(dto));
            return new ResponseEntity<>(userMapper.convertToDto(user), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
