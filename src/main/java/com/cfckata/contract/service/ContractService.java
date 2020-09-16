package com.cfckata.contract.service;

import org.springframework.stereotype.Service;

import com.cfckata.contract.ContractRepository;
import com.cfckata.contract.domain.Contract;
import com.cfckata.contract.domain.ContractInfo;
import com.cfckata.contract.domain.Customer;
import com.cfckata.contract.request.ContractReq;
import com.github.meixuesong.aggregatepersistence.Aggregate;
import com.github.meixuesong.aggregatepersistence.AggregateFactory;

@Service
public class ContractService {
	private ContractRepository contractRepository;
	
	public ContractService(ContractRepository contractRepository) {
		this.contractRepository = contractRepository;
	}
	
	/**
	 * 合同的创建 
	 * ContractReq是请求参数，需要转换成domain对象
	 * */
	public String create(ContractReq contractReq) {
		
		ContractInfo contractInfo =new ContractInfo(contractReq.getCustomerInfo(), contractReq.getContractId(), contractReq.getInterestRate(), contractReq.getRepaymentType(), contractReq.getMaturityDate(), contractReq.getCommitment(), 0);
		Contract contract = new Contract();
		contract.contractVerification(contractInfo);
		contractRepository.save(AggregateFactory.createAggregate(contractInfo));
		return contractInfo.getContractId();
		
	}
	

	public ContractInfo findById(String id) {
		Aggregate<ContractInfo> contractInfoAggregate = contractRepository.findById(id);
		return contractInfoAggregate.getRoot();
	}
}
