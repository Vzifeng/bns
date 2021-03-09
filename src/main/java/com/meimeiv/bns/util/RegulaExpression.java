package com.meimeiv.bns.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式工具类
 * @ Author   ：yangyunlong.
 * @ Date     ：Created in 11:47 2021/03/09
 * @Version ： 1.0
 */
public class RegulaExpression {
    //手机号码正则表达式
    public static final String PHONEREGULAR = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";

    public static boolean isPhoneNum(String phoneNum){
        Pattern pattern = Pattern.compile(PHONEREGULAR);
        Matcher matcher = pattern.matcher(phoneNum);
        boolean isMatch = matcher.matches();
        return isMatch;
    }

}
