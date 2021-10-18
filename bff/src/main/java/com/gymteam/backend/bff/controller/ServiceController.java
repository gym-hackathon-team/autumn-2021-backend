package com.gymteam.backend.bff.controller;

import com.gymteam.backend.bff.client.AdminServiceClient;
import com.gymteam.backend.bff.client.UserServiceClient;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ServiceController {

    private final AdminServiceClient adminServiceClient;

    private final UserServiceClient userServiceClient;

    @GetMapping("/admin")
    public ResponseEntity<String> helloFromAdminService() {
        return new ResponseEntity<>(adminServiceClient.hello(), HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<String> helloFromUserService() {
        return new ResponseEntity<>(userServiceClient.hello(), HttpStatus.OK);
    }

}
