package bank.PaymentMS.DTO;

import java.util.Date;



public class CreditDTO {
	private Long creditnumber;
	private String accountType;
	private Double availableBalance;
	private Float interest;
	
	private Double dueAmount;
	private Date paymentDueDate;
	private Double outStandingBalance;
	
	public CreditDTO() {
		super();
	}
	
	public CreditDTO(Long creditnumber, String accountType, Double availableBalance,
			Float interest, Double dueAmount, Date paymentDueDate, Double outStandingBalance) {
		this();
	
		this.creditnumber = creditnumber;
		this.accountType = accountType;
		this.availableBalance = availableBalance;
		this.interest = interest;
		this.dueAmount = dueAmount;
		this.paymentDueDate = paymentDueDate;
		this.outStandingBalance = outStandingBalance;
	}
	





	public Long getCreditnumber() {
		return creditnumber;
	}

	public void setCreditnumber(Long creditnumber) {
		this.creditnumber = creditnumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Double getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(Double availableBalance) {
		this.availableBalance = availableBalance;
	}

	public Float getInterest() {
		return interest;
	}

	public void setInterest(Float interest) {
		this.interest = interest;
	}

	public Double getDueAmount() {
		return dueAmount;
	}

	public void setDueAmount(Double dueAmount) {
		this.dueAmount = dueAmount;
	}

	public Date getPaymentDueDate() {
		return paymentDueDate;
	}

	public void setPaymentDueDate(Date paymentDueDate) {
		this.paymentDueDate = paymentDueDate;
	}

	public Double getOutStandingBalance() {
		return outStandingBalance;
	}

	public void setOutStandingBalance(Double outStandingBalance) {
		this.outStandingBalance = outStandingBalance;
	}
	

}
