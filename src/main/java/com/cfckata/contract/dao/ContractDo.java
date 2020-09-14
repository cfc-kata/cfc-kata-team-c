package com.cfckata.contract.dao;

import java.math.BigDecimal;

import com.cfckata.contract.domain.ContractInfo;
import com.cfckata.contract.domain.Customer;

public class ContractDo {
		private String contractId;
	    private Customer customerInfo;
	    private BigDecimal interestRate;
	    private String repaymentType;
	    private String maturityDate;
	    private BigDecimal commitment;
	    
	    
	    
	    public ContractInfo toContract() {
	    	ContractInfo contractInfo = new ContractInfo();
	    	contractInfo.setContractId(contractId);
	    	contractInfo.setCommitment(commitment);
	    	contractInfo.setCustomerInfo(customerInfo);
	    	contractInfo.setInterestRate(interestRate);
	    	contractInfo.setMaturityDate(maturityDate);
	    	contractInfo.setRepaymentType(repaymentType);
	    	return contractInfo;
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
		@Override
		public String toString() {
			return "ContractDo [customerInfo=" + customerInfo + ", interestRate=" + interestRate + ", repaymentType="
					+ repaymentType + ", maturityDate=" + maturityDate + ", commitment=" + commitment + "]";
		}
	    
}
