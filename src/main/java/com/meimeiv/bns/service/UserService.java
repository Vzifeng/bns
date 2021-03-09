package com.meimeiv.bns.service;

import com.meimeiv.bns.error.BusnessException;
import com.meimeiv.bns.vo.request.UserVo;

public interface UserService {
    Integer registUser(UserVo userVo) throws BusnessException;
}
