package com.gymteam.backend.bff.client;

import com.gymteam.backend.bff.dto.Admin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

@FeignClient("admin-service")
public interface AdminServiceClient {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String hello();

    @RequestMapping(value = "/", method = RequestMethod.POST)
    Admin createAdmin(@RequestBody Admin admin);

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    Admin updateAdmin(@RequestBody Admin admin);

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Admin getAdmin(@PathVariable UUID id);
}
