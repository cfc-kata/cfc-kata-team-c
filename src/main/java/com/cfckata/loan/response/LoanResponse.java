package com.cfckata.loan.response;


import com.cfckata.loan.domain.LoanOrder;

public class LoanResponse {
    private String loanId;

    public LoanResponse() {
    }

    public LoanResponse(LoanOrder loanOrder) {
    	loanId = loanOrder.getLoanId();
    }

	public String getLoanId() {
		return loanId;
	}

	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}
    

}
