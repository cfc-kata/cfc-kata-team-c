package com.cfckata.loan.dao;

import java.math.BigDecimal;
import java.util.List;

import com.cfckata.loan.domain.LoanDomain;
import com.cfckata.loan.response.LoanRepaymentPlan;

import lombok.Data;

@Data
public class LoanInfoDO {

	private String loanId;
    private String contractId;
    private BigDecimal applyAmount;
    private Integer totalMonth;
    private BigDecimal interestRate;
    private String withdrawBankAccount;
    private String repaymentBankAccount;
    private String repaymentType;
    
    public LoanInfoDO() {
    	
    }

	public LoanDomain toDomain() {
		LoanDomain loan = new LoanDomain();
		loan.setApplyAmount(getApplyAmount());
		loan.setContractId(getContractId());
		loan.setInterestRate(getInterestRate());
		loan.setLoanId(getLoanId());
		loan.setRepaymentBankAccount(getRepaymentBankAccount());
		loan.setRepaymentType(getRepaymentBankAccount());
		loan.setTotalMonth(getTotalMonth());
		loan.setWithdrawBankAccount(getWithdrawBankAccount());
		return null;
	}

}
