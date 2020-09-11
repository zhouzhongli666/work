package com.xiaozhoujia.crab.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName: User
 * @Author: zhouzhongli
 * @Date: 2020-09-08 17:27:59
 * @Version: 1.0
 * @Copyright: 南京云昇信息技术有限公司
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User implements Serializable {
        private Long userId;
        private String userName;
        private String loginName;
        private String rePassword;
        private String password;
        private String age;
        private String sex;
}
