package com.cfckata.contract.controller;

import com.cfckata.contract.domain.Contract;
import com.cfckata.contract.request.ContractReq;
import com.cfckata.contract.response.ContractResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    Contract contract;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public ContractResp createContract(@RequestBody ContractReq contractReq){
        String contractId = contract.create(contractReq);
        return  new ContractResp(contractId);
    }
}
