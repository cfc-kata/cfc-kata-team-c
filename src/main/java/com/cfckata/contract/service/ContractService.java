package com.cfckata.contract.service;

import com.cfckata.contract.enums.ContractStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cfckata.contract.ContractRepository;
import com.cfckata.contract.domain.Contract;
import com.cfckata.contract.request.ContractCreateReq;
import com.github.meixuesong.aggregatepersistence.AggregateFactory;

@Service
public class ContractService {
	@Autowired
	private ContractRepository contractRepository;

	/**
	 * 合同的创建 
	 * ContractReq是请求参数，需要转换成domain对象
	 * */
	public String create(ContractCreateReq contractCreateReq) {
		Contract contract =new Contract(contractCreateReq.getCustomerInfo(),contractCreateReq.getInterestRate(), contractCreateReq.getRepaymentType(), contractCreateReq.getMaturityDate(), contractCreateReq.getCommitment());
		try{
			contract.validate();
		}catch (Exception e){
			return null;
		}

		contract.setContractStatus(ContractStatusEnum.valid.name());

		contractRepository.save(AggregateFactory.createAggregate(contract));
		return contract.getContractId();
	}

	public Contract findById(String id) {
		return contractRepository.findById(id).getRoot();
	}
}
