package bank.PaymentMS.DTO;


import java.util.Date;

public class CurrentDTO {
	

	private Long currentnumber;
	private String accountType;
	private Double beginningBalance;
	private Double availableBalance ;
    private Double dueAmount;
	private Date paymentDueDate;
    private Double outstandingBalance;
    
	public CurrentDTO() {
		super();
		
	}

	public CurrentDTO(Long currentnumber, String accountType, Double beginningBalance,
			Double availableBalance, Double dueAmount, Date paymentDueDate, Double outstandingBalance) {
		super();
	
		this.currentnumber = currentnumber;
		this.accountType = accountType;
		this.beginningBalance = beginningBalance;
		this.availableBalance = availableBalance;
		this.dueAmount = dueAmount;
		this.paymentDueDate = paymentDueDate;
		this.outstandingBalance = outstandingBalance;
	}
	

	
	public Long getCurrentnumber() {
		return currentnumber;
	}

	public void setCurrentnumber(Long currentnumber) {
		this.currentnumber = currentnumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Double getBeginningBalance() {
		return beginningBalance;
	}

	public void setBeginningBalance(Double beginningBalance) {
		this.beginningBalance = beginningBalance;
	}

	public Double getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(Double availableBalance) {
		this.availableBalance = availableBalance;
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

	public Double getOutstandingBalance() {
		return outstandingBalance;
	}

	public void setOutstandingBalance(Double outstandingBalance) {
		this.outstandingBalance = outstandingBalance;
	}
	

	
	

}
