package com.cfckata.repay;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cfckata.repay.request.RepaymentRequest;
import com.cfckata.repay.response.RepaymentResponse;

@RestController
@RequestMapping("/repayments")
public class RepayController {

	
	@RequestMapping(value = "/",method = RequestMethod.POST)
    public RepaymentResponse createRepaymentOrder(@RequestBody RepaymentRequest repaymentRequest){
		
		RepaymentResponse respon = new RepaymentResponse();
		respon.setRepaymntId("0987");
		respon.setCreateTime(new Date());
		respon.setRepaymentPlanId(repaymentRequest.getRepaymentPlanId());
		respon.setRepaymentBankAccount("还款卡号：98765");
		respon.setAmount(new BigDecimal("666"));
		//TODO 查询还款计划明细信息，获取还款金额
		
        return respon;
    }
	
	
}
