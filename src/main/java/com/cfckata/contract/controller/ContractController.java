package com.cfckata.contract.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cfckata.contract.domain.Contract;
import com.cfckata.contract.domain.ContractInfo;
import com.cfckata.contract.request.ContractReq;
import com.cfckata.contract.response.ContractInfoResp;
import com.cfckata.contract.response.ContractResp;
import com.cfckata.contract.service.ContractService;

/**
 * @author shuwei.dou
 * @description
 * @date 2020/9/11 11:12
 * @copyright (c) 2020
 */
@RestController
@RequestMapping("/contract")
public class ContractController {
    
    @Autowired
    private ContractService contractService;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public ContractResp createContract(@RequestBody ContractReq contractReq){
        String contractId = contractService.create(contractReq);
        return  new ContractResp(contractId);
    }
    
    @GetMapping("/{contractId}")
    public ContractInfoResp findContract(@PathVariable String contractId) {
    	ContractInfo contractInfo =contractService.findById(contractId);
    	return new ContractInfoResp(contractInfo);
    }

	}
