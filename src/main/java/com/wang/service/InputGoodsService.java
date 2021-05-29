package com.wang.service;

import com.wang.pojo.InputGoods;
import com.wang.pojo.InputGoodsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InputGoodsService {
    long countByExample(InputGoodsExample example);

    int deleteByExample(InputGoodsExample example);

    int deleteByPrimaryKey(String inputId);

    int insert(InputGoods record);

    int insertSelective(InputGoods record);

    List<InputGoods> selectByExample(InputGoodsExample example);

    InputGoods selectByPrimaryKey(String inputId);

    boolean updateByExampleSelective(@Param("record") InputGoods record, @Param("example") InputGoodsExample example);

    boolean updateByExample(@Param("record") InputGoods record, @Param("example") InputGoodsExample example);

    boolean updateByPrimaryKeySelective(InputGoods record);

    boolean updateByPrimaryKey(InputGoods record);

    List<InputGoods> getInputGoodsByCondition(Integer goodsId, String inputId, String goodsName, String inputDate);
}
