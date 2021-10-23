package com.gymteam.backend.bff.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("account-service")
public interface AccountClient {
}
