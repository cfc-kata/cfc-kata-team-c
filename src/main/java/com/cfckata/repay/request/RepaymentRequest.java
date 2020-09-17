package com.cfckata.repay.request;

import java.io.Serializable;

import lombok.Data;

@Data
public class RepaymentRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1198394593090739958L;
	private String repaymentPlanId;
	/**
	 * 还款卡号
	 */
	private String repaymentBankAccount;
}
