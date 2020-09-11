package com.xiaozhoujia.crab.exception;

/**
 * @ClassName: InputIllegalException
 * @Description: TODO
 * @Author: zhouzhongli
 * @Date: 2019-11-05 13:38:27
 * @Version: 1.0
 * @Copyright: 中国电信集团系统集成有限责任公司
 **/
public class InputIllegalException extends Exception {
    public InputIllegalException() {
    }

    public InputIllegalException(String message) {
        super(message);
    }

    public InputIllegalException(String message, Throwable cause) {
        super(message, cause);
    }

    public InputIllegalException(Throwable cause) {
        super(cause);
    }

    public InputIllegalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
