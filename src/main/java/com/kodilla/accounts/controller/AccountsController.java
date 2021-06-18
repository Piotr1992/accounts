package com.kodilla.accounts.controller;

import com.kodilla.accounts.dto.Account;
import com.kodilla.accounts.dto.AccountDto;
import com.kodilla.accounts.mapper.AccountMapper;
import com.kodilla.accounts.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
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

    private final AccountMapper accountMapper;

    @GetMapping
    public GetAccountsResponse getAccounts(@RequestParam("customerId") Long customerId) {
        log.info("Get accounts for customerId: {}", customerId);
        if(!allowGetAccounts) {
            log.info("Getting accounts is disabled");
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Getting accounts is disabled");
        }

        List<AccountDto> accounts = accountMapper.mapToAccountDtoList(List.of(accountService.getAccount(customerId).orElse(new Account())));

        return GetAccountsResponse.of(accounts);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addCustomer(@RequestBody AccountDto account) {
        accountService.save(accountMapper.mapToAccount(account));
    }

}