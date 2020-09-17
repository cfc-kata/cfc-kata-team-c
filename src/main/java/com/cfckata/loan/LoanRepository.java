package com.cfckata.loan;

import java.util.ArrayList;
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

	public Aggregate<LoanDomain> findByLoanId(String loanId) {
		// TODO 持久层实现待添加
		LoanInfoDO loanDO = new LoanInfoDO();
		loanDO.setLoanId("JJ000001");
//		LoanInfoDO loanDO = loanInfoDOMapper.selectByPrimaryKey(loanId);
//        if (loanDO == null) {
//            throw new EntityNotFoundException("Order(" + loanId + ") not found");
//        }

        LoanDomain loanDomain = loanDO.toDomain();
        List<LoanRepaymentPlanDomain> planList = new ArrayList();
        loanDomain.setList(planList);
//        loanDomain.setList(getPlanList(loanId));

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
    
    public LoanRepaymentPlanDomain getLoanRepaymentPlanDomainById(String planId) {
    	LoanRepaymentPlanDO planDO = loanRepaymentPlanDOMapper.selectByPrimaryKey(planId);
    	return planDO.toDomain();
    }

    /**
     * 插入借据及还款计划
     * @param aggregate
     */
	public void save(Aggregate<LoanDomain> aggregate) {
		// todo 持久层待实现
//		LoanInfoDO loanDO = loanInfoDOMapper.selectByPrimaryKey(aggregate.getRoot().getLoanId());
//		if(loanDO!=null) {
//			return;
//		}
//		loanInfoDOMapper.insert(new LoanInfoDO(aggregate.getRoot()));
//		
//		loanRepaymentPlanDOMapper.insertBatch(getPlanList(aggregate.getRoot().getList()));
	}

	public List<LoanRepaymentPlanDO> getPlanList(List<LoanRepaymentPlanDomain> domainList){
		List<LoanRepaymentPlanDO> list = new ArrayList();
		if(domainList==null||domainList.size()==0) {
			return list;
		}
		for(LoanRepaymentPlanDomain planDomain: domainList) {
			list.add(new LoanRepaymentPlanDO(planDomain));
		}
		return list;
	}
}
