package com.itany.exception;

/**
 * @ClassName: LoginNameOrPasswordErrorExceprion
 * @Description: TODO
 * @Author: zhouzhongli
 * @Date: 2019-11-04 17:17:47
 * @Version: 1.0
 * @Copyright: 中国电信集团系统集成有限责任公司
 **/
public class LoginNameOrPasswordErrorExceprion extends Exception {
    public LoginNameOrPasswordErrorExceprion() {
    }

    public LoginNameOrPasswordErrorExceprion(String message) {
        super(message);
    }

    public LoginNameOrPasswordErrorExceprion(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginNameOrPasswordErrorExceprion(Throwable cause) {
        super(cause);
    }

    public LoginNameOrPasswordErrorExceprion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
