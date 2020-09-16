package com.cfckata.loan;

import org.springframework.stereotype.Service;

import com.cfckata.contract.ContractRepository;
import com.cfckata.loan.domain.LoanDomain;
import com.cfckata.loan.request.LoanRequest;
import com.github.meixuesong.aggregatepersistence.Aggregate;
import com.github.meixuesong.aggregatepersistence.AggregateFactory;

@Service
public class LoanFactory {
    private ContractRepository contractRepository;

    public LoanFactory( ContractRepository contractRepository) {
		this.contractRepository = contractRepository;
	}

	public Aggregate<LoanDomain> createLoan(LoanRequest request) {
        if (contractRepository.findById(request.getContractId()) == null) {
            throw new IllegalArgumentException("Custract not exists.");
        }

        LoanDomain loan = new LoanDomain();
        loan.setApplyAmount(request.getApplyAmount());
        loan.setContractId(request.getContractId());
        loan.setInterestRate(request.getInterestRate());
        loan.setRepaymentBankAccount(request.getRepaymentBankAccount());
        loan.setRepaymentType(request.getRepaymentType());
        loan.setTotalMonth(request.getTotalMonth());
        
        loan.createLoan();

        return AggregateFactory.createAggregate(loan);
    }


}
