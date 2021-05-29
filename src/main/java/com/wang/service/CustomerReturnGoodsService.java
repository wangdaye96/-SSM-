package com.wang.service;

import com.wang.pojo.CustomerReturnGoods;
import com.wang.pojo.CustomerReturnGoodsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerReturnGoodsService {
    long countByExample(CustomerReturnGoodsExample example);

    int deleteByExample(CustomerReturnGoodsExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(CustomerReturnGoods record);

    int insertSelective(CustomerReturnGoods record);

    List<CustomerReturnGoods> selectByExample(CustomerReturnGoodsExample example);

    CustomerReturnGoods selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") CustomerReturnGoods record, @Param("example") CustomerReturnGoodsExample example);

    int updateByExample(@Param("record") CustomerReturnGoods record, @Param("example") CustomerReturnGoodsExample example);

    int updateByPrimaryKeySelective(CustomerReturnGoods record);

    int updateByPrimaryKey(CustomerReturnGoods record);

    List<CustomerReturnGoods> getCustomerReturnGoodsByCondition(@Param("goodsId") Integer goodsId,@Param("orderId")String orderId,@Param("goodsName")String goodsName,@Param("returnDate")String returnDate );

}
