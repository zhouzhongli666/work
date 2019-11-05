package com.itany.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.itany.exception.InputIllegalException;
import com.itany.exception.InputIsEmptyException;
import com.itany.exception.LoginNameOrPasswordErrorExceprion;
import com.itany.mapper.UserMapper;
import com.itany.pojo.User;
import com.itany.userService.UserService;
import com.itany.util.StringUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @ClassName: UserServiceImpl
 * @Description: TODO
 * @Author: zhouzhongli
 * @Date: 2019-11-04 16:43:02
 * @Version: 1.0
 * @Copyright: 中国电信集团系统集成有限责任公司
 **/
@Service
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Transactional(readOnly = true, rollbackFor = Exception.class, propagation = Propagation.SUPPORTS)
    @Override
    public User login(String loginName, String password) throws InputIsEmptyException, LoginNameOrPasswordErrorExceprion {
        if (StringUtil.isBlank(loginName)) {
            throw new InputIsEmptyException("请输入登录名!");
        }
        if (StringUtil.isBlank(password)) {
            throw new InputIsEmptyException("请输入密码!");
        }
        String md5Password = DigestUtils.md5Hex(password);
        List<User> list = userMapper.selectByLoginNameAndPassword(loginName, password);
        if (null == list || list.size() == 0) {
            throw new LoginNameOrPasswordErrorExceprion("登录名或密码错误");
        }
        return list.get(0);
    }

    @Override
    public Integer register(User user) throws InputIsEmptyException, InputIllegalException {
        if (user == null) {
            throw new InputIsEmptyException("请输入注册信息!");
        }
        if (StringUtil.isBlank(user.getLoginName())) {
            throw new InputIsEmptyException("注册需输入登录名！");
        }
        if (StringUtil.isBlank(user.getUserName())) {
            throw new InputIsEmptyException("注册需输入用户名！");
        }
        if (StringUtil.isBlank(user.getPassword())) {
            throw new InputIsEmptyException("请输入密码！");
        }
        if (StringUtil.isBlank(user.getRePassword())) {
            throw new InputIsEmptyException("请确认密码！");
        }
        if (!user.getPassword().equals(user.getRePassword())) {
            throw new InputIsEmptyException("两次密码不一致，请重新输入！");
        }
        if (StringUtil.isBlank(user.getAge())) {
            throw new InputIsEmptyException("请输入年龄！");
        }
        Double age = Double.valueOf(user.getAge());
        if (age == 0 || age > 120) {
            throw new InputIllegalException("请输入合适的年龄！");
        }
        if (StringUtil.isBlank(user.getSex())) {
            throw new InputIsEmptyException("请选择性别！");
        }
        Integer userId = userMapper.insertUser(user);
        return userId;
    }
}
