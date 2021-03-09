package com.meimeiv.bns.service;

import com.meimeiv.bns.common.Pager;
import com.meimeiv.bns.error.BusnessException;
import com.meimeiv.bns.vo.request.LoginVo;
import com.meimeiv.bns.vo.request.UserVo;

import java.util.Map;

public interface UserService {
    Integer registUser(UserVo userVo) throws BusnessException;

    Map<String,Object> login(LoginVo loginVo) throws BusnessException;

    Pager getUserList(Map<String,Object> params) throws BusnessException;
}
