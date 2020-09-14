package com.cfckata.contract.domain;

import java.math.BigDecimal;

import com.github.meixuesong.aggregatepersistence.Versionable;

public class ContractInfo implements Versionable{
	    private Customer customerInfo;
	    private String contractId;
	    private BigDecimal interestRate;
	    private String repaymentType;
	    private String maturityDate;
	    private BigDecimal commitment;
	    @SuppressWarnings("unused")
		private int version;
	    
		
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
		
}
