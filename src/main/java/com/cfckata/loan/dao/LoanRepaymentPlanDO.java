package com.cfckata.loan.dao;

import java.math.BigDecimal;

import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;

import com.cfckata.loan.domain.LoanRepaymentPlanDomain;
import com.cfckata.util.UuidUtil;

import lombok.Data;

@Data
public class LoanRepaymentPlanDO {
	private String id;
    private String loanId;
    private String contractId;
    private BigDecimal applyAmount;
    private Integer totalMonth;
    private BigDecimal interestRate;
    private String withdrawBankAccount;
    private String repaymentBankAccount;
    private String repaymentType;
    
    public LoanRepaymentPlanDO() {
    	
    }
    
    public LoanRepaymentPlanDO(LoanRepaymentPlanDomain planDomain) {
    	this.id = StringUtils.isEmpty(planDomain.getId())?UuidUtil.getUuid():planDomain.getId();
    	this.loanId = planDomain.getLoanId();
    	this.contractId = planDomain.getContractId();
    	this.applyAmount = planDomain.getApplyAmount();
    	this.totalMonth = planDomain.getTotalMonth();
    	this.interestRate = planDomain.getInterestRate();
    	this.withdrawBankAccount = planDomain.getWithdrawBankAccount();
    	this.repaymentBankAccount = planDomain.getRepaymentBankAccount();
    	this.repaymentType = planDomain.getRepaymentType();
	}

	public LoanRepaymentPlanDomain toDomain() {
    	LoanRepaymentPlanDomain domain = new LoanRepaymentPlanDomain();
    	BeanUtils.copyProperties(this, domain);
    	return domain;
    }

}
