package com.cfckata.loan.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cfckata.enums.RepaymengTypeEnum;
import com.cfckata.loan.domain.LoanDomain;
import com.cfckata.loan.domain.LoanRepaymentPlanDomain;
import com.cfckata.util.DateUtils;
import com.cfckata.util.UuidUtil;

public class PlanCreateUtil {
	
	public static List<LoanRepaymentPlanDomain> createPlan(LoanDomain loanDomain){
		List<LoanRepaymentPlanDomain> list = new ArrayList();
		if(loanDomain == null) {
			return list;
		}
		// 暂只支持等额本金
		if(RepaymengTypeEnum.DEBJ.getCode().equals(loanDomain.getRepaymentType())) {
			list = createPlanByDEBJ(loanDomain);
		}
		return list;
	}

	private static List<LoanRepaymentPlanDomain> createPlanByDEBJ(LoanDomain loanDomain) {
		List<LoanRepaymentPlanDomain> list = new ArrayList();
		for(int i=1;i<=loanDomain.getTotalMonth();i++) {
			LoanRepaymentPlanDomain plan = new LoanRepaymentPlanDomain();
			plan.setLoanId(loanDomain.getLoanId());
			plan.setPlanId(UuidUtil.getUuid());
			plan.setPeriodNo(i);
			BigDecimal payableCapital = getPerMonthPrincipal(loanDomain.getApplyAmount(),loanDomain.getTotalMonth());
			// 应还本金
			if(i==loanDomain.getTotalMonth().intValue()) {
				plan.setPayableCapital(loanDomain.getApplyAmount().subtract(payableCapital.multiply(new BigDecimal(loanDomain.getTotalMonth()-1))));
			}else {
				plan.setPayableCapital(payableCapital);
			}
			// 剩余本金
			plan.setRemainCapital(loanDomain.getApplyAmount().subtract(payableCapital.multiply(new BigDecimal(i-1))));
			// 应还利息=剩余本金*年利率/12
			BigDecimal mounthRate = loanDomain.getInterestRate().divide(new BigDecimal(12)).setScale(9, BigDecimal.ROUND_DOWN);
			plan.setPayableInterest(plan.getRemainCapital().multiply(mounthRate).setScale(2, BigDecimal.ROUND_DOWN) );
			// 应还总额
			plan.setPayableAmount(plan.getPayableCapital().add(plan.getPayableInterest()));
			// 应还日期
			plan.setPayableDate(DateUtils.dateToString(DateUtils.addTime("04", i), DateUtils.PATTERN_ISO_ON_DATE));
			list.add(plan);
		}
		return list;
	}

    /**
     * 等额本金计算获取还款方式为等额本金的每月偿还本金
     * 公式：每月应还本金=贷款本金÷还款月数
     */
    public static BigDecimal getPerMonthPrincipal(BigDecimal invest, int totalMonth) {
    	return invest.divide(new BigDecimal(totalMonth), 2, BigDecimal.ROUND_DOWN);
    }
 
}
