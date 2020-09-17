package com.cfckata.repay;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import com.cfckata.common.ApiTest;
import com.cfckata.loan.LoanRepository;
import com.cfckata.loan.domain.LoanRepaymentPlanDomain;
import com.cfckata.repay.request.RepaymentRequest;
import com.cfckata.repay.response.RepaymentResponse;

public class RepayControllerTest extends ApiTest {

	
    @MockBean
    private LoanRepository loanRepository;
    
//    @MockBean
//    RepayRepository repayRepository;
    
    @MockBean
    RepayProxy repayProxy;

    @Override
    @BeforeEach
    public void setUp() throws Exception {
        super.setUp();
        LoanRepaymentPlanDomain planDomain = new LoanRepaymentPlanDomain();
        planDomain.setPlanId("123456");
        planDomain.setPayableAmount(new BigDecimal("666.66"));
        planDomain.setLoanId("IOU001");
        when(loanRepository.getLoanRepaymentPlanDomainById(anyString())).thenAnswer(new Answer(){
        	public Object answer(InvocationOnMock invocation) {
        			return planDomain;
        		}
        });
        
        doNothing().when(repayProxy).repay(anyString(), any(), anyString());
        //doNothing().when(repayRepository).save(any());
    }


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
    	assertThat(resp.getStatusCode()).isEqualTo(HttpStatus.OK);
    	assertEquals("RP001", resp.getBody().getRepaymentId());
    }
    
    
    private RepaymentRequest getcreateRepaymentOrder() {
    	RepaymentRequest repaymentRequest = new RepaymentRequest();
    	repaymentRequest.setRepaymentPlanId("123456");
    	repaymentRequest.setRepaymentBankAccount("HKK001");
    	return repaymentRequest;
    	
    }
   
}
