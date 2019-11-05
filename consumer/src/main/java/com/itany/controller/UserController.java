package com.itany.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itany.constant.AjaxResultCode;
import com.itany.exception.InputIsEmptyException;
import com.itany.exception.LoginNameOrPasswordErrorExceprion;
import com.itany.pojo.User;
import com.itany.userService.UserService;
import com.itany.util.AjaxResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: UserController
 * @Description: TODO
 * @Author: zhouzhongli
 * @Date: 2019-11-04 16:41:00
 * @Version: 1.0
 * @Copyright: 中国电信集团系统集成有限责任公司
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Reference
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public AjaxResult login(String loginName, String password) {
        AjaxResult ajaxResult = new AjaxResult();
        try {
            User user = userService.login(loginName, password);
            ajaxResult.setCode(AjaxResultCode.SUCCESS);
            ajaxResult.setReturnObj(user);
        } catch (InputIsEmptyException e1) {
            e1.printStackTrace();
            ajaxResult.setCode(AjaxResultCode.ERROR);
            ajaxResult.setMsg(e1.getMessage());
        } catch (LoginNameOrPasswordErrorExceprion e2) {
            e2.printStackTrace();
            ajaxResult.setCode(AjaxResultCode.ERROR);
            ajaxResult.setMsg(e2.getMessage());
        }
        return ajaxResult;
    }
}
