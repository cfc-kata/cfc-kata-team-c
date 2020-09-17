package com.cfckata.repay;

import org.springframework.stereotype.Repository;

import com.cfckata.repay.domain.RepaymentOrder;

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
	
	public void createReapyOrder(String repayPlanId) {
		//TODO 查询金额
		//生成订单
		//扣款
	}
}
