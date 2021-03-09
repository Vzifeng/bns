package com.meimeiv.bns.response;

import lombok.Data;

/**
 * @ Author   ：yangyunlong.
 * @ Date     ：Created in 10:40 2021/03/09
 * @Version ： 1.0
 */
@Data
public class CommonResponse {
    private String status;
    private Object data;

    //通用方法
    public static CommonResponse create(Object result){
        return CommonResponse.create(result,"success");
    }

    public static CommonResponse create(Object result,String str){
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setStatus(str);
        commonResponse.setData(result);
        return commonResponse;
    }
}
