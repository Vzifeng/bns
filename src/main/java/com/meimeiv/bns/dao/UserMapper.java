package com.meimeiv.bns.dao;

import com.meimeiv.bns.po.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    Integer selectByUserPhone(Map<String,Object> params);

    Integer insertUser(Map<String,Object> params);

     Map<String,Object> selectByUserPhone1(Map<String,Object> params);

    List<Map<String,Object>> getUserList(Map<String,Object> params);
}