package com.kodilla.accounts.controller;

import com.kodilla.accounts.dto.AccountDto;
import com.kodilla.accounts.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@Slf4j
@RefreshScope
@RestController
@RequestMapping("/v1/accounts")
@RequiredArgsConstructor
public class AccountsController {

    @Value("${application.allow-get-accounts}")
    private boolean allowGetAccounts;

    private final AccountService accountService;

    @GetMapping
    public GetAccountsResponse getAccounts(@RequestParam("customerId") Long customerId) {
        log.info("Get accounts for customerId: {}", customerId);
        if(!allowGetAccounts) {
            log.info("Getting accounts is disabled");
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Getting accounts is disabled");
        }

        List<AccountDto> accounts = accountService.getAccountDto(customerId);

        return GetAccountsResponse.of(accounts);
    }

}