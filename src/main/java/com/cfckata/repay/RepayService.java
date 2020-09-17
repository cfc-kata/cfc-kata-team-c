package com.cfckata.repay;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cfckata.loan.LoanRepaymentPlanService;
import com.cfckata.loan.LoanRepository;
import com.cfckata.loan.domain.LoanDomain;
import com.cfckata.loan.domain.LoanRepaymentPlanDomain;
import com.cfckata.repay.domain.RepaymentOrder;
import com.cfckata.repay.request.RepaymentRequest;
import com.github.meixuesong.aggregatepersistence.Aggregate;

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
    private RepayProxy repayProxy;
    
    public RepayService(RepayRepository repayRepository, RepayFactory repayFactory, LoanRepository loanRepository, RepayProxy repayProxy) {
		this.repayRepository = repayRepository;
		this.repayFactory = repayFactory;
		this.loanRepository = loanRepository;
		this.repayProxy = repayProxy;
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
		return createRepaymentOrder(planDomain, request.getRepaymentBankAccount());
	}
	
	public List<RepaymentOrder> createRepaymentOrderForBatch(String curDt){
		List<LoanRepaymentPlanDomain> plans = loanRepository.getLoanRepaymentPlanDomainListByDt(curDt);
		List<RepaymentOrder> orderList = new ArrayList<RepaymentOrder>();
		for(LoanRepaymentPlanDomain doplan : plans) {
			RepaymentOrder order = createRepaymentOrder(doplan, "");
			orderList.add(order);
		}
		return orderList;
	}
	
	
	public RepaymentOrder createRepaymentOrder(LoanRepaymentPlanDomain planDomain, String repaymentBankAccount) {
		
		if(null==repaymentBankAccount || "".equals(repaymentBankAccount)) {
			Aggregate<LoanDomain> aggregate = loanRepository.findByLoanId(planDomain.getLoanId());
			repaymentBankAccount = aggregate.getRoot().getRepaymentBankAccount();
		}
		RepaymentOrder repayOrder = repayFactory.createReapyOrder(planDomain, repaymentBankAccount);
		repayProxy.repay(repayOrder.getRepaymentId(), repayOrder.getAmount(), repayOrder.getRepaymentBankAccount());
		repayOrder.setRepaySts("01");
		return repayOrder;
	}
	
}
