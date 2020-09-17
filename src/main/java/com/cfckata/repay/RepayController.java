package com.cfckata.repay;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cfckata.repay.domain.RepaymentOrder;
import com.cfckata.repay.request.RepaymentRequest;
import com.cfckata.repay.response.RepaymentResponse;

@RestController
@RequestMapping("/repayments")
public class RepayController {

	private  RepayService repayService;
	
	public RepayController(RepayService repayService) {
		this.repayService = repayService;
	}
	
	/**
	 * 选定还款期数进行还款
	 * @param repaymentPlanId
	 * @return
	 */
	@RequestMapping(value = "/repay/",method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
    public RepaymentResponse createRepaymentOrder(@RequestBody RepaymentRequest request){
		
//		RepaymentResponse respon = new RepaymentResponse();
//		respon.setRepaymentId("0987");
//		respon.setCreateTime(new Date());
//		respon.setRepaymentPlanId(request.getRepaymentPlanId());
//		respon.setRepaymentBankAccount("还款卡号：98765");
//		respon.setAmount(new BigDecimal("666"));
		RepaymentOrder repaymentOrder = repayService.createRepaymentOrder(request);
		
        return new RepaymentResponse(repaymentOrder);
    }
	
	
	/**
	 * 选定还款期数进行还款
	 * @param repaymentPlanId
	 * @return
	 */
	@GetMapping(value = "/{repaymentId}")
	@ResponseStatus(HttpStatus.OK)
    public RepaymentResponse findByRrepaymentPlanId(@PathVariable String repaymentId){
		RepaymentOrder repaymentOrder = repayService.findById(repaymentId);
		return new RepaymentResponse(repaymentOrder);
	}
	
	
	
}
