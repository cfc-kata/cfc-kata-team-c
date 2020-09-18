package com.cfckata.contract.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ContractDoMapper {
	int insert(ContractDo contractDo);
	ContractDo selectByPrimaryKey(String id);
}
