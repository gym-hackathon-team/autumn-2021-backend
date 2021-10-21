package com.gymteam.backend.bff.client;

import com.gymteam.backend.bff.dto.Admin;
import com.gymteam.backend.bff.dto.User;
import com.gymteam.backend.bff.dto.auth.AuthToken;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("auth-service")
public interface AuthClient {

    @RequestMapping(value = "/admin/signin", method = RequestMethod.POST)
// TODO change route
    AuthToken signInAdmin(@RequestBody Admin user);

    @RequestMapping(value = "/admin/signup", method = RequestMethod.POST)
// TODO change route
    Admin signUpAdmin(@RequestBody Admin user);

    @RequestMapping(value = "/user/signin", method = RequestMethod.POST)
// TODO change route
    AuthToken signInUser(@RequestBody User user);

    @RequestMapping(value = "/user/signup", method = RequestMethod.POST)
// TODO change route
    User signUpUser(@RequestBody User user);
}
