package com.cfckata.contract.service;

import org.springframework.stereotype.Service;

import com.cfckata.contract.ContractRepository;
import com.cfckata.contract.domain.ContractInfo;
import com.github.meixuesong.aggregatepersistence.Aggregate;

@Service
public class ContractService {
	private ContractRepository contractRepository;
	public ContractService(ContractRepository contractRepository) {
		this.contractRepository = contractRepository;
	}

	public ContractInfo findById(String id) {
		Aggregate<ContractInfo> contractInfoAggregate = contractRepository.findById(id);
		return contractInfoAggregate.getRoot();
	}
}
