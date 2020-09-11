package com.cfckata.loan.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoanInfoDOMapper {
    int insert(LoanInfoDO record);

    int insertSelective(LoanInfoDO record);

    LoanInfoDO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(LoanInfoDO record);

    int updateByPrimaryKey(LoanInfoDO record);

    int delete(LoanInfoDO record);

    LoanInfoDO selectByLoanId(String loanId);
}
