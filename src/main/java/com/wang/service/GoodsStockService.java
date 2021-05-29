package com.wang.service;

import com.wang.pojo.GoodsStock;
import com.wang.pojo.GoodsStockExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsStockService {
    long countByExample(GoodsStockExample example);

    int deleteByExample(GoodsStockExample example);

    int deleteByPrimaryKey(Integer goodsId);

    int insert(GoodsStock record);

    int insertSelective(GoodsStock record);

    List<GoodsStock> selectByExample(GoodsStockExample example);

    GoodsStock selectByPrimaryKey(Integer goodsId);

    int updateByExampleSelective(@Param("record") GoodsStock record, @Param("example") GoodsStockExample example);

    int updateByExample(@Param("record") GoodsStock record, @Param("example") GoodsStockExample example);

    Boolean updateByPrimaryKeySelective(GoodsStock record);

    Boolean updateByPrimaryKey(GoodsStock record);

    List<GoodsStock> getAllGoodsStockInfo();
    List<GoodsStock> getAllGoodsStockByCondition(Integer goodsId,String goodsName);

    GoodsStock goodsStockWithGoods(Integer goodsId);

    Boolean update(GoodsStock goodsStock, Integer number);

    //库存预警
    List<GoodsStock> goodsStockWarning();

    //日期预警
    List<GoodsStock> goodsStockDateWarning();
}
