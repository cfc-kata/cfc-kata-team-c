package com.cfckata.loan.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

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
    private List<LoanRepaymentPlanDomain> list;

	@Override
	public int getVersion() {
		return 0;
	}


}
