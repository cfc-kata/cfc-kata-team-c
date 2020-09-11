package com.cfckata.contract.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author shuwei.dou
 * @description
 * @date 2020/9/11 11:15
 * @copyright (c) 2020
 */
@Data
public class ContractResp{
    private String contractId;

    public ContractResp(String contractId) {
        this.contractId = contractId;
    }
}
