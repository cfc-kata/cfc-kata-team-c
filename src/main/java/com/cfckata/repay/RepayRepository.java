package com.cfckata.repay;

import org.springframework.stereotype.Repository;

import com.cfckata.repay.dao.RepaymentOrderDO;
import com.cfckata.repay.dao.RepaymentOrderMapper;
import com.cfckata.repay.domain.RepaymentOrder;

@Repository
public class RepayRepository {

private RepaymentOrderMapper repaymentOrderMapper;
	
	public RepayRepository(RepaymentOrderMapper repaymentOrderMapper){
		this.repaymentOrderMapper = repaymentOrderMapper;
	}
	
	public RepaymentOrder findById(String id) {
		RepaymentOrderDO repaymentOrderDO = repaymentOrderMapper.findById(id);
		
		return repaymentOrderDO.toRepaymentOrder(repaymentOrderDO);
	}
}
