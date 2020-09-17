package com.cfckata.repay.domain;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

/**
 *还款订单
 * @author test
 *
 */
@Data
public class RepaymentOrder {

	private String loanId;
	private String repaymentId;
	private Date createTime;
	private String repaymentPlanId;
	private BigDecimal amount;
	private String repaymentBankAccount;
	private String repaySts;
	private int version;
	
	public RepaymentOrder() {
		
	}
	
	/**/
	public RepaymentOrder(String repaymentPlanId) {
		RepaymentOrder repaymentOrder = new RepaymentOrder();
		repaymentOrder.setCreateTime(new Date());
	}
	
}
