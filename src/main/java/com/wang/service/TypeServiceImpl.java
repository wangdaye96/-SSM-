package com.wang.service;

import com.wang.dao.TypeMapper;
import com.wang.pojo.Type;
import com.wang.pojo.TypeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService{
    @Autowired
    private TypeMapper typeMapper;

    @Override
    public long countByExample(TypeExample example) {
        return typeMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(TypeExample example) {
        return typeMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer goodsTypeId) {
        return typeMapper.deleteByPrimaryKey(goodsTypeId);
    }

    @Override
    public int insert(Type record) {
        return typeMapper.insert(record);
    }

    @Override
    public int insertSelective(Type record) {
        return typeMapper.insertSelective(record);
    }

    @Override
    public List<Type> selectByExample(TypeExample example) {
        return typeMapper.selectByExample(example);
    }

    @Override
    public Type selectByPrimaryKey(Integer goodsTypeId) {
        return typeMapper.selectByPrimaryKey(goodsTypeId);
    }

    @Override
    public int updateByExampleSelective(Type record, TypeExample example) {
        return typeMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Type record, TypeExample example) {
        return typeMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Type record) {
        return typeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public boolean updateByPrimaryKey(Type record) {
        return typeMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Type> getTypeByCondition(Integer goodsTypeId, String name) {
        TypeExample typeExample=new TypeExample();
        TypeExample.Criteria criteria = typeExample.createCriteria();
        if (goodsTypeId==null){
            criteria.andTypeNameLike(name);
        }else{
            criteria.andGoodsTypeIdEqualTo(goodsTypeId);
        }
        return selectByExample(typeExample);
    }
}
