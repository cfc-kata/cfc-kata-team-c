package com.cfckata.loan.dao;

import java.math.BigDecimal;

import org.springframework.beans.BeanUtils;

import com.cfckata.loan.domain.LoanRepaymentPlanDomain;

import lombok.Data;

@Data
public class LoanRepaymentPlanDO {
	
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
    
    public LoanRepaymentPlanDomain toDomain() {
    	LoanRepaymentPlanDomain domain = new LoanRepaymentPlanDomain();
    	BeanUtils.copyProperties(this, domain);
    	return domain;
    }

}
