package bank.PaymentMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import bank.PaymentMS.DTO.AccountDTO;
import bank.PaymentMS.DTO.PaymentDTO;
import bank.PaymentMS.service.PaymentService;

@RestController
@CrossOrigin
@PropertySource("classpath:configuration.properties")
public class PaymentController {

	@Autowired
	PaymentService paymentService;
	
	@Autowired
	Environment environment;
	
	@GetMapping(value="/payments/{accountId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PaymentDTO> viewPayments(@PathVariable Long accountId){
		List<PaymentDTO> paymentDTO=paymentService.getPaymentsbyAccountId(accountId);
		return paymentDTO;
	}
	
	@GetMapping(value="/payment/{status}")
	public List<PaymentDTO> viewStatus(@PathVariable String status){
		List<PaymentDTO> paymentDTO=paymentService.getPaymentsbyStatus(status);
		return paymentDTO;
	}
	
	@GetMapping(value="/payment/viewPaymentDues/{customerId}/{accountType}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Double viewDues(@PathVariable Integer customerId,@PathVariable String accountType) throws Exception {
		try {
		AccountDTO accountDTO=new RestTemplate().getForObject("http://localhost:8000/summary/"+customerId, AccountDTO.class);
		return paymentService.viewDue(accountType, accountDTO);
		}catch(Exception e) {
			throw new Exception(environment.getProperty(e.getMessage()),e);
		}
	}
	
	@PostMapping(value="/payment/pay/{customerId}/{accountnumber}/{accountType}")
	public Double duepay(@PathVariable Integer customerId,@PathVariable Long accountnumber,@PathVariable String accountType) throws Exception{
		AccountDTO accountDTO=new RestTemplate().getForObject("http://localhost:8000/summary/"+customerId, AccountDTO.class);
		try {
			
			return paymentService.makePayment(accountDTO,accountnumber,accountType);	
		}catch (Exception e) {
			throw new Exception(environment.getProperty(e.getMessage()),e);
		}
		
	}

	

	

	

}
