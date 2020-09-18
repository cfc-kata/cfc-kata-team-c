package com.cfckata.loan;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import com.cfckata.common.ApiTest;
import com.cfckata.loan.request.LoanRequest;
import com.cfckata.loan.response.LoanCreateResponse;
import com.cfckata.loan.response.LoanResponse;

public class LoanControllerTest extends ApiTest {

    @Test
    @Sql(scripts = "classpath:sql/contract-test-before.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "classpath:sql/contract-test-after.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void loan_test() {
    	
        LoanRequest request = new LoanRequest("20200917000001",new BigDecimal(3000),12,
        		new BigDecimal(9.9),"放款卡号","还款卡号","DEBX");

        //When
        ResponseEntity<LoanCreateResponse> responseEntity = this.restTemplate.postForEntity(baseUrl + "/loan", request, LoanCreateResponse.class);

        //Then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        LoanCreateResponse order = responseEntity.getBody();
        assertThat(order.getLoanId()).isNotNull();
    }
    
    @Test
    public void getLoanInfo_test() {
        String orderId = "TEST_ORDER";
        ResponseEntity<LoanResponse> responseEntity = this.restTemplate.getForEntity(baseUrl + "/loan/" + orderId, LoanResponse.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }


}
