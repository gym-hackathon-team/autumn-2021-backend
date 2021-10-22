package com.gymteam.backend.bff.client;

import com.gymteam.backend.bff.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

@FeignClient("user-service")
public interface UserClient {

    @RequestMapping(value = "/", method = RequestMethod.POST)
    UserDto createUser(@RequestBody UserDto userDto);

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    UserDto updateUser(@RequestBody UserDto userDto);

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    UserDto getUser(@PathVariable UUID id);
}
