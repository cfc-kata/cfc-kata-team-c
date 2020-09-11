package com.cfckata.loan.domain;

import java.math.BigDecimal;

import com.github.meixuesong.aggregatepersistence.Versionable;

import lombok.Data;

@Data
public class LoanRepaymentPlanDomain implements Versionable {

    private String loanId;
    private String contractId;
    private BigDecimal applyAmount;
    private Integer totalMonth;
    private BigDecimal interestRate;
    private String withdrawBankAccount;
    private String repaymentBankAccount;
    private String repaymentType;

	@Override
	public int getVersion() {
		// TODO Auto-generated method stub
		return 0;
	}


	

}
