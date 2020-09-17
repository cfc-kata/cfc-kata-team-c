package com.cfckata.loan.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.cfckata.loan.util.PlanCreateUtil;
import com.cfckata.util.UuidUtil;
import com.github.meixuesong.aggregatepersistence.Versionable;

import lombok.Data;

@Data
public class LoanDomain implements Versionable {

    private String loanId;
    private String contractId;
    private BigDecimal applyAmount;
    private Integer totalMonth;
    private BigDecimal interestRate;
    private String withdrawBankAccount;
    private String repaymentBankAccount;
    private String repaymentType;
    private String version;
    private List<LoanRepaymentPlanDomain> list;

	@Override
	public int getVersion() {
		return 0;
	}

	/**
	 * 生成借据及还款计划
	 */
	public void createLoan() {
		loanId = UuidUtil.getUuid();
		list = PlanCreateUtil.createPlan(this);
	}


}
