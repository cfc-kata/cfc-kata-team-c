package com.cfckata.contract.dao;

import java.math.BigDecimal;
import java.util.Date;
import com.cfckata.contract.domain.Contract;
import com.cfckata.contract.domain.Customer;

public class ContractDo {
	private String id;
	private BigDecimal interestRate;
	private String repaymentType;
	private String maturityDate;
	private BigDecimal commitment;
	private Date createTime;
	private String customerId;
	private String customerName;
	private String customerIdNumber;
	private String customerMobilePhone;
	private String contractStatus;
	private Integer version;

	public Contract toContract() {
		Contract Contract = new Contract();
		Contract.setContractId(id);
		Contract.setCommitment(commitment);
		Customer customer = new Customer(customerId,customerName,customerIdNumber,customerMobilePhone);
		Contract.setCustomerInfo(customer);
		Contract.setInterestRate(interestRate);
		Contract.setMaturityDate(maturityDate);
		Contract.setRepaymentType(repaymentType);
		Contract.setContractStatus(contractStatus);
		return Contract;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerIdNumber() {
		return customerIdNumber;
	}

	public void setCustomerIdNumber(String customerIdNumber) {
		this.customerIdNumber = customerIdNumber;
	}

	public String getCustomerMobilePhone() {
		return customerMobilePhone;
	}

	public void setCustomerMobilePhone(String customerMobilePhone) {
		this.customerMobilePhone = customerMobilePhone;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getContractStatus() {
		return contractStatus;
	}

	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "ContractDo [customerName=" + customerName + ", interestRate=" + interestRate + ", repaymentType="
				+ repaymentType + ", maturityDate=" + maturityDate + ", commitment=" + commitment + "]";
	}
}
