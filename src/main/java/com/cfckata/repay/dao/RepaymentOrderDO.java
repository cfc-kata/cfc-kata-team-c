package com.cfckata.repay.dao;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.cfckata.repay.domain.RepaymentOrder;

import lombok.Data;

/**
 *还款订单
 * @author test
 *
 */
@Data
public class RepaymentOrderDO {

	public String loanId;
	public String repaymentId;
	public Date createTime;
	public String repaymentPlanId;
	public BigDecimal amount;
	public String repaymentBankAccount;
	
	public RepaymentOrder toRepaymentOrder(RepaymentOrderDO orderDO) {
		RepaymentOrder repayOrder = new RepaymentOrder();
		BeanUtils.copyProperties(orderDO, repayOrder);
		return repayOrder;
	}
	
}
