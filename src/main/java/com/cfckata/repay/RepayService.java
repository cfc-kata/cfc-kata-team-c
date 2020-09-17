package com.cfckata.repay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cfckata.loan.LoanRepaymentPlanService;
import com.cfckata.loan.LoanRepository;
import com.cfckata.loan.domain.LoanRepaymentPlanDomain;
import com.cfckata.repay.domain.RepaymentOrder;
import com.cfckata.repay.request.RepaymentRequest;

/**
 * 还款的service
 * @author menglei
 *
 */
@Service
public class RepayService {
	private RepayRepository repayRepository;
    private RepayFactory repayFactory;
    private LoanRepository loanRepository;
    
    public RepayService(RepayRepository repayRepository, RepayFactory repayFactory, LoanRepository loanRepository) {
		this.repayRepository = repayRepository;
		this.repayFactory = repayFactory;
		this.loanRepository = loanRepository;
	}

	@Autowired 
	LoanRepaymentPlanService loanRepaymentPlanService;
	
	public RepaymentOrder findById(String id) {
		return repayRepository.findById(id);
	}
	
	/**
	 * 获取可以还款的金额
	 * @param planId
	 * @return
	 */
	public LoanRepaymentPlanDomain getRepayPlan(String planId) {
		LoanRepaymentPlanDomain planDomain = loanRepository.getLoanRepaymentPlanDomainById(planId);
		return planDomain;
	}
	
	
	public RepaymentOrder createRepaymentOrder(RepaymentRequest request) {
		LoanRepaymentPlanDomain planDomain = getRepayPlan(request.getRepaymentPlanId());
		RepaymentOrder repayOrder = repayFactory.createReapyOrder(planDomain, request.getRepaymentBankAccount());
		return repayOrder;
		
	}
	
}
