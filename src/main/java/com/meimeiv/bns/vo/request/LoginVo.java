package com.meimeiv.bns.vo.request;

import com.meimeiv.bns.util.RegulaExpression;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @ Author   ：yangyunlong.
 * @ Date     ：Created in 14:52 2021/03/09
 * @Version ： 1.0
 */
@Data
public class LoginVo {

    @NotNull(message = "账号不能为空")
    @Pattern(regexp = RegulaExpression.PHONEREGULAR,message = "账号格式不正确")
    private String userPhone;
    @NotNull(message = "密码不能为空")
    private String password;
}
