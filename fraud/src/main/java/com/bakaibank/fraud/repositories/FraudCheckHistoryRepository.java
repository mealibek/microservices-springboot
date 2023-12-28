package com.bakaibank.fraud.repositories;

import com.bakaibank.fraud.models.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory, Long> {
}
