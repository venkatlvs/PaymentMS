package bank.PaymentMS.DTO;

import java.time.LocalDate;
import bank.PaymentMS.entity.PaymentEntity;

public class PaymentDTO {
	Integer customerId;
	Long paymentId;
	LocalDate date;
	String type;
	String status;
	Double amount;
	AccountDTO accountDTO;

	public PaymentDTO() {
		super();
	}

	public PaymentDTO(AccountDTO accountDTO,
	SavingsDTO savingsDTO,
	CurrentDTO currentDTO,
	CreditDTO creditDTO,Integer customerId, Long paymentId, LocalDate date, String type, String status, Double amount) {
		this();
		this.accountDTO=accountDTO;
		this.customerId = customerId;
		this.paymentId = paymentId;
		this.amount = amount;
		this.date = date;
		this.status = status;
		this.type = type;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}



	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public AccountDTO getAccountDTO() {
		return accountDTO;
	}

	public void setAccountDTO(AccountDTO accountDTO) {
		this.accountDTO = accountDTO;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

//	Entity to dto
	public static PaymentDTO valueOf(PaymentEntity pe) {
		PaymentDTO dto = new PaymentDTO();
		dto.setCustomerId(pe.getCustomerId());
		dto.setPaymentId(pe.getPaymentId());
		dto.setDate(pe.getDate());
		dto.setStatus(pe.getStatus());
		dto.setType(pe.getType());
		dto.setAmount(pe.getAmount());
		return dto;
	}

//	DTO to entity
	public static PaymentEntity entityOf(AccountDTO dto,String accountType,Double amount) {
		PaymentEntity entity = new PaymentEntity();
		entity.setCustomerId(dto.getCustomerId());
		entity.setAmount(amount);
		entity.setDate(LocalDate.now());
		entity.setStatus("PAID");
		entity.setType(accountType);
		return entity;
	}

}
