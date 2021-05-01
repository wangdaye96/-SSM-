package com.wang.service;

import com.wang.dao.AdminMapper;
import com.wang.pojo.Admin;
import com.wang.pojo.AdminExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangdaye996
 * @Date 2021/4/30
 * @Time 18:42
 */
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
    public int deleteByPrimaryKey(Integer adminid) {
        return adminMapper.deleteByPrimaryKey(adminid);
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
    public Admin selectByPrimaryKey(Integer adminid) {
        return adminMapper.selectByPrimaryKey(adminid);
    }

    @Override
    public int updateByExampleSelective(Admin record, AdminExample example) {
        return adminMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Admin record, AdminExample example) {
        return adminMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Admin record) {
        return adminMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Admin record) {
        return adminMapper.updateByPrimaryKey(record);
    }
}
