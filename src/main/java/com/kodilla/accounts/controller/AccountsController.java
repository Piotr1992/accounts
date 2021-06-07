package com.kodilla.accounts.controller;

import com.kodilla.accounts.controller.GetAccountsResponse;
import com.kodilla.accounts.dto.Account;
import com.kodilla.accounts.dto.AccountDto;
import com.kodilla.accounts.service.AccountService;
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
import java.util.Optional;

@Slf4j
@RefreshScope
@RestController
@RequestMapping("/v1/accounts")
@RequiredArgsConstructor
public class AccountsController {

//    private List<AccountDto> accounts;

    @Value("${application.allow-get-accounts}")
    private boolean allowGetAccounts;

    private final AccountService accountService;
//    private AccountMapper accountMapper;

/*    @Autowired
    public AccountsController(List<AccountDto> accounts, AccountService accountService, AccountMapper accountMapper) {
        this.accounts = accounts;
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }               */

//    @RequestMapping(method = RequestMethod.GET, value = "")

    @GetMapping
    public GetAccountsResponse getAccounts(@RequestParam("customerId") int customerId) {

        if(!allowGetAccounts) {
//            log.info("Getting accounts is disabled");
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Getting accounts is disabled");
        }

        List<AccountDto> accounts = accountService.getAccountDto(customerId);

//        return GetAccountsResponse.of(accounts);
        return GetAccountsResponse.of(accounts);
    }

/*    @RequestMapping(method = RequestMethod.POST, value = "")
    public void addAccount(@RequestBody AccountDto account) {
        accountService.save(accountMapper.mapToAccount(account));
    }               */

}