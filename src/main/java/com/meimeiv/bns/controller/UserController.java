package com.meimeiv.bns.controller;

import com.meimeiv.bns.BaseController;
import com.meimeiv.bns.error.BusnessException;
import com.meimeiv.bns.response.CommonResponse;
import com.meimeiv.bns.service.UserService;
import com.meimeiv.bns.vo.request.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @ Author   ：yangyunlong.
 * @ Date     ：Created in 10:07 2021/03/09
 * @Version ： 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    UserService userService;

    @PostMapping("/registUser")
    @ResponseBody
    public CommonResponse registUser(@RequestBody UserVo userVo) throws BusnessException {
        Integer a = userService.registUser(userVo);
        return CommonResponse.create(a);
    }

}
