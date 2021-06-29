package bank.PaymentMS.DTO;


import java.util.Date;


public class SavingsDTO {
	private Long savingsnumber;
	private String accountType;
	private Double availableBalance;
	private Date lastTransactionDate;
	private Integer interest;
	
	
	public SavingsDTO() {
		super();
	}


	

	public SavingsDTO(Long savingsnumber, String accountType, Double availableBalance,
			Date lastTransactionDate, Integer interest) {
		this();
		this.savingsnumber = savingsnumber;
		this.accountType = accountType;
		this.availableBalance = availableBalance;
		this.lastTransactionDate = lastTransactionDate;
		this.interest = interest;
	}
	



	public Long getSavingsnumber() {
		return savingsnumber;
	}




	public void setSavingsnumber(Long savingsnumber) {
		this.savingsnumber = savingsnumber;
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


	public Date getLastTransactionDate() {
		return lastTransactionDate;
	}


	public void setLastTransactionDate(Date lastTransactionDate) {
		this.lastTransactionDate = lastTransactionDate;
	}


	public Integer getInterest() {
		return interest;
	}


	public void setInterest(Integer interest) {
		this.interest = interest;
	}



	
	

}
