package com.cfckata.loan.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoanRepaymentPlanDOMapper {
    int insert(LoanRepaymentPlanDO record);

    int insertSelective(LoanRepaymentPlanDO record);

    LoanRepaymentPlanDO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(LoanRepaymentPlanDO record);

    int updateByPrimaryKey(LoanRepaymentPlanDO record);

    int delete(LoanRepaymentPlanDO record);
    
    List<LoanRepaymentPlanDO> selectByLoanNo(String loanNo);

    int insertBatch(List<LoanRepaymentPlanDO> list);
    
    /**
     * 根据还款日期筛选应还的还款计划
     * @param curDt
     * @return
     */
    List<LoanRepaymentPlanDO> selectByDt(String curDt);
}
