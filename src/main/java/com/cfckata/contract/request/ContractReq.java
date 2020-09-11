package com.cfckata.contract.request;

import com.cfckata.contract.domain.Customer;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author shuwei.dou
 * @description
 * @date 2020/9/11 11:04
 * @copyright (c) 2020
 */
@Data
public class ContractReq implements Serializable {
    private Customer customerInfo;
    private BigDecimal interestRate;
    private String repaymentType;
    private String maturityDate;
    private BigDecimal commitment;
}