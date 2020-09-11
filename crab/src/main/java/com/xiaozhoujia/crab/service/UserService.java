package com.xiaozhoujia.crab.service;

import com.xiaozhoujia.crab.exception.InputIllegalException;
import com.xiaozhoujia.crab.exception.InputIsEmptyException;
import com.xiaozhoujia.crab.exception.LoginNameOrPasswordErrorExceprion;
import com.xiaozhoujia.crab.pojo.User;

public interface UserService {
    User login(String loginName, String password) throws InputIsEmptyException, LoginNameOrPasswordErrorExceprion;

    Integer register(User user) throws InputIsEmptyException, InputIllegalException;
}
