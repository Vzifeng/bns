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
    public static final String PHONEREGULAR = "^1(3[0-9]|4[5,7]|5[0,1,2,3,5,6,7,8,9]|6[2,5,6,7]|7[0,1,7,8]|8[0-9]|9[1,8,9])\\d{8}$";

    public static boolean isPhoneNum(String phoneNum){
        Pattern pattern = Pattern.compile(PHONEREGULAR);
        Matcher matcher = pattern.matcher(phoneNum);
        boolean isMatch = matcher.matches();
        return isMatch;
    }

    public static void main(String[] args) {
        String str = "1399679726";
        boolean phoneNum = RegulaExpression.isPhoneNum(str);
        System.out.println(phoneNum);
    }

}
