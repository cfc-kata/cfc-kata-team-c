package com.cfckata.loan;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cfckata.loan.response.LoanRepaymentPlan;

@Service
public class LoanRepaymentPlanService {

	public List<LoanRepaymentPlan> findById(String id){
		List<LoanRepaymentPlan> planList = new ArrayList<LoanRepaymentPlan>();
		return planList;
	}
}
