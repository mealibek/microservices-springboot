package com.bakaibank.fraud.services;

import com.bakaibank.fraud.models.FraudCheckHistory;
import com.bakaibank.fraud.repositories.FraudCheckHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FraudCheckServiceImpl implements FraudCheckService {
    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;
    @Override
    public Boolean isFraudulentCustomer(Long customerId) {
        FraudCheckHistory fraudCheckHistory = FraudCheckHistory.builder()
                .customerId(customerId)
                .isFraudster(false)
                .createdAt(LocalDateTime.now())
                .build();

        fraudCheckHistoryRepository.save(fraudCheckHistory);
        return false;
    }
}
