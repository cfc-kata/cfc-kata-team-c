package com.cfckata.contract.domain;

import com.cfckata.common.util.DateUtil;
import com.github.meixuesong.aggregatepersistence.Versionable;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;
import java.util.Date;

/**
 * @author shuwei.dou
 * @description
 * @date 2020/9/11 11:11
 * @copyright (c) 2020
 */
public class Contract implements Serializable, Versionable {
	private static final long serialVersionUID = 6978019166211994966L;
	private static Integer contractNumber = new Integer(0);
	private static List<CommitmentLimit> commitmentLimitList;

	private Customer customerInfo;
	private String contractId;
	private BigDecimal interestRate;
	private String repaymentType;
	private String maturityDate;
	private BigDecimal commitment;
	private String contractStatus;

	static {
		commitmentLimitList.add(new CommitmentLimit(0,17,BigDecimal.ZERO));
		commitmentLimitList.add(new CommitmentLimit(18,20, new BigDecimal("10000.00")));
		commitmentLimitList.add(new CommitmentLimit(21,30,new BigDecimal("50000.00")));
		commitmentLimitList.add(new CommitmentLimit(31,50,new BigDecimal("200000.00")));
		commitmentLimitList.add(new CommitmentLimit(51,60,new BigDecimal("30000.00")));
		commitmentLimitList.add(new CommitmentLimit(61,70,new BigDecimal("10000.00")));
		commitmentLimitList.add(new CommitmentLimit(71,200,BigDecimal.ZERO));
	}

	public Contract() {
	}

	public Contract(Customer customerInfo, BigDecimal interestRate, String repaymentType, String maturityDate, BigDecimal commitment) {
		this.customerInfo = customerInfo;
		this.contractId = genreateContractId();
		this.interestRate = interestRate;
		this.repaymentType = repaymentType;
		this.maturityDate = maturityDate;
		this.commitment = commitment;
	}

	public Contract(Customer customerInfo, BigDecimal interestRate, String repaymentType, String maturityDate, BigDecimal commitment, String contractStatus) {
		this.customerInfo = customerInfo;
		this.contractId = genreateContractId();
		this.interestRate = interestRate;
		this.repaymentType = repaymentType;
		this.maturityDate = maturityDate;
		this.commitment = commitment;
		this.contractStatus = contractStatus;
	}

	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}

	public String getContractId() {
		return contractId;
	}

	public static Integer getContractNumber() {
		return contractNumber;
	}

	public static void setContractNumber(Integer contractNumber) {
		Contract.contractNumber = contractNumber;
	}

	public static List<CommitmentLimit> getCommitmentLimitList() {
		return commitmentLimitList;
	}

	public static void setCommitmentLimitList(List<CommitmentLimit> commitmentLimitList) {
		Contract.commitmentLimitList = commitmentLimitList;
	}

	public Customer getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(Customer customerInfo) {
		this.customerInfo = customerInfo;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
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

	public String getContractStatus() {
		return contractStatus;
	}


	private String genreateContractId(){
		synchronized(Contract.class){
			return DateUtil.getCurDateNoSep()+String.format("%08d",++contractNumber);
		}
	}

	public void validate() throws ParseException {
		validateCommitment();
		validateMaturityDate();
	}

	public void validateCommitment(){
		int age = Customer.getAgeByIdCard(this.customerInfo.getIdNumber());
		for(CommitmentLimit limit : commitmentLimitList){
			if (age >= limit.getAgeFrom() && age <= limit.getAgeTo() && commitment.compareTo(limit.getMaxCommitment()) > 0) {
				throw new IllegalArgumentException(
						String.format("申请额度超限, 不能超过%s", limit.getMaxCommitment()));
			}
		}
	}

	public void validateMaturityDate() throws ParseException {
		if(DateUtil.FORMAT_ON_DAY.parse(this.maturityDate).compareTo(new Date()) > 2){
			throw new IllegalArgumentException("到期日距现在不能超过2年");
		}
	}

	@Override
	public int getVersion() {
		return 0;
	}
}
