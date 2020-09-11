package com.cfckata.repay.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class RepaymentResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4536723659268724181L;
	
	
	private String repaymntId;
	private Date createTime;
	private String loanId;
	private String repaymentPlanId;
	private BigDecimal amount =BigDecimal.ZERO;
	private String repaymentBankAccount;
}
