package com.cfckata.contract;

import com.cfckata.common.ApiTest;
import com.cfckata.contract.domain.Customer;
import com.cfckata.contract.enums.RepaymentTypeEnum;
import com.cfckata.contract.request.ContractCreateReq;
import com.cfckata.contract.response.ContractCreateResp;
import com.cfckata.contract.response.ContractQueryResp;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

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
        ResponseEntity<ContractCreateResp> resp = this.restTemplate.postForEntity(url, getContractCreateReq(), ContractCreateResp.class);
        assertNotNull(resp);
        assertNotNull(resp.getBody());
        assertNotNull(resp.getBody().getContractId());
    }

    private ContractCreateReq getContractCreateReq(){
        ContractCreateReq contractCreateReq = new ContractCreateReq();
        Customer  customer = new Customer();
        customer.setId("1");
        customer.setIdNumber("410782199001011234");
        customer.setMobilePhone("18911112222");
        customer.setName("zhangsan");
        contractCreateReq.setContractId("333");
        contractCreateReq.setCustomerInfo(customer);
        contractCreateReq.setInterestRate(new BigDecimal("9.9"));
        contractCreateReq.setRepaymentType(RepaymentTypeEnum.DEBX.name());
        contractCreateReq.setMaturityDate("2022-05-01");
        contractCreateReq.setCommitment(new BigDecimal("9000.00"));
        return contractCreateReq;
    }
    

    @Test
    @Sql(scripts = "classpath:sql/contract-test-before.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "classpath:sql/contract-test-after.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void queryContractTest() {
        String contractId = "11";
        ResponseEntity<ContractQueryResp> responseEntity = this.restTemplate.getForEntity(baseUrl + "/contract/" + contractId, ContractQueryResp.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        ContractQueryResp contract = responseEntity.getBody();
        assertThat(contract.getContractId()).isEqualTo(contractId);
    }
    
    
}
