package com.kodilla.accounts.controller;

import com.kodilla.accounts.dto.CustomerDto;
import com.kodilla.accounts.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Slf4j
@RefreshScope
@RestController
@RequestMapping("/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    @Value("${application.allow-get-customers}")
    private boolean allowGetAccounts;

    private final CustomerService accountService;

    @GetMapping
    public GetCustomerResponse getAccounts(@RequestParam("customerId") Long customerId) {

        if(!allowGetAccounts) {
            log.info("Getting accounts is disabled");
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Getting accounts is disabled");
        }

        List<CustomerDto> accounts = accountService.getAccountDto(customerId);

        return GetCustomerResponse.of(accounts);
    }

}