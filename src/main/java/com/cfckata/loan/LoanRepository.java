package com.cfckata.loan;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Repository;

import com.cfckata.loan.dao.LoanInfoDO;
import com.cfckata.loan.dao.LoanInfoDOMapper;
import com.cfckata.loan.dao.LoanRepaymentPlanDO;
import com.cfckata.loan.dao.LoanRepaymentPlanDOMapper;
import com.cfckata.loan.domain.LoanDomain;
import com.cfckata.loan.domain.LoanRepaymentPlanDomain;
import com.github.meixuesong.aggregatepersistence.Aggregate;
import com.github.meixuesong.aggregatepersistence.AggregateFactory;

@Repository
public class LoanRepository {
    private LoanInfoDOMapper loanInfoDOMapper;
    private LoanRepaymentPlanDOMapper loanRepaymentPlanDOMapper;

    public LoanRepository(LoanInfoDOMapper loanInfoDOMapper, LoanRepaymentPlanDOMapper loanRepaymentPlanDOMapper) {
		this.loanInfoDOMapper = loanInfoDOMapper;
		this.loanRepaymentPlanDOMapper = loanRepaymentPlanDOMapper;
	}

	public Aggregate<LoanDomain> selectByLoanId(String loanId) {
		LoanInfoDO loanDO = loanInfoDOMapper.selectByPrimaryKey(loanId);
        if (loanDO == null) {
            throw new EntityNotFoundException("Order(" + loanId + ") not found");
        }

        LoanDomain loanDomain = loanDO.toDomain();
        loanDomain.setList(getPlanList(loanId));

        return AggregateFactory.createAggregate(loanDomain);
    }


    private List<LoanRepaymentPlanDomain> getPlanList(String loanId) {
        List<LoanRepaymentPlanDO> planDOs = loanRepaymentPlanDOMapper.selectByLoanNo(loanId);

        return planDOs.stream()
                .map(planDO -> {
                    return planDO.toDomain();
                })
                .collect(Collectors.toList());
    }


}
