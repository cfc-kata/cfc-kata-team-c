package com.cfckata.contract.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author shuwei.dou
 * @description
 * @date 2020/9/11 11:15
 * @copyright (c) 2020
 */
public class ContractCreateResp {
    private String contractId;
    
    public ContractCreateResp() {
    }

    public ContractCreateResp(String contractId) {
        this.contractId = contractId;
    }

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
    
}
