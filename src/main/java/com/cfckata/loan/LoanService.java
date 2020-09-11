package com.cfckata.loan;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cfckata.loan.domain.LoanDomain;
import com.cfckata.loan.request.LoanRequest;

@Service
public class LoanService {

    @Transactional
	public LoanDomain createOrder(LoanRequest request) {
        return new LoanDomain();
	}
	

}
