package com.wang.dao;

import com.wang.pojo.Staff;
import com.wang.pojo.StaffExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StaffMapper {
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

    List<Staff> getStaffByCondition(@Param("staffId") Integer staffId,@Param("staffName")String staffName);
}