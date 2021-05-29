package com.wang.service;

import com.wang.dao.AdminMapper;
import com.wang.pojo.Admin;
import com.wang.pojo.AdminExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public long countByExample(AdminExample example) {
        return adminMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(AdminExample example) {
        return adminMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String adminId) {
        return adminMapper.deleteByPrimaryKey(adminId);
    }

    @Override
    public int insert(Admin record) {
        return adminMapper.insert(record);
    }

    @Override
    public int insertSelective(Admin record) {
        return adminMapper.insertSelective(record);
    }

    @Override
    public List<Admin> selectByExample(AdminExample example) {
        return adminMapper.selectByExample(example);
    }

    @Override
    public Admin selectByPrimaryKey(String adminId) {
        return adminMapper.selectByPrimaryKey(adminId);
    }

    @Override
    public boolean updateByExampleSelective(Admin record, AdminExample example) {
        return adminMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByExample(Admin record, AdminExample example) {
        return adminMapper.updateByExample(record,example);
    }

    @Override
    public boolean updateByPrimaryKeySelective(Admin record) {
        return adminMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public boolean updateByPrimaryKey(Admin record) {
        return adminMapper.updateByPrimaryKey(record);
    }

    @Override
    public Admin getAdmin(String adminId, String password) {
        Admin admin = adminMapper.selectByPrimaryKey(adminId);
        if (admin!=null) {
            if (admin.getPassword().equals(password)) {
                return admin;
            }
        }
        return null;
    }
}
