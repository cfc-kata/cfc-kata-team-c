package com.cfckata.contract.request;

import com.cfckata.contract.domain.Customer;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author shuwei.dou
 * @description
 * @date 2020/9/11 11:04
 * @copyright (c) 2020
 */
public class ContractCreateReq implements Serializable {
	@NotBlank
    private Customer customerInfo;
	@NotNull
	@DecimalMax("30.00")
    private BigDecimal interestRate;
	@NotBlank
    private String repaymentType;
	@NotBlank
    private String maturityDate;
	@DecimalMin("100.00")
	@DecimalMax("200000.00")
    private BigDecimal commitment;

    private String contractId;
    
    public ContractCreateReq() {
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

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
    
    
}
