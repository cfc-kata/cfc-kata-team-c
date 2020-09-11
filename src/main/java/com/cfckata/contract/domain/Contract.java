package com.cfckata.contract.domain;

import com.cfckata.contract.request.ContractReq;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @author shuwei.dou
 * @description
 * @date 2020/9/11 11:11
 * @copyright (c) 2020
 */
@Data
@Service
public class Contract implements Serializable {
    public String create(ContractReq contractReq){
        return "aa";
    }
}
