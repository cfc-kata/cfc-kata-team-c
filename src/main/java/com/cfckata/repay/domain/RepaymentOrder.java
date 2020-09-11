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

	public String loanId;
	public String repaymentId;
	public Date createTime;
	public String repaymentPlanId;
	public BigDecimal amount;
	public String repaymentBankAccount;
	
	public RepaymentOrder() {
		
	}
	
	/**/
	public RepaymentOrder(String repaymentPlanId) {
		RepaymentOrder repaymentOrder = new RepaymentOrder();
		repaymentOrder.setCreateTime(new Date());
	}
	
}
