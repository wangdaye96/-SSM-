package com.wang.dao;

import com.wang.pojo.Order;
import com.wang.pojo.OrderExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface OrderMapper {
    long countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    boolean updateByPrimaryKeySelective(Order record);

    boolean updateByPrimaryKey(Order record);

    List<Order> getOrderByCondition(@Param("goodsId") Integer goodsId,@Param("custId") String custId,@Param("orderId") String orderId,@Param("goodsName") String goodsName,@Param("custName") String custName,@Param("orderDate") String orderDate);

    @Select("select SUM(number) as number,goods_name from orderr GROUP BY goods_name")
    List<Map<String,Object>> count();
}