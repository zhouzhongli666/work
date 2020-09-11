package com.xiaozhoujia.crab.dao;

import com.xiaozhoujia.crab.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    List<User> selectByLoginNameAndPassword(@Param("loginName") String loginName, @Param("password") String password);

    Integer insertUser(User user);
}
