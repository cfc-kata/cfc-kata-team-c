package com.cfckata.loan;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import com.cfckata.loan.domain.LoanDomain;
import com.cfckata.loan.domain.LoanRepaymentPlanDomain;
import com.cfckata.loan.util.PlanCreateUtil;

public class PlanCreateUtilTest {

    @Test
    public void should_create_debj_plan_success() {
    	LoanDomain loan = new LoanDomain();
    	loan.setLoanId("JJ0000001");
    	loan.setApplyAmount(new BigDecimal("1000"));
    	loan.setTotalMonth(12);
    	loan.setInterestRate(new BigDecimal(0.154));
    	List<LoanRepaymentPlanDomain> list = PlanCreateUtil.createPlanByDEBJ(loan);
        assertTrue(list.size()==12);
        BigDecimal amount = new BigDecimal(0);
        for(LoanRepaymentPlanDomain plan : list) {
        	amount = amount.add(plan.getPayableCapital());
        }
        assertTrue(new BigDecimal("1000").compareTo(amount)==0);
        
    }


}
