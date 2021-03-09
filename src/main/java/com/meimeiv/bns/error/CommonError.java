package com.meimeiv.bns.error;

/**
 * @ Author      :  yangyunlong
 * @ CreateDate  : 2021/03/09 10:41
 * @ Version     :  1.0
 */
public interface CommonError {
    public int getErrorCode();

    public String getErrorMsg();

    public CommonError setErrorMsg(String errorMsg);
}
