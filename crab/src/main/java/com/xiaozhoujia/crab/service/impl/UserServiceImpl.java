package com.xiaozhoujia.crab.service.impl;

import com.xiaozhoujia.crab.dao.UserDao;
import com.xiaozhoujia.crab.exception.InputIllegalException;
import com.xiaozhoujia.crab.exception.InputIsEmptyException;
import com.xiaozhoujia.crab.exception.LoginNameOrPasswordErrorExceprion;
import com.xiaozhoujia.crab.pojo.User;
import com.xiaozhoujia.crab.service.UserService;
import com.xiaozhoujia.crab.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.List;

/**
 * @ClassName: UserServiceImpl
 * @Author: zhouzhongli
 * @Date: 2020-09-08 17:19:21
 * @Version: 1.0
 * @Copyright: 南京云昇信息技术有限公司
 **/
@Service
@Component
public class UserServiceImpl  implements UserService {
    @Autowired
    UserDao userMapper;

    @Transactional(readOnly = true, rollbackFor = Exception.class, propagation = Propagation.SUPPORTS)
    @Override
    public User login(String loginName, String password) throws InputIsEmptyException, LoginNameOrPasswordErrorExceprion {
        if (StringUtil.isBlank(loginName)) {
            throw new InputIsEmptyException("请输入登录名!");
        }
        if (StringUtil.isBlank(password)) {
            throw new InputIsEmptyException("请输入密码!");
        }
        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        List<User> list = userMapper.selectByLoginNameAndPassword(loginName, md5Password);
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
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        Integer userId = userMapper.insertUser(user);
        return userId;
    }
}
