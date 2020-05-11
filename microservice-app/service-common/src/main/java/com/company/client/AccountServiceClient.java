package com.company.client;

import com.company.client.contract.AccountDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("account-service")
public interface AccountServiceClient {

    @GetMapping("/{id}")
    ResponseEntity<AccountDTO> get(@PathVariable("id") String id);
}
