package com.wang.service;

import com.wang.pojo.Type;
import com.wang.pojo.TypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TypeService {
    long countByExample(TypeExample example);

    int deleteByExample(TypeExample example);

    int deleteByPrimaryKey(Integer goodsTypeId);

    int insert(Type record);

    int insertSelective(Type record);

    List<Type> selectByExample(TypeExample example);

    Type selectByPrimaryKey(Integer goodsTypeId);

    int updateByExampleSelective(@Param("record") Type record, @Param("example") TypeExample example);

    int updateByExample(@Param("record") Type record, @Param("example") TypeExample example);

    int updateByPrimaryKeySelective(Type record);

    boolean updateByPrimaryKey(Type record);

    List<Type> getTypeByCondition(@Param("goodsTypeId")Integer goodsTypeId,@Param("example") String name);
}
