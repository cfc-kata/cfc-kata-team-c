package com.cfckata.repay;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.stereotype.Repository;

import com.cfckata.exception.BusinessException;
import com.cfckata.loan.domain.LoanRepaymentPlanDomain;
import com.cfckata.repay.domain.RepaymentOrder;
import com.cfckata.util.DateUtils;

@Repository
public class RepayFactory {

	private RepayRepository repayRepository;
	
	public RepayFactory(RepayRepository repayRepository){
		this.repayRepository = repayRepository;
	}
	
	public RepaymentOrder findById(String id) {
		RepaymentOrder repaymentOrderDO = repayRepository.findById(id);
		return repaymentOrderDO;
	}
	
	public RepaymentOrder createReapyOrder(LoanRepaymentPlanDomain planDomain, String repaymentBankAccount) {
		BigDecimal repayAmount = planDomain.getPayableAmount();
		
		if(BigDecimal.ZERO.compareTo(repayAmount)<=0) {
			throw new BusinessException("001", "余额为0，不需要进行还款");
		}
		RepaymentOrder order  = new RepaymentOrder();
		order.setAmount(repayAmount);
		order.setCreateTime(new Date());
		order.setLoanId(planDomain.getLoanId());
		order.setRepaymentBankAccount(repaymentBankAccount);
		order.setRepaymentId(getRepaymentId(planDomain.getPlanId()));
		order.setRepaymentPlanId(planDomain.getPlanId());
		return order;
	}
	
	
	private String getRepaymentId(String planId) {
		return "RP"+DateUtils.getCurDT()+DateUtils.getCurTM()+ String.format("%010d", DateUtils.getCurTM()); 
	}
	
}
