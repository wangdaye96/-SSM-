package com.wang.service;

import com.wang.pojo.Staff;
import com.wang.pojo.StaffExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StaffService {
    long countByExample(StaffExample example);

    int deleteByExample(StaffExample example);

    int deleteByPrimaryKey(Integer staffId);

    int insert(Staff record);

    int insertSelective(Staff record);

    List<Staff> selectByExample(StaffExample example);

    Staff selectByPrimaryKey(Integer staffId);

    int updateByExampleSelective(@Param("record") Staff record, @Param("example") StaffExample example);

    int updateByExample(@Param("record") Staff record, @Param("example") StaffExample example);

    boolean updateByPrimaryKeySelective(Staff record);

    boolean updateByPrimaryKey(Staff record);

    Staff getStaff(Integer staffId,String password);

    List<Staff> getStaffByCondition(@Param("staffId") Integer staffId,@Param("staffName")String staffName);
}
