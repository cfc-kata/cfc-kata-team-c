package com.cfckata.repay;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.http.ResponseEntity;

import com.cfckata.common.ApiTest;
import com.cfckata.repay.request.RepaymentRequest;
import com.cfckata.repay.response.RepaymentResponse;

public class RepayControllerTest extends ApiTest {

    @Test
    public void createRepaymentOrderTest(){
        String url = baseUrl + "/repayments/";
        ResponseEntity<RepaymentResponse> resp = this.restTemplate.postForEntity(url, getcreateRepaymentOrder(), RepaymentResponse.class);
        assertNotNull(resp);
    }

    private RepaymentRequest getcreateRepaymentOrder() {
    	RepaymentRequest repaymentRequest = new RepaymentRequest();
    	repaymentRequest.setRepaymentPlanId("123456");
    	return repaymentRequest;
    	
    }
   
}
