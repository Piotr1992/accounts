package com.kodilla.accounts.service;

import com.kodilla.accounts.dto.*;
import com.kodilla.accounts.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

//@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@SpringBootTest
class ProductServiceTest {

    @Autowired
    private AccountService accountService;
//    private AccountRepository accountRepository;

    @Test
    void findCustomerAccounts() {
        //Given
        Long customerId = 12L;

        //When
        //Optional<Account> accounts = accountRepository.findById(customerId);
//        List<AccountDto> accounts = accountRepository.findByIddto(customerId);
//        List<AccountDto> accounts = accountService.getAccountDto(customerId);

        List<Account> accounts = accountService.getAccountCustomer(customerId);

        //Optional<Account> accounts = accountService.getAccount(customerId);

//        List<Account> accounts = accountService.getAllAccounts();



/*        long id = 5;

        for (AccountDto account1 : accounts)
        {
            id = account1.getId();
            //id = account1.getIddto();
        }               */

        //Then
//        assertTrue(accounts.isEmpty());
//        assertEquals(1, accounts.size());
        assertEquals(2, accounts.size());
//        assertEquals(0.12, accounts.get().getAvailableFunds());
    }

}