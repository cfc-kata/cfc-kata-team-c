package com.cfckata.contract.repository;

import com.cfckata.common.ApiTest;
import com.cfckata.contract.ContractRepository;
import com.cfckata.contract.domain.Contract;
import com.cfckata.contract.domain.Customer;
import com.cfckata.contract.enums.ContractStatusEnum;
import com.cfckata.contract.enums.RepaymentTypeEnum;
import com.github.meixuesong.aggregatepersistence.AggregateFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.text.ParseException;

import static org.junit.Assert.assertEquals;

/**
 * @author shuwei.dou
 * @description
 * @date 2020/9/11 10:59
 * @copyright (c) 2020
 */
public class ContractRepositoryTest extends ApiTest {
    @Autowired
    ContractRepository contractRepository;
    @Test
    public void saveTest(){
        Contract contract = getNewContract();
        contractRepository.save(AggregateFactory.createAggregate(contract));
        Contract result = contractRepository.findById(contract.getContractId()).getRoot();

    }

    private Contract getNewContract(){
        Contract contract = new Contract();
        Customer  customer = new Customer();
        customer.setId("1");
        customer.setIdNumber("410782199001011234");
        customer.setMobilePhone("18911112222");
        customer.setName("zhangsan");
        contract.setContractId("20200917000003");
        contract.setCustomerInfo(customer);
        contract.setInterestRate(new BigDecimal("9.9"));
        contract.setRepaymentType(RepaymentTypeEnum.DEBX.name());
        contract.setMaturityDate("2022-05-01");
        contract.setCommitment(new BigDecimal("9000.00"));
        contract.setContractStatus(ContractStatusEnum.valid.name());
        return contract;
    }

    @Test
    public void findByIdTest(){
        Contract contract = getNewContract();
        contract.setContractId("20200917000005");
        contractRepository.save(AggregateFactory.createAggregate(contract));
        Contract result = contractRepository.findById(contract.getContractId()).getRoot();
        assertEquals(contract.getContractId(), result.getContractId());
    }
}
