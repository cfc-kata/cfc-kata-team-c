package com.cfckata.repay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cfckata.loan.LoanRepaymentPlanService;
import com.cfckata.repay.domain.RepaymentOrder;

/**
 * 还款的service
 * @author menglei
 *
 */
@Service
public class RepayService {
	private RepayRepository repayRepository;
    private RepayFactory repayFactory;
    
    public RepayService(RepayRepository repayRepository, RepayFactory repayFactory) {
		this.repayRepository = repayRepository;
		this.repayFactory = repayFactory;
	}

	@Autowired 
	LoanRepaymentPlanService loanRepaymentPlanService;
	
	public RepaymentOrder findById(String id) {
		return repayRepository.findById(id);
	}
	
	
}
