package com.cfckata.loan.dao;

import java.math.BigDecimal;

import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;

import com.cfckata.loan.domain.LoanRepaymentPlanDomain;
import com.cfckata.util.UuidUtil;

import lombok.Data;

@Data
public class LoanRepaymentPlanDO {

	private String planId;
    private String loanId;
    private Integer periodNo; //期号
    private String payableDate; //还款日期
    private BigDecimal payableAmount; //应还总额
    private BigDecimal payableInterest; //应还利息
    private BigDecimal payableCapital; //应还本金
    private BigDecimal remainCapital; //剩余本金
    private String status; //状态
    
    public LoanRepaymentPlanDO() {
    	
    }
    
    public LoanRepaymentPlanDO(LoanRepaymentPlanDomain planDomain) {
    	this.planId = StringUtils.isEmpty(planDomain.getPlanId())?UuidUtil.getUuid():planDomain.getPlanId();
    	this.loanId = planDomain.getLoanId();
    	this.periodNo = planDomain.getPeriodNo();
    	this.payableDate = planDomain.getPayableDate();
    	this.payableAmount = planDomain.getPayableAmount();
    	this.payableInterest = planDomain.getPayableInterest();
    	this.payableCapital = planDomain.getPayableCapital();
    	this.remainCapital = planDomain.getRemainCapital();
    	this.status = planDomain.getStatus();
	}

	public LoanRepaymentPlanDomain toDomain() {
    	LoanRepaymentPlanDomain domain = new LoanRepaymentPlanDomain();
    	BeanUtils.copyProperties(this, domain);
    	return domain;
    }

}
