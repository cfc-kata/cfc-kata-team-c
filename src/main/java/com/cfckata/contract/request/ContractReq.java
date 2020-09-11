package com.cfckata.contract.request;

import com.cfckata.contract.domain.Customer;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author shuwei.dou
 * @description
 * @date 2020/9/11 11:04
 * @copyright (c) 2020
 */
public class ContractReq implements Serializable {
    private Customer customerInfo;
    private BigDecimal interestRate;
    private String repaymentType;
    private String maturityDate;
    private BigDecimal commitment;
    
    public ContractReq() {
    	
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
    
    
}
