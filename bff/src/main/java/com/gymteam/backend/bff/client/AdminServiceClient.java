package com.gymteam.backend.bff.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("admin-service")
public interface AdminServiceClient {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String hello();

}
