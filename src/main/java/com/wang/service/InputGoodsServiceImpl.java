package com.wang.service;

import com.wang.dao.InputGoodsMapper;
import com.wang.pojo.InputGoods;
import com.wang.pojo.InputGoodsExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InputGoodsServiceImpl implements InputGoodsService{
    @Autowired
    private InputGoodsMapper inputGoodsMapper;

    @Override
    public long countByExample(InputGoodsExample example) {
        return inputGoodsMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(InputGoodsExample example) {
        return inputGoodsMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String inputId) {
        return inputGoodsMapper.deleteByPrimaryKey(inputId);
    }

    @Override
    public int insert(InputGoods record) {
        return inputGoodsMapper.insert(record);
    }

    @Override
    public int insertSelective(InputGoods record) {
        return inputGoodsMapper.insertSelective(record);
    }

    @Override
    public List<InputGoods> selectByExample(InputGoodsExample example) {
        return inputGoodsMapper.selectByExample(example);
    }

    @Override
    public InputGoods selectByPrimaryKey(String inputId) {
        return inputGoodsMapper.selectByPrimaryKey(inputId);
    }

    @Override
    public boolean updateByExampleSelective(InputGoods record, InputGoodsExample example) {
        return inputGoodsMapper.updateByExampleSelective(record,example);
    }

    @Override
    public boolean updateByExample(InputGoods record, InputGoodsExample example) {
        return inputGoodsMapper.updateByExample(record,example);
    }

    @Override
    public boolean updateByPrimaryKeySelective(InputGoods record) {
        return inputGoodsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public boolean updateByPrimaryKey(InputGoods record) {
        return inputGoodsMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<InputGoods> getInputGoodsByCondition(Integer goodsId, String inputId, String goodsName, String inputDate) {
        return inputGoodsMapper.getInputGoodsByCondition(goodsId,inputId,goodsName,inputDate);
    }
}
