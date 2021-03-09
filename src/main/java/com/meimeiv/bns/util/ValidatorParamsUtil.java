package com.meimeiv.bns.util;

import com.meimeiv.bns.error.BusinessErrorEnum;
import com.meimeiv.bns.error.BusnessException;
import com.meimeiv.bns.service.impl.UserServcieImpl;
import com.meimeiv.bns.validator.ValidationResult;
import com.meimeiv.bns.validator.ValidatorImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ Author   ：yangyunlong.
 * @ Date     ：Created in 15:02 2021/03/09
 * @Version ： 1.0
 */
public class ValidatorParamsUtil {

    public static final Logger LOGGER = LoggerFactory.getLogger(ValidatorParamsUtil.class);

    public static void validator(Object object,ValidatorImpl validator) throws BusnessException {
        if (object == null){
            throw new BusnessException(BusinessErrorEnum.PARAMETER_VALIDATION_ERROR,
                    BusinessErrorEnum.PARAMETER_VALIDATION_ERROR.getErrorMsg());
        }
        ValidationResult validationResult = null;
        try {
            validationResult = validator.validate(object);
        } catch (Exception e) {
            LOGGER.error("获取校验信息失败",e);
        }
        if (validationResult.isHasErrors()){
            throw new BusnessException(BusinessErrorEnum.PARAMETER_VALIDATION_ERROR,validationResult.getErrorMsg());
        }
    }
}
