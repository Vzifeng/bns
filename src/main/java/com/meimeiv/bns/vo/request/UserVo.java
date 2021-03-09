package com.meimeiv.bns.vo.request;

import com.meimeiv.bns.util.RegulaExpression;
import lombok.Data;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * @ Author   ：yangyunlong.
 * @ Date     ：Created in 11:05 2021/03/09
 * @Version ： 1.0
 */
@Data
public class UserVo {

    @NotNull(message = "姓名不能为空")
    private String userName;
    @NotNull(message = "性别不能为空")
    private Integer userSex;
    @NotNull(message = "电话号码不能为空")
    @Pattern(regexp = RegulaExpression.PHONEREGULAR,message = "电话号码格式不正确")
    private String userPhone;
    @NotNull(message = "密码不能为空")
    @Size(min = 6,max = 18,message = "密码长度在6位到18位之间")
    private String password;

    private String userAddr;

    private Integer roleId;

}
