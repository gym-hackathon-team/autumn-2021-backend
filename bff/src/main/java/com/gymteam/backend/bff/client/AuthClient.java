package com.gymteam.backend.bff.client;

import com.gymteam.backend.bff.dto.auth.AuthorizedDto;
import com.gymteam.backend.bff.dto.Admin;
import com.gymteam.backend.bff.dto.User;
import com.gymteam.backend.bff.dto.auth.AuthToken;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@FeignClient("auth-service")
public interface AuthClient {

    @RequestMapping(value = "/auth/admin/signin", method = RequestMethod.POST)
    AuthToken signInAdmin(@RequestBody Admin user);

    @RequestMapping(value = "/auth/admin/signup", method = RequestMethod.POST)
    Admin signUpAdmin(@RequestBody Admin user);

    @RequestMapping(value = "/auth/user/signin", method = RequestMethod.POST)
    AuthToken signInUser(@RequestBody User user);

    @RequestMapping(value = "/auth/user/signup", method = RequestMethod.POST)
    User signUpUser(@RequestBody User user);

    @RequestMapping(value = "/token/authorize", method = RequestMethod.GET)
    Optional<AuthorizedDto> authorize(@RequestHeader String jwt);
}
