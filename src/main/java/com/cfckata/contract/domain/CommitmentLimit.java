package com.cfckata.contract.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class CommitmentLimit implements Serializable {
    private static final long serialVersionUID = -3458646775631311880L;
    private  int ageFrom;
    private  int ageTo;
    private  BigDecimal maxCommitment;

    public CommitmentLimit() {
    }

    public CommitmentLimit(int ageFrom, int ageTo, BigDecimal maxCommitment) {
        this.ageFrom = ageFrom;
        this.ageTo = ageTo;
        this.maxCommitment = maxCommitment;
    }

    public int getAgeFrom() {
        return ageFrom;
    }

    public void setAgeFrom(int ageFrom) {
        this.ageFrom = ageFrom;
    }

    public int getAgeTo() {
        return ageTo;
    }

    public void setAgeTo(int ageTo) {
        this.ageTo = ageTo;
    }

    public BigDecimal getMaxCommitment() {
        return maxCommitment;
    }

    public void setMaxCommitment(BigDecimal maxCommitment) {
        this.maxCommitment = maxCommitment;
    }
}
