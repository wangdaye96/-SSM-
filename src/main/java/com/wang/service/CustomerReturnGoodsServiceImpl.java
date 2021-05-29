package com.wang.service;

import com.wang.dao.CustomerReturnGoodsMapper;
import com.wang.pojo.CustomerReturnGoods;
import com.wang.pojo.CustomerReturnGoodsExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerReturnGoodsServiceImpl implements CustomerReturnGoodsService{
    @Autowired
    private CustomerReturnGoodsMapper customerReturnGoodsMapper;

    @Override
    public long countByExample(CustomerReturnGoodsExample example) {
        return customerReturnGoodsMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(CustomerReturnGoodsExample example) {
        return customerReturnGoodsMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String orderId) {
        return customerReturnGoodsMapper.deleteByPrimaryKey(orderId);
    }

    @Override
    public int insert(CustomerReturnGoods record) {
        return customerReturnGoodsMapper.insert(record);
    }

    @Override
    public int insertSelective(CustomerReturnGoods record) {
        return customerReturnGoodsMapper.insertSelective(record);
    }

    @Override
    public List<CustomerReturnGoods> selectByExample(CustomerReturnGoodsExample example) {
        return customerReturnGoodsMapper.selectByExample(example);
    }

    @Override
    public CustomerReturnGoods selectByPrimaryKey(String orderId) {
        return customerReturnGoodsMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public int updateByExampleSelective(CustomerReturnGoods record, CustomerReturnGoodsExample example) {
        return customerReturnGoodsMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(CustomerReturnGoods record, CustomerReturnGoodsExample example) {
        return customerReturnGoodsMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(CustomerReturnGoods record) {
        return customerReturnGoodsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CustomerReturnGoods record) {
        return customerReturnGoodsMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<CustomerReturnGoods> getCustomerReturnGoodsByCondition(Integer goodsId, String orderId, String goodsName, String returnDate) {
        return customerReturnGoodsMapper.getCustomerReturnGoodsByCondition(goodsId,orderId,goodsName,returnDate);
    }
}
