package com.kodilla.accounts.repository;

import com.kodilla.accounts.dto.Customer;
import com.kodilla.accounts.dto.CustomerDto;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Override
    List<Customer> findAll();

    @Override
    Customer save(Customer task);

    @Override
    Optional<Customer> findById(Long id);

    List<CustomerDto> findByIdDto(Long id);

    void deleteById(Long id);

}