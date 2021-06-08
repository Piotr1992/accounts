package com.kodilla.accounts.mapper;

import com.kodilla.accounts.dto.Customer;
import com.kodilla.accounts.dto.CustomerDto;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerMapper {

    public CustomerDto mapToCustomerDto(final Customer account) {
        return new CustomerDto(
                account.getIdDto(),
                account.getFirstName(),
                account.getLastName()
        );
    }

    public List<CustomerDto> mapToCustomerDtoList(final List<Customer> customerList) {
        return customerList.stream()
                .map(this::mapToCustomerDto)
                .collect(Collectors.toList());
    }

    public Customer mapToCustomer(CustomerDto account) {
        return new Customer(account.getId(), account.getFirstName(), account.getLastName());
    }

}

