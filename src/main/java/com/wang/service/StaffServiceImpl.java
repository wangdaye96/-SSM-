package com.wang.service;

import com.wang.dao.StaffMapper;
import com.wang.pojo.Staff;
import com.wang.pojo.StaffExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService{
    @Autowired
    private StaffMapper staffMapper;

    @Override
    public long countByExample(StaffExample example) {
        return staffMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(StaffExample example) {
        return staffMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer staffId) {
        return staffMapper.deleteByPrimaryKey(staffId);
    }

    @Override
    public int insert(Staff record) {
        return staffMapper.insert(record);
    }

    @Override
    public int insertSelective(Staff record) {
        return staffMapper.insertSelective(record);
    }

    @Override
    public List<Staff> selectByExample(StaffExample example) {
        return staffMapper.selectByExample(example);
    }

    @Override
    public Staff selectByPrimaryKey(Integer staffId) {
        return staffMapper.selectByPrimaryKey(staffId);
    }

    @Override
    public int updateByExampleSelective(Staff record, StaffExample example) {
        return staffMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Staff record, StaffExample example) {
        return staffMapper.updateByExample(record,example);
    }

    @Override
    public boolean updateByPrimaryKeySelective(Staff record) {
        return staffMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public boolean updateByPrimaryKey(Staff record) {
        return staffMapper.updateByPrimaryKey(record);
    }

    @Override
    public Staff getStaff(Integer staffId, String password) {
        try {
            Staff staff=staffMapper.selectByPrimaryKey(staffId);
            if (staff!=null){
                if (staff.getPassword().equals(password)){
                    return staff;
                }
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    @Override
    public List<Staff> getStaffByCondition(Integer staffId, String staffName) {
        return staffMapper.getStaffByCondition(staffId,staffName);
    }
}
