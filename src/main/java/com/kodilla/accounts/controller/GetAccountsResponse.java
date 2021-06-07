package com.kodilla.accounts.controller;

import com.kodilla.accounts.dto.Account;
import com.kodilla.accounts.dto.AccountDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class GetAccountsResponse {

    private List<AccountDto> accounts;

}