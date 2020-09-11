package com.xiaozhoujia.crab.controller;

import com.xiaozhoujia.crab.constant.AjaxResultCode;
import com.xiaozhoujia.crab.exception.InputIllegalException;
import com.xiaozhoujia.crab.exception.InputIsEmptyException;
import com.xiaozhoujia.crab.exception.LoginNameOrPasswordErrorExceprion;
import com.xiaozhoujia.crab.pojo.User;
import com.xiaozhoujia.crab.service.UserService;
import com.xiaozhoujia.crab.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: UserController
 * @Author: zhouzhongli
 * @Date: 2020-09-08 17:17:16
 * @Version: 1.0
 * @Copyright: 南京云昇信息技术有限公司
 **/
@RestController()
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public AjaxResult login(String loginName, String password, HttpServletRequest request){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            User user = userService.login(loginName, password);
            request.getSession().setAttribute("loginUser",user);
            ajaxResult.setCode(AjaxResultCode.SUCCESS);
            ajaxResult.setReturnObj(user);
        } catch (InputIsEmptyException e1) {
            ajaxResult.setCode(AjaxResultCode.ERROR);
            ajaxResult.setMsg(e1.getMessage());
        } catch (LoginNameOrPasswordErrorExceprion e2) {
            ajaxResult.setCode(AjaxResultCode.ERROR);
            ajaxResult.setMsg(e2.getMessage());
        }
        return ajaxResult;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public AjaxResult register(User user) {
        AjaxResult ajaxResult = new AjaxResult();
        try {
            Integer userId = userService.register(user);
            System.out.println("userId=======" + userId);
            ajaxResult.setCode(AjaxResultCode.SUCCESS);
            ajaxResult.setReturnObj(user.getUserId());
        } catch (InputIsEmptyException e) {
            ajaxResult.setMsg(e.getMessage());
            ajaxResult.setCode(AjaxResultCode.ERROR);
        } catch (InputIllegalException e) {
            ajaxResult.setMsg(e.getMessage());
            ajaxResult.setCode(AjaxResultCode.ERROR);
        }
        return ajaxResult;
    }


}
