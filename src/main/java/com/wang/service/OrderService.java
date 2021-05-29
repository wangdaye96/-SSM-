package com.wang.service;

import com.wang.pojo.Order;
import com.wang.pojo.OrderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderService {
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

    List<Order> getOrderByCondition(@Param("goodsId") Integer goodsId, @Param("custId") String custId, @Param("orderId") String orderId,@Param("goodsName") String goodsName, @Param("custName") String custName, @Param("orderDate") String orderDate);

}
