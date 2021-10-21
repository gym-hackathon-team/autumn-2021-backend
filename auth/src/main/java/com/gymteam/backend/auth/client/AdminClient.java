package com.gymteam.backend.auth.client;

import com.gymteam.backend.auth.dto.Admin;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("admin-service")
public interface AdminClient {

    @RequestMapping(value = "/", method = RequestMethod.POST)
    Admin createAdmin(@RequestBody Admin admin);
}
