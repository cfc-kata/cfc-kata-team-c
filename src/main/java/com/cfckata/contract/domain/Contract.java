package com.cfckata.contract.domain;

import java.io.Serializable;

import com.github.meixuesong.aggregatepersistence.Versionable;

/**
 * @author shuwei.dou
 * @description
 * @date 2020/9/11 11:11
 * @copyright (c) 2020
 */
public class Contract implements Versionable, Serializable {
  
	private static final long serialVersionUID = 1L;

	public ContractInfo contractVerification(ContractInfo contractInfo) {
		contractInfo.validate();
		return contractInfo;
		
	}

	@Override
	public int getVersion() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
