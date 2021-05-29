package com.wang.service;

import com.wang.dao.GoodsStockMapper;
import com.wang.dao.InputGoodsMapper;
import com.wang.pojo.GoodsStock;
import com.wang.pojo.GoodsStockExample;
import com.wang.pojo.InputGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class GoodsStockServiceImpl implements GoodsStockService{
    @Autowired
    private GoodsStockMapper goodsStockMapper;

    @Autowired
    private InputGoodsMapper inputGoodsMapper;

    @Override
    public long countByExample(GoodsStockExample example) {
        return goodsStockMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(GoodsStockExample example) {
        return goodsStockMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer goodsId) {
        return goodsStockMapper.deleteByPrimaryKey(goodsId);
    }

    @Override
    public int insert(GoodsStock record) {
        return goodsStockMapper.insert(record);
    }

    @Override
    public int insertSelective(GoodsStock record) {
        return goodsStockMapper.insertSelective(record);
    }

    @Override
    public List<GoodsStock> selectByExample(GoodsStockExample example) {
        return goodsStockMapper.selectByExample(example);
    }

    @Override
    public GoodsStock selectByPrimaryKey(Integer goodsId) {
        return goodsStockMapper.selectByPrimaryKey(goodsId);
    }

    @Override
    public int updateByExampleSelective(GoodsStock record, GoodsStockExample example) {
        return goodsStockMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(GoodsStock record, GoodsStockExample example) {
        return goodsStockMapper.updateByExample(record,example);
    }

    @Override
    public Boolean updateByPrimaryKeySelective(GoodsStock record) {
        return goodsStockMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Boolean updateByPrimaryKey(GoodsStock record) {
        return goodsStockMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<GoodsStock> getAllGoodsStockInfo() {
        GoodsStockExample goodsStockExample = new GoodsStockExample();
        goodsStockExample.setOrderByClause("number DESC");
        return goodsStockMapper.selectByExample(goodsStockExample);
    }

    @Override
    public List<GoodsStock> getAllGoodsStockByCondition(Integer goodsId, String goodsName) {
        return goodsStockMapper.getAllGoodsStockInfoByCondition(goodsId,goodsName);
    }

    @Override
    public GoodsStock goodsStockWithGoods(Integer goodsId) {
        return goodsStockMapper.goodsStockWithGoods(goodsId);
    }

    @Override
    public Boolean update(GoodsStock goodsStock, Integer number) {
        InputGoods ckin = new InputGoods();
        //随机生成7位进货号
        String lastNum = "";
        int num;
        Random ran = new Random ();
        for(int i = 0; i<7;i++){
            num = ran.nextInt(10);
            lastNum += new Integer (num).toString();
        }
        ckin.setInputId(lastNum);
        ckin.setGoodsId(goodsStock.getGoodsId());
        ckin.setInputDate(new Date());
        ckin.setNumber(number);
        ckin.setGoodsName(goodsStock.getGoodsName());
        ckin.setRemarks(goodsStock.getRemarks());
        inputGoodsMapper.insert(ckin);
        goodsStock.setNumber((goodsStock.getNumber()+number));
        return goodsStockMapper.updateByPrimaryKeySelective(goodsStock);
    }

    @Override
    public List<GoodsStock> goodsStockWarning() {
        return goodsStockMapper.goodsStockWarning();
    }

    @Override
    public List<GoodsStock> goodsStockDateWarning() {
        return goodsStockMapper.goodsStockDateWarning();
    }
}
