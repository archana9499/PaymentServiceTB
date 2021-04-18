package com.ticket.pdemo;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface BPaymentRepository extends MongoRepository<BPayment,Integer> {
 
	BPayment findByOrderId(int orderId);
}
