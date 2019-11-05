package com.itany.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
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
}
