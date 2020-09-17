package com.cfckata.loan.response;


import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

import com.cfckata.loan.domain.LoanRepaymentPlanDomain;

import lombok.Data;

@Data
public class LoanRepaymentPlan {

    private Integer periodNo; //期号
    private String payableDate; //还款日期
    private BigDecimal payableAmount; //应还总额
    private BigDecimal payableInterest; //应还利息
    private BigDecimal payableCapital; //应还本金
    private BigDecimal remainCapital; //剩余本金
    private String status; //状态
    private String version;

    public LoanRepaymentPlan() {
    }
    public LoanRepaymentPlan(LoanRepaymentPlanDomain repaymentPlan) {
        this.periodNo = repaymentPlan.getPeriodNo();
        this.payableDate = repaymentPlan.getPayableDate();
        this.payableAmount = repaymentPlan.getPayableAmount();
        this.payableInterest = repaymentPlan.getPayableInterest();
        this.payableCapital = repaymentPlan.getPayableCapital();
        this.status = repaymentPlan.getStatus();
    }
}
