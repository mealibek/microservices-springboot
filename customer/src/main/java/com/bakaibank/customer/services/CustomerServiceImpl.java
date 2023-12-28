package com.bakaibank.customer.services;

import com.bakaibank.customer.dto.CustomerRequest;
import com.bakaibank.customer.dto.FraudCheckResponse;
import com.bakaibank.customer.models.Customer;
import com.bakaibank.customer.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    @Override
    public void register(CustomerRequest customerRequest) {
        Customer customer = Customer.builder()
                .firstName(customerRequest.getFirstName())
                .lastName(customerRequest.getLastName())
                .email(customerRequest.getEmail())
                .build();


        // todo: check if email valid
        // todo: check if email not taken
        customerRepository.saveAndFlush(customer);

        // todo: check if customer fraudster
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://localhost:8090/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );

        if(fraudCheckResponse.getIsFraudster()) {
            throw new IllegalStateException("fraudster");
        }

        // todo: send notification
    }
}
