package com.meimeiv.bns;

import com.meimeiv.bns.error.BusinessErrorEnum;
import com.meimeiv.bns.error.BusnessException;
import com.meimeiv.bns.response.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @ Author   ：yangyunlong.
 * @ Date     ：Created in 11:38 2021/03/09
 * @Version ： 1.0
 */
public class BaseController {
    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public Object handerException(HttpServletRequest request, Exception ex){
        Map<String,Object> errorMap = new HashMap<String, Object>();
        if (ex instanceof BusnessException){
            BusnessException busnessException = (BusnessException)ex;
            errorMap.put("errorCode",busnessException.getErrorCode());
            errorMap.put("errorMsg",busnessException.getErrorMsg());
        }else {
            errorMap.put("errorCode",BusinessErrorEnum.UNKNOWN.getErrorCode());
            errorMap.put("errorMsg",BusinessErrorEnum.UNKNOWN.getErrorMsg());
        }
        return CommonResponse.create(errorMap,"fail");
    }
}
