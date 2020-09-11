package com.cfckata.loan.response;


import com.cfckata.loan.domain.LoanOrder;

public class LoanCreateResponse {
    private String loanId;

    public LoanCreateResponse() {
    }

    public LoanCreateResponse(LoanOrder loanOrder) {
    	loanId = loanOrder.getLoanId();
    }

	public String getLoanId() {
		return loanId;
	}

	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}
    

}
