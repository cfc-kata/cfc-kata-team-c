package com.cfckata.repay;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import com.cfckata.common.ApiTest;
import com.cfckata.repay.request.RepaymentRequest;
import com.cfckata.repay.response.RepaymentResponse;

public class RepayControllerTest extends ApiTest {

    @Test
    public void createRepaymentOrderTest(){
        String url = baseUrl + "/repayments/repay/";
        ResponseEntity<RepaymentResponse> resp = this.restTemplate.postForEntity(url, getcreateRepaymentOrder(), RepaymentResponse.class);
        assertNotNull(resp);
    }

    @Test
    @Sql(scripts = "classpath:sql/repayment_order-test-before.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "classpath:sql/repayment_order-test-after.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void should_query_repayment() {
    	String url = baseUrl + "/repayments/";
    	
    	ResponseEntity<RepaymentResponse> resp = this.restTemplate.getForEntity(url+ "RP001", RepaymentResponse.class);
    	
    	assertNotNull(resp);
    	System.out.println(resp.getBody().getRepaymentId());
    	assertThat(resp.getStatusCode()).isEqualTo(HttpStatus.OK);
    	assertEquals("RP001", resp.getBody().getRepaymentId());
    }
    
    
    private RepaymentRequest getcreateRepaymentOrder() {
    	RepaymentRequest repaymentRequest = new RepaymentRequest();
    	repaymentRequest.setRepaymentPlanId("123456");
    	return repaymentRequest;
    	
    }
   
}
