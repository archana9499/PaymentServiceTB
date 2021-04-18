package com.ticket.pdemo;

import java.util.List;
import java.util.UUID;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@EnableEurekaClient
@ComponentScan(basePackages="com.ticket.pdemo")
@SpringBootApplication
@RestController

public class PaymentServiceApplication {
	
	@Autowired
	private BPaymentRepository bpaymentrepository;
	
	
	@Autowired
	private SequenceGeneratorService sgservice;
	
	@Autowired
	private BPaymentService bpayservice;
	
	
	@PostMapping("/savePayment")
	public BPayment save(@RequestBody BPayment bpayment) {
		bpayment.setPaymentId(sgservice.getSequenceNumber(BPayment.SEQUENCE_NAME));
		bpayment.setTransactionId(UUID.randomUUID().toString());
		return bpaymentrepository.save(bpayment);
		
		
	}
	
	
	
	
	@GetMapping("/payment")
	public List<BPayment> getBPayment(){
		return bpaymentrepository.findAll();
	}
	
	@GetMapping("/savePayment/{orderId}")
    public BPayment findPaymentHistoryByOrderId(@PathVariable int orderId){
              return bpayservice.findPaymentHistoryByOrderId(orderId);
    }
	

	public static void main(String[] args) {
		SpringApplication.run(PaymentServiceApplication.class, args);
	}
}
