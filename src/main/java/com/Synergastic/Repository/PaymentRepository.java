package com.Synergastic.Repository;




import org.springframework.data.mongodb.repository.MongoRepository;

import com.Synergastic.model.Payment;

public interface PaymentRepository extends MongoRepository<Payment, String> {
}

