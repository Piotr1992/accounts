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

    public Optional<Account> getAccount(final Long id) {
        return repository.findById(id);
    }

    public List<AccountDto> getAccountDto(final Long id) {
        //return repository.findByIdd(id);
        return repository.findByIddto(id);
    }

    public List<Account> getAccountCustomer(final Long id) {
        return repository.findByIdCustomer(id);
    }

    public void save(Account account) {
        repository.save(account);
    }

}
