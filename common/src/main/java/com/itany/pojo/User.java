package com.itany.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName: User
 * @Description: TODO
 * @Author: zhouzhongli
 * @Date: 2019-11-04 15:11:10
 * @Version: 1.0
 * @Copyright: 中国电信集团系统集成有限责任公司
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private Long userId;
    private String userName;
    private String loginName;
    private String rePassword;
    private String password;
    private String age;
    private String sex;
}
