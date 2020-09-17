package com.cfckata.loan;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cfckata.common.proxy.PayProxy;
import com.cfckata.loan.domain.LoanDomain;
import com.cfckata.loan.request.LoanRequest;
import com.github.meixuesong.aggregatepersistence.Aggregate;

@Service
public class LoanService {
	private LoanFactory loanFactory;
	private LoanRepository loanRepository;
	private PayProxy payProxy;

    public LoanService(LoanFactory loanFactory,LoanRepository loanRepository,PayProxy payProxy) {
		this.loanFactory = loanFactory;
		this.loanRepository = loanRepository;
		this.payProxy = payProxy;
	}

	@Transactional
	public LoanDomain createLoan(LoanRequest request) {
        Aggregate<LoanDomain> aggregate = loanFactory.createLoan(request);
        loanRepository.save(aggregate);
        payProxy.pay(aggregate.getRoot().getLoanId(), aggregate.getRoot().getApplyAmount());
        return aggregate.getRoot();
	}

	public LoanDomain getLoanInfo(String loanId) {
		Aggregate<LoanDomain> aggregate = loanRepository.findByLoanId(loanId);
        return aggregate.getRoot();
	}

}
