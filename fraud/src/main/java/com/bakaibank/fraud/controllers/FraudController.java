package com.bakaibank.fraud.controllers;

import com.bakaibank.fraud.dto.FraudCheckResponse;
import com.bakaibank.fraud.services.FraudCheckService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/fraud-check")
@Slf4j
public class FraudController {
    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Long customerId) {
        log.info("Checking if customer id: {} is fraudster", customerId);
        Boolean fraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerId);
        return new FraudCheckResponse(fraudulentCustomer);
    }
}
