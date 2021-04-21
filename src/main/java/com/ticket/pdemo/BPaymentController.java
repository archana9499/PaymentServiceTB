package com.ticket.pdemo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class BPaymentController {
	
	
	@Autowired
    private BPaymentService bpaymentservice;

	
	
	
	@CrossOrigin(origins="http://localhost:4200")
	//fix
	 @RequestMapping(value = "/doPayment", method = RequestMethod.POST)
	
	    public BPayment doPayment(@RequestBody BPayment payment) {
	        return bpaymentservice.doPayment(payment);
	    }

	 
		@RequestMapping(value = "/bpaycont", method = RequestMethod.GET)
	    public String getHi() {
	        System.out.println("bpaymentcontrollerworks!!!");
	        return "bpaymentcontrollerworks";
	    }
	 
	
	 
	 
	

}
