package com.gymteam.backend.auth.client;

import com.gymteam.backend.auth.dto.user.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("user-service")
public interface UserClient {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    UserDto getUserByEmailAndPassword(@RequestHeader String login, @RequestHeader String password);

    @RequestMapping(value = "/", method = RequestMethod.POST)
    UserDto createUser(@RequestBody UserDto userDto);
}
