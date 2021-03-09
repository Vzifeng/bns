package com.meimeiv.bns.service.impl;

import com.meimeiv.bns.error.BusinessErrorEnum;
import com.meimeiv.bns.error.BusnessException;
import com.meimeiv.bns.service.UserService;
import com.meimeiv.bns.validator.ValidationResult;
import com.meimeiv.bns.validator.ValidatorImpl;
import com.meimeiv.bns.vo.request.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public Integer registUser(UserVo userVo) throws BusnessException {
        if (userVo == null){
            throw new BusnessException(BusinessErrorEnum.PARAMETER_VALIDATION_ERROR,
                    BusinessErrorEnum.PARAMETER_VALIDATION_ERROR.getErrorMsg());
        }
        ValidationResult validationResult = null;
        try {
            validationResult = validator.validate(userVo);
        } catch (Exception e) {
            LOGGER.error("获取校验信息失败",e);
        }
        if (validationResult.isHasErrors()){
            throw new BusnessException(BusinessErrorEnum.PARAMETER_VALIDATION_ERROR,validationResult.getErrorMsg());
        }
        return null;
    }
}
