package com.meimeiv.bns.error;

public enum BusinessErrorEnum implements CommonError {
    //通用错误码
    PARAMETER_VALIDATION_ERROR(100001,"参数不合法"),
    UNKNOWN(100002,"未知错误"),
    IS_NOT_PHONE_NUM(100003,"不是正确的手机号"),

    USER_NOT_EXIST(200001,"用户不存在"),
    USER_OR_PASSWORD_ERROR(200002,"手机号或者密码错误"),

    //token模块-验证模块-过期
    TOKEN_VALIDATE_EXPIRED_ERROR (10200302,"token过期"),
    //token模块-验证模块-验证失败
    TOKEN_VALIDATE_FAIL_ERROR(10200303,"token验证失败"),
    //token模块-验证模块-通用异常
    TOKEN_VALIDATE_ERROR(10200399,"token通用异常"),

    //文件上传类
    FILE_TOO_LARGE(400001,"文件过大"),
    ;

    private int errorCode;
    private String errorMsg;

    BusinessErrorEnum(Integer code,String msg){
        this.errorCode = code;
        this.errorMsg = msg;
    }
    @Override
    public int getErrorCode() {
        return this.errorCode;
    }

    @Override
    public String getErrorMsg() {
        return this.errorMsg;
    }

    @Override
    public CommonError setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
        return this;
    }
}
