package com.wang.dao;

import com.wang.pojo.GoodsStock;
import com.wang.pojo.GoodsStockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsStockMapper {
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

    List<GoodsStock> getAllGoodsStockInfoByCondition(@Param("goodsId") Integer goodsId,@Param("goodsName") String goodsName);

    //库存表关联商品信息表
    GoodsStock goodsStockWithGoods(Integer goodsId);

    //  库存表关联商品信息表（库存预警表）
    List<GoodsStock> goodsStockWarning();
    List<GoodsStock> goodsStockDateWarning();
}