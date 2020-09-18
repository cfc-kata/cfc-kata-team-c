package com.cfckata.contract.domain;

import com.cfckata.common.ApiTest;
import com.cfckata.contract.enums.ContractStatusEnum;
import com.cfckata.contract.enums.RepaymentTypeEnum;
import com.cfckata.contract.request.ContractCreateReq;
import com.cfckata.contract.response.ContractCreateResp;
import com.cfckata.contract.response.ContractQueryResp;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;
import java.text.ParseException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author shuwei.dou
 * @description
 * @date 2020/9/11 10:59
 * @copyright (c) 2020
 */
public class ContractTest extends ApiTest {
    @Test
    public void validateTest(){
        Contract contract = getNewContract();
        try {
            contract.validate();
            contract.setContractStatus(ContractStatusEnum.valid.name());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertEquals(ContractStatusEnum.valid.name(), contract.getContractStatus());
    }

    private Contract getNewContract(){
        Contract contract = new Contract();
        Customer  customer = new Customer();
        customer.setId("1");
        customer.setIdNumber("410782199001011234");
        customer.setMobilePhone("18911112222");
        customer.setName("zhangsan");
        contract.setContractId("20200917000001");
        contract.setCustomerInfo(customer);
        contract.setInterestRate(new BigDecimal("9.9"));
        contract.setRepaymentType(RepaymentTypeEnum.DEBX.name());
        contract.setMaturityDate("2022-05-01");
        contract.setCommitment(new BigDecimal("9000.00"));
        return contract;
    }

    @Test
    public void validate_not_pass_test(){
        Contract contract = getNewContract();
        contract.setCommitment(new BigDecimal("300000.00"));
        try {
            contract.validate();
            contract.setContractStatus(ContractStatusEnum.valid.name());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            contract.setContractStatus(ContractStatusEnum.invalid.name());
        }
        assertEquals(ContractStatusEnum.invalid.name(), contract.getContractStatus());
    }
}
