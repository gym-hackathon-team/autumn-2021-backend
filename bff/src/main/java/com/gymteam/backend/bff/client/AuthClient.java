package com.gymteam.backend.bff.client;

import com.gymteam.backend.bff.dto.auth.UserDto;
import com.gymteam.backend.bff.dto.auth.AuthorizedDto;
import com.gymteam.backend.bff.dto.auth.TokenDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@FeignClient("auth-service")
public interface AuthClient {

    @RequestMapping(value = "/auth/user/signin", method = RequestMethod.POST)
    TokenDto signInUser(@RequestBody UserDto userDto);

    @RequestMapping(value = "/auth/user/signup", method = RequestMethod.POST)
    UserDto signUpUser(@RequestBody UserDto userDto);

    @RequestMapping(value = "/token/authorize", method = RequestMethod.GET)
    Optional<AuthorizedDto> authorize(@RequestHeader String jwt);
}
