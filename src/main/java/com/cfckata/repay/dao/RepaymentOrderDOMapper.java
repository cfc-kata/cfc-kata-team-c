package com.cfckata.repay.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RepaymentOrderDOMapper {

	RepaymentOrderDO findByRepaymentId(String repaymentId);
	
	//int insert(RepaymentOrderDO record);
	
}
