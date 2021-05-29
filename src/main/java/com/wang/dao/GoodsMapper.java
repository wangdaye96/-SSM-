package com.wang.dao;

import com.wang.pojo.Goods;
import com.wang.pojo.GoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsMapper {
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

    //多条件查询
    List<Goods> getGoodsByCondition(@Param("goodsId")Integer goodsId,@Param("supName")String supName,@Param("goodsName")String goodsName,@Param("goodsType")String goodsType );
}