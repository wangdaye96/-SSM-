package com.wang.service;

import com.wang.pojo.Goods;
import com.wang.pojo.GoodsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsService {
    long countByExample(GoodsExample example);

    int deleteByExample(GoodsExample example);

    int deleteByPrimaryKey(Integer goodsId);

    int insert(Goods record);

    int insertSelective(Goods record);

    List<Goods> selectByExample(GoodsExample example);

    Goods selectByPrimaryKey(Integer goodsId);

    int updateByExampleSelective(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByExample(@Param("record") Goods record, @Param("example") GoodsExample example);

    boolean updateByPrimaryKeySelective(Goods record);

    Boolean updateByPrimaryKey(Goods record);

    //按条件查询
    List<Goods> getGoodsByCondition(Integer goodsId,String supName,String goodsName,String goodsType);
}
