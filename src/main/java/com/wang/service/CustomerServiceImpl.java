package com.wang.service;

import com.wang.dao.CustomerMapper;
import com.wang.pojo.Customer;
import com.wang.pojo.CustomerExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public long countByExample(CustomerExample example) {
        return customerMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(CustomerExample example) {
        return customerMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer custId) {
        return customerMapper.deleteByPrimaryKey(custId);
    }

    @Override
    public int insert(Customer record) {
        return customerMapper.insert(record);
    }

    @Override
    public int insertSelective(Customer record) {
        return customerMapper.insertSelective(record);
    }

    @Override
    public List<Customer> selectByExample(CustomerExample example) {
        return customerMapper.selectByExample(example);
    }

    @Override
    public Customer selectByPrimaryKey(Integer custId) {
        return customerMapper.selectByPrimaryKey(custId);
    }

    @Override
    public int updateByExampleSelective(Customer record, CustomerExample example) {
        return customerMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Customer record, CustomerExample example) {
        return customerMapper.updateByExample(record,example);
    }

    @Override
    public boolean updateByPrimaryKeySelective(Customer record) {
        return customerMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public boolean updateByPrimaryKey(Customer record) {
        return customerMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Customer> getCustomerByCondition(Integer custId, String custName) {
        return customerMapper.getCustomerByCondition(custId,custName);
    }
}
