package com.cfckata.loan;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cfckata.loan.domain.LoanDomain;
import com.cfckata.loan.request.LoanRequest;
import com.github.meixuesong.aggregatepersistence.Aggregate;

@Service
public class LoanService {
	private LoanFactory loanFactory;
	private LoanRepository loanRepository;

    public LoanService(LoanFactory loanFactory,LoanRepository loanRepository) {
		this.loanFactory = loanFactory;
		this.loanRepository = loanRepository;
	}


	@Transactional
	public LoanDomain createLoan(LoanRequest request) {
        Aggregate<LoanDomain> aggregate = loanFactory.createLoan(request);
        loanRepository.save(aggregate);
        Aggregate<LoanDomain> orderAggregate = loanRepository.findByLoanId(aggregate.getRoot().getLoanId());
        return orderAggregate.getRoot();
	}
	

}
