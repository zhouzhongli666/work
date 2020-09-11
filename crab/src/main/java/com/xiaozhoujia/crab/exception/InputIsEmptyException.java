package com.xiaozhoujia.crab.exception;

/**
 * @ClassName: InputIsEmptyException
 * @Description: TODO
 * @Author: zhouzhongli
 * @Date: 2019-11-04 16:56:29
 * @Version: 1.0
 * @Copyright: 中国电信集团系统集成有限责任公司
 **/
public class InputIsEmptyException extends Exception {

    public InputIsEmptyException() {
    }

    public InputIsEmptyException(String message) {
        super(message);
    }

    public InputIsEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public InputIsEmptyException(Throwable cause) {
        super(cause);
    }

    public InputIsEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
