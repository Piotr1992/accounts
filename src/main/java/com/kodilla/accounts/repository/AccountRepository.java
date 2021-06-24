package com.kodilla.accounts.repository;

import com.kodilla.accounts.dto.Account;
import com.kodilla.accounts.dto.AccountDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Override
    List<Account> findAll();

    @Override
    Account save(Account task);

    @Override
    Optional<Account> findById(Long id);

    List<AccountDto> findByIddto(Long id);

    List<Account> findByIdCustomer(Long id);

    void deleteById(Long id);

}