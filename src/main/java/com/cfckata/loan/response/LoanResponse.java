package com.cfckata.loan.response;


import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.cfckata.loan.domain.LoanDomain;

public class LoanResponse {
    private String loanId;
    private String contractId;
    private BigDecimal applyAmount;
    private Integer totalMonth;
    private BigDecimal interestRate;
    private String withdrawBankAccount;
    private String repaymentBankAccount;
    private String repaymentType;
    private List<LoanRepaymentPlan> list;

    public LoanResponse() {
    }

	public String getLoanId() {
		return loanId;
	}

	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public BigDecimal getApplyAmount() {
		return applyAmount;
	}

	public void setApplyAmount(BigDecimal applyAmount) {
		this.applyAmount = applyAmount;
	}

	public Integer getTotalMonth() {
		return totalMonth;
	}

	public void setTotalMonth(Integer totalMonth) {
		this.totalMonth = totalMonth;
	}

	public BigDecimal getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(BigDecimal interestRate) {
		this.interestRate = interestRate;
	}

	public String getWithdrawBankAccount() {
		return withdrawBankAccount;
	}

	public void setWithdrawBankAccount(String withdrawBankAccount) {
		this.withdrawBankAccount = withdrawBankAccount;
	}

	public String getRepaymentBankAccount() {
		return repaymentBankAccount;
	}

	public void setRepaymentBankAccount(String repaymentBankAccount) {
		this.repaymentBankAccount = repaymentBankAccount;
	}

	public String getRepaymentType() {
		return repaymentType;
	}

	public void setRepaymentType(String repaymentType) {
		this.repaymentType = repaymentType;
	}

	public List<LoanRepaymentPlan> getList() {
		return list;
	}

	public void setList(List<LoanRepaymentPlan> list) {
		this.list = list;
	}

	public LoanResponse(String loanId, String contractId, BigDecimal applyAmount, Integer totalMonth,
			BigDecimal interestRate, String withdrawBankAccount, String repaymentBankAccount, String repaymentType,
			List<LoanRepaymentPlan> list) {
		super();
		this.loanId = loanId;
		this.contractId = contractId;
		this.applyAmount = applyAmount;
		this.totalMonth = totalMonth;
		this.interestRate = interestRate;
		this.withdrawBankAccount = withdrawBankAccount;
		this.repaymentBankAccount = repaymentBankAccount;
		this.repaymentType = repaymentType;
		this.list = list;
	}

	public LoanResponse(LoanDomain loan) {
		this.loanId = loan.getLoanId();
		this.contractId = loan.getContractId();
		this.applyAmount = loan.getApplyAmount();
		this.totalMonth = loan.getTotalMonth();
		this.interestRate = loan.getInterestRate();
		this.withdrawBankAccount = loan.getWithdrawBankAccount();
		this.repaymentBankAccount = loan.getRepaymentBankAccount();
		this.repaymentType = loan.getRepaymentType();
		this.list = loan.getList().stream().map(LoanRepaymentPlan::new)
				.collect(Collectors.toList());

	}
    

}
