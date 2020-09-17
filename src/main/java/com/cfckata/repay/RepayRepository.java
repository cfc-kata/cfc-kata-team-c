package com.cfckata.repay;

import org.springframework.stereotype.Repository;

import com.cfckata.repay.dao.RepaymentOrderDO;
import com.cfckata.repay.dao.RepaymentOrderDOMapper;
import com.cfckata.repay.domain.RepaymentOrder;

@Repository
public class RepayRepository {

private RepaymentOrderDOMapper repaymentOrderMapper;
	
	public RepayRepository(RepaymentOrderDOMapper repaymentOrderMapper){
		this.repaymentOrderMapper = repaymentOrderMapper;
	}
	
	public RepaymentOrder findById(String id) {
		RepaymentOrderDO repaymentOrderDO = repaymentOrderMapper.findByRepaymentId(id);
		
		return repaymentOrderDO.toRepaymentOrder(repaymentOrderDO);
	}
	
	
//	public Integer save(RepaymentOrder repaymentOrder) {
//		return 1;
//		//return repaymentOrderMapper.insert(new RepaymentOrderDO(repaymentOrder));
//    }
}
