package com.kodilla.accounts.controller;

import com.kodilla.accounts.dto.Account;
import com.kodilla.accounts.dto.AccountDto;
import com.kodilla.accounts.mapper.AccountMapper;
import com.kodilla.accounts.service.AccountService;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//@Data
//@AllArgsConstructor(staticName = "of")
//@NoArgsConstructor
@RestController
@RequestMapping("/v1/accounts")
public class AccountsController {

/*    private List<AccountDto> accounts;
    private AccountService accountService;
    private AccountMapper accountMapper;

    @Autowired
    public AccountsController(List<AccountDto> accounts, AccountService accountService, AccountMapper accountMapper) {
        this.accounts = accounts;
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }               */

/*    @RequestMapping(method = RequestMethod.GET, value = "")
    public AccountDto getAccounts(@RequestParam("customerId") Long customerId) throws AccountNotFoundException {
        //getAllAccounts

        return accountMapper.mapToAccountDto(accountService.getAccount(customerId).orElseThrow(AccountNotFoundException::new)); //      .orElseThrow(AccountNotFoundException::new));
        //return accountMapper.mapToAccount(accountService.getAccount(customerId).orElseThrow(AccountNotFoundException::new));
        //return accountMapper.mapToAccountDtoList(accountService.getAllAccounts());
        //return accountMapper.mapToAccountList(accountService.getAllAccounts());
    }

    @RequestMapping(method = RequestMethod.POST, value = "")
    public void addAccount(@RequestBody AccountDto account) {
        accountService.save(accountMapper.mapToAccount(account));
    }                   */

}