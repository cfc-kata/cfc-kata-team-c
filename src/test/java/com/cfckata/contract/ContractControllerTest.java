package com.cfckata.contract;

import com.cfckata.common.ApiTest;
import com.cfckata.contract.domain.Customer;
import com.cfckata.contract.enums.RepaymentTypeEnum;
import com.cfckata.contract.request.ContractReq;
import com.cfckata.contract.response.ContractResp;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author shuwei.dou
 * @description
 * @date 2020/9/11 10:59
 * @copyright (c) 2020
 */
public class ContractControllerTest extends ApiTest {

    @Test
    public void createContractTest(){
        String url = baseUrl + "/contract/create";
        ResponseEntity<ContractResp> resp = this.restTemplate.postForEntity(url, getContractCreateReq(), ContractResp.class);
        assertNotNull(resp);
        assertNotNull(resp.getBody());
        assertNotNull(resp.getBody().getContractId());
        System.out.println("contractId=========="+resp.getBody().getContractId());
    }

    private ContractReq getContractCreateReq(){
        ContractReq contractReq = new ContractReq();
        Customer  customer = new Customer();
        customer.setId("1");
        customer.setIdNumber("410782199001011234");
        customer.setMobilePhone("18911112222");
        customer.setName("zhangsan");
        contractReq.setCustomerInfo(customer);
        contractReq.setInterestRate(new BigDecimal("9.9"));
        contractReq.setRepaymentType(RepaymentTypeEnum.DEBX.name());
        contractReq.setMaturityDate("2022-05-01");
        contractReq.setCommitment(new BigDecimal("9000.00"));
        return contractReq;
    }
}
