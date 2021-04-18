package com.ticket.pdemo;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BPaymentService {

	@Autowired
	private BPaymentRepository bpaymentrepository;

	public BPayment doPayment(BPayment payment) {
		payment.setPaymentStatus(paymentProcessing());
		payment.setTransactionId(UUID.randomUUID().toString());

		return bpaymentrepository.save(payment);
	}

	public String paymentProcessing() {
		return new Random().nextBoolean()?"success":"false";
	}
	
	public BPayment findPaymentHistoryByOrderId(int orderId) {
        
        return bpaymentrepository.findByOrderId(orderId) ;
    }

}
