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
	
	public RepaymentOrderDO() {
		
	}
	
	public RepaymentOrder toRepaymentOrder(RepaymentOrderDO orderDO) {
		RepaymentOrder repayOrder = new RepaymentOrder();
		BeanUtils.copyProperties(orderDO, repayOrder);
		return repayOrder;
	}
	
	public RepaymentOrderDO(RepaymentOrder repayOrder) {
		this.loanId = repayOrder.getLoanId();
		this.repaymentId = repayOrder.getRepaymentId();
		this.createTime = repayOrder.getCreateTime();
		this.repaymentPlanId = repayOrder.getRepaymentPlanId();
		this.amount = repayOrder.getAmount();
		this.repaymentBankAccount = repayOrder.getRepaymentBankAccount();
		this.repaySts = repayOrder.getRepaySts();
		this.version = repayOrder.getVersion();
	}
}
