package com.cfckata.contract.controller;

import com.cfckata.contract.domain.Contract;
import com.cfckata.contract.request.ContractCreateReq;
import com.cfckata.contract.response.ContractCreateResp;
import com.cfckata.contract.response.ContractQueryResp;
import com.cfckata.contract.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/create")
    public ContractCreateResp createContract(@RequestBody ContractCreateReq contractCreateReq){
        String contractId = contractService.create(contractCreateReq);
        return  new ContractCreateResp(contractId);
    }
    
    @GetMapping("/query/{contractId}")
    public ContractQueryResp findContract(@PathVariable String contractId) {
    	Contract contractInfo =contractService.findById(contractId);
    	return new ContractQueryResp(contractInfo);
    }

}
