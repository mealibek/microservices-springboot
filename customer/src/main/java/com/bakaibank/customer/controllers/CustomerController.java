package com.bakaibank.customer.controllers;

import com.bakaibank.customer.dto.CustomerRequest;
import com.bakaibank.customer.services.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
@Slf4j
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRequest customerRequest) {
        log.info("new customer registration {}", customerRequest);
        customerService.register(customerRequest);
    }
}
