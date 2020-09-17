package com.cfckata.repay;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cfckata.common.SpringServiceTest;
import com.cfckata.loan.LoanRepository;
import com.cfckata.loan.domain.LoanDomain;
import com.cfckata.loan.domain.LoanRepaymentPlanDomain;
import com.cfckata.repay.domain.RepaymentOrder;
import com.github.meixuesong.aggregatepersistence.Aggregate;
import com.github.meixuesong.aggregatepersistence.AggregateFactory;

public class RepayServiceTest extends SpringServiceTest{

	@Autowired
	private RepayService repayService;

	@MockBean
	LoanRepository loanRepository;

	@BeforeEach
	public void setUp() throws Exception {
		LoanRepaymentPlanDomain planDomain = new LoanRepaymentPlanDomain();
		planDomain.setPlanId("123456");
		planDomain.setPayableAmount(new BigDecimal("666.66"));
		planDomain.setLoanId("IOU001");
		List<LoanRepaymentPlanDomain> planDomainList = new ArrayList<LoanRepaymentPlanDomain>();
		planDomainList.add(planDomain);
		
		when(loanRepository.getLoanRepaymentPlanDomainListByDt(anyString())).thenAnswer(new Answer() {
			public Object answer(InvocationOnMock invocation) {
				return planDomainList;
			}
		});

		LoanDomain loan = new LoanDomain();
		loan.setLoanId("IOU001");
		loan.setRepaymentBankAccount("123456");
		Aggregate<LoanDomain> aggre = AggregateFactory.createAggregate(loan);
		 
		when(loanRepository.findByLoanId(anyString())).thenAnswer(new Answer() {
			public Object answer(InvocationOnMock invocation) {
				return aggre;
			}
		});
	}

	@Test
	void should_create_batch_repay() {
		List<RepaymentOrder> orderList = repayService.createRepaymentOrderForBatch("2020-09-17");
		assertNotNull(orderList);
    	assertEquals(1, orderList.size());
	}
}
