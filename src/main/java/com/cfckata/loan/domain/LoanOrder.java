package com.cfckata.loan.domain;

import com.github.meixuesong.aggregatepersistence.Versionable;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class LoanOrder implements Versionable {
    private String loanId;

	@Override
	public int getVersion() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getLoanId() {
		return loanId;
	}

	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}
	

}
