package com.cfckata.loan;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cfckata.loan.request.LoanRequest;
import com.cfckata.loan.response.LoanResponse;

@RestController
@RequestMapping("/loan")
public class LoanController {

    private LoanService loanService;


    @PostMapping("/loans")
    @ResponseStatus(HttpStatus.OK)
    public LoanResponse loan(@RequestBody LoanRequest request) {
    	LoanResponse res = new LoanResponse();
    	res.setLoanId(UUID.randomUUID().toString().replace("-", ""));
        return res;
    }

}
