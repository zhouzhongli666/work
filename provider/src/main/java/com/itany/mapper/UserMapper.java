package com.itany.mapper;

import com.itany.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    List<User> selectByLoginNameAndPassword(@Param("loginName") String loginName, @Param("password") String password);
}
