package com.kodilla.accounts.mapper;

import com.kodilla.accounts.dto.Account;
import com.kodilla.accounts.dto.AccountDto;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountMapper {

    public AccountDto mapToAccountDto(final Account account) {
        return new AccountDto(
                account.getIddto(),
                account.getNrb(),
                account.getCurrency(),
                account.getAvailableFunds()
        );
    }

    public List<AccountDto> mapToAccountDtoList(final List<Account> accountList) {
        return accountList.stream()
                .map(this::mapToAccountDto)
                .collect(Collectors.toList());
    }

    public Account mapToAccount(AccountDto account) {
        return new Account(account.getId(), account.getNrb(), account.getCurrency(), account.getAvailableFunds());
    }

}

