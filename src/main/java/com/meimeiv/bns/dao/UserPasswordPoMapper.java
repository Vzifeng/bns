package com.meimeiv.bns.dao;

import com.meimeiv.bns.po.UserPasswordPo;

public interface UserPasswordPoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserPasswordPo record);

    int insertSelective(UserPasswordPo record);

    UserPasswordPo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserPasswordPo record);

    int updateByPrimaryKey(UserPasswordPo record);

    String getPasswordByUserId(Integer userId);
}