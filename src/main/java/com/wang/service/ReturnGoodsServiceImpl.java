package com.wang.service;

import com.wang.dao.ReturnGoodsMapper;
import com.wang.pojo.ReturnGoods;
import com.wang.pojo.ReturnGoodsExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReturnGoodsServiceImpl implements ReturnGoodsService{
    @Autowired
    private ReturnGoodsMapper returnGoodsMapper;

    @Override
    public long countByExample(ReturnGoodsExample example) {
        return returnGoodsMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ReturnGoodsExample example) {
        return returnGoodsMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String inputId) {
        return returnGoodsMapper.deleteByPrimaryKey(inputId);
    }

    @Override
    public int insert(ReturnGoods record) {
        return returnGoodsMapper.insert(record);
    }

    @Override
    public int insertSelective(ReturnGoods record) {
        return returnGoodsMapper.insertSelective(record);
    }

    @Override
    public List<ReturnGoods> selectByExample(ReturnGoodsExample example) {
        return returnGoodsMapper.selectByExample(example);
    }

    @Override
    public ReturnGoods selectByPrimaryKey(String inputId) {
        return returnGoodsMapper.selectByPrimaryKey(inputId);
    }

    @Override
    public int updateByExampleSelective(ReturnGoods record, ReturnGoodsExample example) {
        return returnGoodsMapper.updateByExampleSelective(record,example);
    }

    @Override
    public boolean updateByExample(ReturnGoods record, ReturnGoodsExample example) {
        return returnGoodsMapper.updateByExample(record,example);
    }

    @Override
    public boolean updateByPrimaryKeySelective(ReturnGoods record) {
        return returnGoodsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Boolean updateByPrimaryKey(ReturnGoods record) {
        return returnGoodsMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<ReturnGoods> getReturnGoodsByCondition(Integer goodsId, String returnId, String goodsName, String returnDate) {
        return returnGoodsMapper.getReturnGoodsByCondition(goodsId,returnId,goodsName,returnDate);
    }
}
