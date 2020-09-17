package com.cfckata.repay.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.cfckata.repay.domain.RepaymentOrder;

import lombok.Data;

@Data
public class RepaymentResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4536723659268724181L;
	
	
	private String repaymentId;
	private Date createTime;
	private String loanId;
	private String repaymentPlanId;
	private BigDecimal amount =BigDecimal.ZERO;
	private String repaymentBankAccount;
	
	public RepaymentResponse() {
	}
	
	
	
	public RepaymentResponse(RepaymentOrder repaymentOrder) {
		this.repaymentId = repaymentOrder.getRepaymentId();
		this.createTime = repaymentOrder.getCreateTime();
		this.loanId = repaymentOrder.getLoanId();
		this.repaymentPlanId = repaymentOrder.getRepaymentPlanId();
		this.amount = repaymentOrder.getAmount();
		this.repaymentBankAccount = repaymentOrder.getRepaymentBankAccount();
	}
}
