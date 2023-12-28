package com.bakaibank.fraud.services;

public interface FraudCheckService {
    Boolean isFraudulentCustomer(Long customerId);
}
