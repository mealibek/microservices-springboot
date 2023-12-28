package com.bakaibank.customer.repositories;

import com.bakaibank.customer.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
