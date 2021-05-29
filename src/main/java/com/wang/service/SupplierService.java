package com.wang.service;

import com.wang.pojo.Supplier;
import com.wang.pojo.SupplierExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SupplierService {
    long countByExample(SupplierExample example);

    int deleteByExample(SupplierExample example);

    int deleteByPrimaryKey(Integer supId);

    int insert(Supplier record);

    int insertSelective(Supplier record);

    List<Supplier> selectByExample(SupplierExample example);

    Supplier selectByPrimaryKey(Integer supId);

    int updateByExampleSelective(@Param("record") Supplier record, @Param("example") SupplierExample example);

    int updateByExample(@Param("record") Supplier record, @Param("example") SupplierExample example);

    boolean updateByPrimaryKeySelective(Supplier record);

    boolean updateByPrimaryKey(Supplier record);

    List<Supplier> getSupplierByCondition(@Param("supId")Integer supId,@Param("supName")String supName);

}
