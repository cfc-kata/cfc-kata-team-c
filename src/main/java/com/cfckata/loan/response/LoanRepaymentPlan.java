package com.cfckata.loan.response;


import java.math.BigDecimal;

import com.cfckata.loan.domain.LoanOrder;

import lombok.Data;

@Data
public class LoanRepaymentPlan {
    private String loanId;
    private String contractId;
    private BigDecimal applyAmount;
    private Integer totalMonth;
    private BigDecimal interestRate;
    private String withdrawBankAccount;
    private String repaymentBankAccount;
    private String repaymentType;

    public LoanRepaymentPlan() {
    }

}
