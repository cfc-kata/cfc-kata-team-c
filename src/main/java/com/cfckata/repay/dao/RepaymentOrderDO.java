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

	private String loanId;
	private String repaymentId;
	private Date createTime;
	private String repaymentPlanId;
	private BigDecimal amount;
	private String repaymentBankAccount;
	private String repaySts;
	private Integer version;
	
	public RepaymentOrder toRepaymentOrder(RepaymentOrderDO orderDO) {
		RepaymentOrder repayOrder = new RepaymentOrder();
		BeanUtils.copyProperties(orderDO, repayOrder);
		return repayOrder;
	}
	
}