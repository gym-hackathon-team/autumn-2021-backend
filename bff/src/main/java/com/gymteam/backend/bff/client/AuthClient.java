package com.gymteam.backend.bff.client;

import com.gymteam.backend.bff.dto.auth.UserDto;
import com.gymteam.backend.bff.dto.auth.AuthorizedDto;
import com.gymteam.backend.bff.dto.auth.TokenDto;
import com.gymteam.backend.bff.dto.auth.UserLoginRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@FeignClient("auth-service")
public interface AuthClient {

    @RequestMapping(value = "/auth/login", method = RequestMethod.POST)
    TokenDto signInUser(@RequestBody UserLoginRequest userLoginRequest);



    @RequestMapping(value = "/token/authorize", method = RequestMethod.GET)
    Optional<AuthorizedDto> authorize(@RequestHeader String jwt);
}
