package com.cfckata.loan.domain;

import java.math.BigDecimal;

import com.github.meixuesong.aggregatepersistence.Versionable;

import lombok.Data;

@Data
public class LoanRepaymentPlanDomain implements Versionable {

	private String planId;
    private String loanId;
    private Integer periodNo; //期号
    private String payableDate; //还款日期
    private BigDecimal payableAmount; //应还总额
    private BigDecimal payableInterest; //应还利息
    private BigDecimal payableCapital; //应还本金
    private BigDecimal remainCapital; //剩余本金
    private String status; //状态
    private String version;
    

	@Override
	public int getVersion() {
		// TODO Auto-generated method stub
		return 0;
	}


	

}
