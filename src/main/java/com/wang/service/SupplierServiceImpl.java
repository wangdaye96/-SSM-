package com.wang.service;

import com.wang.dao.SupplierMapper;
import com.wang.pojo.Supplier;
import com.wang.pojo.SupplierExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService{
    @Autowired
    private SupplierMapper supplierMapper;

    @Override
    public long countByExample(SupplierExample example) {
        return supplierMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(SupplierExample example) {
        return supplierMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer supId) {
        return supplierMapper.deleteByPrimaryKey(supId);
    }

    @Override
    public int insert(Supplier record) {
        return supplierMapper.insert(record);
    }

    @Override
    public int insertSelective(Supplier record) {
        return supplierMapper.insertSelective(record);
    }

    @Override
    public List<Supplier> selectByExample(SupplierExample example) {
        return supplierMapper.selectByExample(example);
    }

    @Override
    public Supplier selectByPrimaryKey(Integer supId) {
        return supplierMapper.selectByPrimaryKey(supId);
    }

    @Override
    public int updateByExampleSelective(Supplier record, SupplierExample example) {
        return supplierMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Supplier record, SupplierExample example) {
        return supplierMapper.updateByExample(record,example);
    }

    @Override
    public boolean updateByPrimaryKeySelective(Supplier record) {
        return supplierMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public boolean updateByPrimaryKey(Supplier record) {
        return supplierMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Supplier> getSupplierByCondition(Integer supId, String supName) {
        return supplierMapper.getSupplierByCondition(supId,supName);
    }
}
