package com.wang.service;

import com.wang.dao.OrderMapper;
import com.wang.pojo.Order;
import com.wang.pojo.OrderExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public long countByExample(OrderExample example) {
        return orderMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(OrderExample example) {
        return orderMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String orderId) {
        return orderMapper.deleteByPrimaryKey(orderId);
    }

    @Override
    public int insert(Order record) {
        return orderMapper.insert(record);
    }

    @Override
    public int insertSelective(Order record) {
        return orderMapper.insertSelective(record);
    }

    @Override
    public List<Order> selectByExample(OrderExample example) {
        return orderMapper.selectByExample(example);
    }

    @Override
    public Order selectByPrimaryKey(String orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public int updateByExampleSelective(Order record, OrderExample example) {
        return orderMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Order record, OrderExample example) {
        return orderMapper.updateByExample(record,example);
    }

    @Override
    public boolean updateByPrimaryKeySelective(Order record) {
        return orderMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public boolean updateByPrimaryKey(Order record) {
        return orderMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Order> getOrderByCondition(Integer goodsId, String custId, String orderId, String goodsName, String custName, String orderDate) {
        return orderMapper.getOrderByCondition(goodsId,custId,orderId,goodsName,custName,orderDate);
    }


    public List<Map<String, Object>> pieData() {
        List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
        List<Map<String, Object>> listData = orderMapper.count();
        if (listData.size() > 0) {
            for (int i = 0; i < listData.size(); i++) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("name", listData.get(i).get("goods_name"));
                map.put("value", listData.get(i).get("number"));
                data.add(map);
            }
        }
        return data;
    }

}
