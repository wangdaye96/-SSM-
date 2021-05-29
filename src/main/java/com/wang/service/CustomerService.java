package com.wang.service;

import com.wang.pojo.Customer;
import com.wang.pojo.CustomerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerService {
    long countByExample(CustomerExample example);

    int deleteByExample(CustomerExample example);

    int deleteByPrimaryKey(Integer custId);

    int insert(Customer record);

    int insertSelective(Customer record);

    List<Customer> selectByExample(CustomerExample example);

    Customer selectByPrimaryKey(Integer custId);

    int updateByExampleSelective(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByExample(@Param("record") Customer record, @Param("example") CustomerExample example);

    boolean updateByPrimaryKeySelective(Customer record);

    boolean updateByPrimaryKey(Customer record);

    List<Customer> getCustomerByCondition(@Param("custId")Integer custId,@Param("custName") String custName);
}
