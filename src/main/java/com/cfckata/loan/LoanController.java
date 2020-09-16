package com.cfckata.loan;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cfckata.loan.domain.LoanDomain;
import com.cfckata.loan.request.LoanRequest;
import com.cfckata.loan.response.LoanCreateResponse;
import com.cfckata.loan.response.LoanResponse;

@RestController
@RequestMapping("/loan")
public class LoanController {

    private LoanService loanService;

    public LoanController(LoanService loanService) {
		this.loanService = loanService;
	}

	@PostMapping
    @ResponseStatus(HttpStatus.OK)
    public LoanCreateResponse loanCreate(@RequestBody LoanRequest request) {
		LoanDomain salesOrder = loanService.createLoan(request);
        return new LoanCreateResponse(salesOrder);
    }
    
    @GetMapping("/{id}")
    public LoanResponse getLoanInfo(@PathVariable String id) {

        return new LoanResponse();
    }

}
