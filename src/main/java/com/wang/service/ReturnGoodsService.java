package com.wang.service;

import com.wang.pojo.ReturnGoods;
import com.wang.pojo.ReturnGoodsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReturnGoodsService {
    long countByExample(ReturnGoodsExample example);

    int deleteByExample(ReturnGoodsExample example);

    int deleteByPrimaryKey(String inputId);

    int insert(ReturnGoods record);

    int insertSelective(ReturnGoods record);

    List<ReturnGoods> selectByExample(ReturnGoodsExample example);

    ReturnGoods selectByPrimaryKey(String inputId);

    int updateByExampleSelective(@Param("record") ReturnGoods record, @Param("example") ReturnGoodsExample example);

    boolean updateByExample(@Param("record") ReturnGoods record, @Param("example") ReturnGoodsExample example);

    boolean updateByPrimaryKeySelective(ReturnGoods record);

    Boolean updateByPrimaryKey(ReturnGoods record);

    List<ReturnGoods> getReturnGoodsByCondition(Integer goodsId, String returnId, String goodsName, String returnDate);
}
