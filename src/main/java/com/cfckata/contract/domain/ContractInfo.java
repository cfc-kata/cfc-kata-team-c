package com.cfckata.contract.domain;

import java.math.BigDecimal;

import com.github.meixuesong.aggregatepersistence.Versionable;

public class ContractInfo implements Versionable {
	private Customer customerInfo;
	private String contractId;
	private BigDecimal interestRate;
	private String repaymentType;
	private String maturityDate;
	private BigDecimal commitment;
	@SuppressWarnings("unused")
	private int version;
	
	public ContractInfo(Customer customerInfo, String contractId, BigDecimal interestRate, String repaymentType,
			String maturityDate, BigDecimal commitment, int version) {
		super();
		this.customerInfo = customerInfo;
		this.contractId = contractId;
		this.interestRate = interestRate;
		this.repaymentType = repaymentType;
		this.maturityDate = maturityDate;
		this.commitment = commitment;
		this.version = version;
	}

	public ContractInfo() {
		// TODO Auto-generated constructor stub
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public Customer getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(Customer customerInfo) {
		this.customerInfo = customerInfo;
	}

	public BigDecimal getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(BigDecimal interestRate) {
		this.interestRate = interestRate;
	}

	public String getRepaymentType() {
		return repaymentType;
	}

	public void setRepaymentType(String repaymentType) {
		this.repaymentType = repaymentType;
	}

	public String getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(String maturityDate) {
		this.maturityDate = maturityDate;
	}

	public BigDecimal getCommitment() {
		return commitment;
	}

	public void setCommitment(BigDecimal commitment) {
		this.commitment = commitment;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public int getVersion() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void validate() {
		this.checkAge();
		this.checkInterestRate();
		this.checkMaturityDate();
		this.checkCommitment();
		
	}

	private void checkCommitment() {
		// TODO Auto-generated method stub
		
	}

	private void checkMaturityDate() {
		// TODO Auto-generated method stub
		
	}

	private void checkInterestRate() {
		// TODO Auto-generated method stub
		
	}

	private void checkAge() {
		// TODO Auto-generated method stub
		
	}
}
