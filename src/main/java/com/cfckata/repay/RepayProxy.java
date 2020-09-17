package com.cfckata.repay;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service
public class RepayProxy {

	/**
	 * 调用扣款接口进行扣款
	 * @param repaymnetId
	 * @param amount
	 * @param bankAccount
	 */
	public void repay(String repaymnetId, BigDecimal amount, String bankAccount){
        
    }
}
