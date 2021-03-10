package com.meimeiv.bns.controller;

import com.meimeiv.bns.BaseController;
import com.meimeiv.bns.common.Pager;
import com.meimeiv.bns.error.BusnessException;
import com.meimeiv.bns.response.CommonResponse;
import com.meimeiv.bns.service.UserService;
import com.meimeiv.bns.vo.request.LoginVo;
import com.meimeiv.bns.vo.request.UserVo;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.util.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @ Author   ：yangyunlong.
 * @ Date     ：Created in 10:07 2021/03/09
 * @Version ： 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;


    /**
     * 注册
     * @param userVo
     * @return
     * @throws BusnessException
     */
    @PostMapping("/registUser")
    @ResponseBody
    public CommonResponse registUser(@RequestBody UserVo userVo) throws BusnessException {
        Integer a = userService.registUser(userVo);
        return CommonResponse.create(a);
    }

    //登录
    @PostMapping("/login")
    @ResponseBody
    public CommonResponse login(@RequestBody LoginVo loginVo) throws BusnessException {
        Map<String,Object> result = new HashMap <>();
        Map<String,Object> userMap = userService.login(loginVo);
        String token = null;
        if (userMap != null){
            token = UUID.randomUUID().toString();
        }
        result.put("token",token);
        result.put("user",userMap);
        return CommonResponse.create(result);
    }
    //根据token获取用户数据
    //TODO

    //用户列表
    @PostMapping("/getUserList")
    @ResponseBody
    public CommonResponse getUserList(@RequestBody Map<String,Object> params){
        Pager pager = null;
        try {
            pager = userService.getUserList(params);
        } catch (Exception e) {
            LOGGER.error("查询用户列表失败",e);
        }
        return CommonResponse.create(pager);
    }

    @GetMapping("/exccelTest")
    @ResponseBody
    public CommonResponse exccelTest(HttpServletResponse response){
        HSSFWorkbook hssfWorkbook = userService.exccelTest();
        response.reset();
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        String fileName = System.currentTimeMillis() + ".xls";
        response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            hssfWorkbook.write(out);
            out.close();
        } catch (Exception e) {
            LOGGER.error("【导出失败】", e);
        } finally {
            // 使用的是org.apache.commons.io.IOUtils
            IOUtils.closeQuietly(out);
        }
        return null;
    }

}
