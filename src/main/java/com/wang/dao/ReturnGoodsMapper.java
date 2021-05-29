package com.wang.dao;

import com.wang.pojo.ReturnGoods;
import com.wang.pojo.ReturnGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReturnGoodsMapper {
    long countByExample(ReturnGoodsExample example);

    int deleteByExample(ReturnGoodsExample example);

    int deleteByPrimaryKey(String returnId);

    int insert(ReturnGoods record);

    int insertSelective(ReturnGoods record);

    List<ReturnGoods> selectByExample(ReturnGoodsExample example);

    ReturnGoods selectByPrimaryKey(String returnId);

    int updateByExampleSelective(@Param("record") ReturnGoods record, @Param("example") ReturnGoodsExample example);

    boolean updateByExample(@Param("record") ReturnGoods record, @Param("example") ReturnGoodsExample example);

    boolean updateByPrimaryKeySelective(ReturnGoods record);

    Boolean updateByPrimaryKey(ReturnGoods record);

    List<ReturnGoods> getReturnGoodsByCondition(@Param("goodsId") Integer goodsId, @Param("returnId") String returnId, @Param("goodsName") String goodsName, @Param("returnDate") String returnDate);
}