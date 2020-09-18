package com.cfckata.contract;

import java.math.BigDecimal;
import java.util.Date;

import com.cfckata.contract.dao.ContractDoMapper;
import org.springframework.stereotype.Repository;

import com.cfckata.contract.dao.ContractDo;
import com.cfckata.contract.domain.Contract;
import com.cfckata.contract.domain.Customer;
import com.cfckata.contract.enums.RepaymentTypeEnum;
import com.github.meixuesong.aggregatepersistence.Aggregate;
import com.github.meixuesong.aggregatepersistence.AggregateFactory;

import javax.persistence.OptimisticLockException;

@Repository
public class ContractRepository {
	private ContractDoMapper contractDoMapper;

	public ContractRepository(ContractDoMapper contractDoMapper) {
		this.contractDoMapper = contractDoMapper;
	}

	public Aggregate<Contract> findById(String id) {
		ContractDo contractDo = contractDoMapper.selectByPrimaryKey(id);
		Contract contract = contractDo.toContract();
		return AggregateFactory.createAggregate(contract);
	}

	public void save(Aggregate<Contract> aggregate) {
		contractDoMapper.insert(contractToDo(aggregate.getRoot()));
	}

	private ContractDo contractToDo(Contract contract) {
		ContractDo contractDo = new ContractDo();
		contractDo.setId(contract.getContractId());
		contractDo.setCreateTime(new Date());
		contractDo.setCommitment(contract.getCommitment());
		contractDo.setCustomerId(contract.getCustomerInfo().getId());
		contractDo.setCustomerName(contract.getCustomerInfo().getName());
		contractDo.setCustomerIdNumber(contract.getCustomerInfo().getIdNumber());
		contractDo.setCustomerMobilePhone(contract.getCustomerInfo().getMobilePhone());
		contractDo.setInterestRate(contract.getInterestRate());
		contractDo.setMaturityDate(contract.getMaturityDate());
		contractDo.setRepaymentType(contract.getRepaymentType());
		contractDo.setStatus(contract.getContractStatus());
		contractDo.setVersion(contract.getVersion());
		return contractDo;
	}    
}
