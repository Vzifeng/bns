package com.meimeiv.bns.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.meimeiv.bns.common.Pager;
import com.meimeiv.bns.dao.UserMapper;
import com.meimeiv.bns.dao.UserPasswordPoMapper;
import com.meimeiv.bns.error.BusinessErrorEnum;
import com.meimeiv.bns.error.BusnessException;
import com.meimeiv.bns.po.User;
import com.meimeiv.bns.po.UserPasswordPo;
import com.meimeiv.bns.service.UserService;
import com.meimeiv.bns.util.DateUtil;
import com.meimeiv.bns.util.EncodeByMd5Util;
import com.meimeiv.bns.util.MapUtil;
import com.meimeiv.bns.validator.ValidationResult;
import com.meimeiv.bns.validator.ValidatorImpl;
import com.meimeiv.bns.vo.request.LoginVo;
import com.meimeiv.bns.vo.request.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Map;

import static com.meimeiv.bns.util.ValidatorParamsUtil.validator;

/**
 * @ Author   ：yangyunlong.
 * @ Date     ：Created in 10:14 2021/03/09
 * @Version ： 1.0
 */
@Service
public class UserServcieImpl implements UserService {

    public static final Logger LOGGER = LoggerFactory.getLogger(UserServcieImpl.class);

    @Autowired
    ValidatorImpl validator;

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserPasswordPoMapper userPasswordPoMapper;

    @Override
    @Transactional
    public Integer registUser(UserVo userVo) throws BusnessException {
        validator(userVo,validator);
        Map<String,Object> params = (Map <String, Object>) MapUtil.objectToMap(userVo);
        params.put("userRegistrationTime",DateUtil.dateToString1(new Date()));
        //验证手机号是否已注册
        Integer num = userMapper.selectByUserPhone(params);
        if (num !=0 ){
            throw new BusnessException(BusinessErrorEnum.USER_EXIST,BusinessErrorEnum.USER_EXIST.getErrorMsg());
        }
        //存用户信息
        User user = MapUtil.convertBean(params,User.class);
        Integer insertNum = userMapper.insert(user);
        if (insertNum != 1){
            throw new BusnessException(BusinessErrorEnum.USER_INSERT_FAIL,BusinessErrorEnum.USER_INSERT_FAIL.getErrorMsg());
        }
        //存密码
        UserPasswordPo userPassword = new UserPasswordPo();
        userPassword.setUserId(user.getId());
        userPassword.setPassword(EncodeByMd5Util.encodeByMd5(userVo.getPassword()));
        Integer num1 = userPasswordPoMapper.insert(userPassword);
        if (num1 != 1){
            throw new BusnessException(BusinessErrorEnum.USER_INSERT_FAIL,BusinessErrorEnum.USER_INSERT_FAIL.getErrorMsg());
        }
        return insertNum;
    }

    @Override
    public Map <String, Object> login(LoginVo loginVo) throws BusnessException {
        validator(loginVo,validator);
        //查询用户是否存在
        Map<String,Object> params = (Map <String, Object>) MapUtil.objectToMap(loginVo);
        Map<String,Object> map = userMapper.selectByUserPhone1(params);
        if (map == null){
            throw new BusnessException(BusinessErrorEnum.USER_NOT_EXIST,BusinessErrorEnum.USER_NOT_EXIST.getErrorMsg());
        }
        //查询密码
        Integer userId = (Integer) map.get("id");
        String password = userPasswordPoMapper.getPasswordByUserId(userId);
        if (!EncodeByMd5Util.encodeByMd5(loginVo.getPassword()).equals(password)){
            throw new BusnessException(BusinessErrorEnum.USER_OR_PASSWORD_ERROR,BusinessErrorEnum.USER_OR_PASSWORD_ERROR.getErrorMsg());
        }
        return map;
    }

    @Override
    public Pager getUserList(Map <String, Object> params) throws BusnessException {
        Pager pager = new Pager();
        if (params == null){
            throw new BusnessException(BusinessErrorEnum.PARAMETER_VALIDATION_ERROR,
                    BusinessErrorEnum.PARAMETER_VALIDATION_ERROR.getErrorMsg());
        }
        Integer curPage = (Integer) params.get("curPage");
        Integer pageSize = (Integer) params.get("pageSize");
        Page page = PageHelper.startPage(curPage,pageSize);
        userMapper.getUserList(params);
        pager.setCurPage(curPage);
        pager.setPageSize(pageSize);
        pager.setTotalPage(page.getPages());
        pager.setTotalRow((int) page.getTotal());
        pager.setList(page.getResult());
        return pager;
    }
}
