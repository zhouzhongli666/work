package com.itany.userService;

import com.itany.exception.InputIllegalException;
import com.itany.exception.InputIsEmptyException;
import com.itany.exception.LoginNameOrPasswordErrorExceprion;
import com.itany.pojo.User;

public interface UserService {
    User login(String loginName, String password) throws InputIsEmptyException, LoginNameOrPasswordErrorExceprion;

    Integer register(User user) throws InputIsEmptyException, InputIllegalException;
}
