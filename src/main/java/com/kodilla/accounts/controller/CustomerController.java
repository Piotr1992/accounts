package com.kodilla.accounts.controller;

import com.kodilla.accounts.dto.CustomerDto;
import com.kodilla.accounts.mapper.CustomerMapper;
import com.kodilla.accounts.service.CustomerService;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Data
@Slf4j
@RefreshScope
@RestController
@RequestMapping("/v1/customers")
//@RequiredArgsConstructor
//@NoArgsConstructor
public class CustomerController {

    @Value("${application.allow-get-customers}")
    private boolean allowGetCustomers;
    private final CustomerService customerService;
    private CustomerMapper customerMapper;

    @Autowired
    public CustomerController(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    @GetMapping( "/{customerId}")
    public GetCustomerResponse getCustomers(@RequestParam(value = "customerId") Long customerId) {

        if(!allowGetCustomers) {
            log.info("Getting accounts is disabled");
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Getting customers is disabled");
        }

        List<CustomerDto> customers = customerService.getCustomerDto(customerId);

        return GetCustomerResponse.of(customers);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public void addCustomer(@RequestBody CustomerDto customer) {
        customerService.save(customerMapper.mapToCustomer(customer));
    }

}