package bank.PaymentMS.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bank.PaymentMS.DTO.AccountDTO;
import bank.PaymentMS.DTO.PaymentDTO;
import bank.PaymentMS.entity.PaymentEntity;
import bank.PaymentMS.repository.PaymentRepository;

@Service
@Transactional
public class PaymentService {

	@Autowired
	PaymentRepository paymentRepository;
	
	@PersistenceContext
	private EntityManager manager;

	public List<PaymentDTO> getPaymentsbyAccountId(Long accountId) {
		List<PaymentEntity> entity = paymentRepository.findAll();
		List<PaymentDTO> paymentDTO = new ArrayList<PaymentDTO>();
		for (PaymentEntity pe : entity) {
			if (pe.getCustomerId().equals(accountId)) {
				PaymentDTO dto = PaymentDTO.valueOf(pe);
				paymentDTO.add(dto);
			}
		}
		return paymentDTO;
	}

	public List<PaymentDTO> getPaymentsbyStatus(String status) {
		List<PaymentEntity> entity = paymentRepository.findAll();
		List<PaymentDTO> paymentDTO = new ArrayList<PaymentDTO>();
		for (PaymentEntity pe : entity) {
			if (pe.getStatus().equals(status)) {
				PaymentDTO dto = PaymentDTO.valueOf(pe);
				paymentDTO.add(dto);
			}
		}
		return paymentDTO;
	}

	public Double viewDue(String accountType, AccountDTO accountDTO) {
		Double value = null;
		if (accountDTO.getCredit().getAccountType().equals(accountType)) {
			value = accountDTO.getCredit().getDueAmount();
		}
		if (accountDTO.getCurrent().getAccountType().equals(accountType)) {
			value = accountDTO.getCurrent().getDueAmount();
		}
		return value;

	}

	public Double makePayment(AccountDTO accountDTO, Long accountnumber, String accountType) throws Exception{
		
		Double value=null;
		if(accountDTO.getCredit().getCreditnumber().equals(accountnumber)) {
			
			Double due=accountDTO.getCredit().getDueAmount();
			if(accountDTO.getSavings().getAccountType().equals(accountType)){
				Double amount=accountDTO.getSavings().getAvailableBalance();
				if(amount>due) {
						value=amount-due;
					
				}else {
					throw new Exception("Service.BALANCE");
				}
			}
			else if(accountDTO.getCurrent().getAccountType().equals(accountType)) {
				Double amount=accountDTO.getCurrent().getAvailableBalance();
				if(amount>due) {
					 value=amount-due;
				}else {
					throw new Exception("Service.BALANCE");
				}
			}else {
				throw new Exception("Service.PAYMENT");
			}
		}
		if(accountDTO.getCurrent().getCurrentnumber().equals(accountnumber)) {
			System.out.println("inside 2nd if");
			Double due=accountDTO.getCurrent().getDueAmount();
			if(accountDTO.getSavings().getAccountType().equals(accountType)){
				Double amount=accountDTO.getSavings().getAvailableBalance();
				if(amount>due) {
					 value=amount-due;
					
				}else {
					throw new Exception("Service.PAYMENT");
				}
			}
		}
		System.out.println(value);
		PaymentEntity entity =PaymentDTO.entityOf(accountDTO,accountType,value);
		
		return value;
}

}
