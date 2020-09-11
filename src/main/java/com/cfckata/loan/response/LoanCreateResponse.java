package com.cfckata.loan.response;


import com.cfckata.loan.domain.LoanDomain;

public class LoanCreateResponse {
    private String loanId;

    public LoanCreateResponse() {
    }

    public LoanCreateResponse(LoanDomain LoanDomain) {
    	loanId = LoanDomain.getLoanId();
    }

	public String getLoanId() {
		return loanId;
	}

	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}
    

}
