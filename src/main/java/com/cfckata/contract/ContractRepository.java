package com.cfckata.contract;

import java.math.BigDecimal;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Repository;

import com.cfckata.contract.dao.ContractDOMapper;
import com.cfckata.contract.dao.ContractDo;
import com.cfckata.contract.domain.ContractInfo;
import com.cfckata.contract.domain.Customer;
import com.cfckata.contract.enums.RepaymentTypeEnum;
import com.cfckata.contract.request.ContractReq;
import com.github.meixuesong.aggregatepersistence.Aggregate;
import com.github.meixuesong.aggregatepersistence.AggregateFactory;

@Repository
public class ContractRepository {
	
	private ContractDOMapper contractDOMapper;
	
	
	public Aggregate<ContractInfo> findById(String id) {
		// ContractDo contractDo = contractDOMapper.selectByPrimaryKey(id);
		ContractDo contractDo = getContractCreateInfo();
		/*
		 * if (contractDo == null) { throw new EntityNotFoundException("contractDo(" +
		 * id + ") not found"); }
		 */
		ContractInfo contractInfo = contractDo.toContract();
		return AggregateFactory.createAggregate(contractInfo);
	}
	   
	   private ContractDo getContractCreateInfo(){
		   ContractDo contractDo = new ContractDo();
	        Customer  customer = new Customer();
	        customer.setId("1");
	        customer.setIdNumber("410782199001011234");
	        customer.setMobilePhone("18911112222");
	        customer.setName("zhangsan");
	        contractDo.setContractId("11");
	        contractDo.setCustomerInfo(customer);
	        contractDo.setInterestRate(new BigDecimal("9.9"));
	        contractDo.setRepaymentType(RepaymentTypeEnum.DEBX.name());
	        contractDo.setMaturityDate("2022-05-01");
	        contractDo.setCommitment(new BigDecimal("9000.00"));
	        return contractDo;
	    }

}
