package com.gymteam.backend.bff.client;

import com.gymteam.backend.bff.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

@FeignClient("user-service")
public interface UserClient {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String hello();

    @RequestMapping(value = "/", method = RequestMethod.POST)
    User createUser(@RequestBody User user);

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    User updateUser(@RequestBody User user);

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    User getUser(@PathVariable UUID id);
}
