package com.kodilla.accounts.service;

import com.kodilla.accounts.dto.Account;
import com.kodilla.accounts.dto.AccountDto;
import com.kodilla.accounts.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;

    public List<Account> getAllAccounts() {
        return repository.findAll();
    }

    public Optional<Account> getAccount(final int id) {
        //return repository.findById(id);
        return repository.findById(id);
    }

    public List<AccountDto> getAccountDto(final int id) {
        //return repository.findById(id);
        return repository.findByIdDto(id);
    }

    public void save(Account account) {
        repository.save(account);
    }

}
