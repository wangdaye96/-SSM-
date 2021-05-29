package com.wang.dao;

import com.wang.pojo.InputGoods;
import com.wang.pojo.InputGoodsExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InputGoodsMapper {
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

    //按条件查询
    List<InputGoods> getInputGoodsByCondition(@Param("goodsId") Integer goodsId, @Param("inputId") String inputId, @Param("goodsName") String goodsName, @Param("inputDate") String inputDate);
}