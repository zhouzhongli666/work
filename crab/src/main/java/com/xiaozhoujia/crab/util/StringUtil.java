package com.xiaozhoujia.crab.util;

/**
 * @ClassName: StringUtil
 * @Description: TODO
 * @Author: zhouzhongli
 * @Date: 2019-11-04 16:51:02
 * @Version: 1.0
 * @Copyright: 中国电信集团系统集成有限责任公司
 **/
public class StringUtil {
    public static boolean isEmpty(String s) {
        if (null == s || s.equals("")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isBlank(String str) {
        int strLen;
        if (str != null && (strLen = str.length()) != 0) {
            for (int i = 0; i < strLen; ++i) {
                // 判断字符是否为空格、制表符、tab
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return true;
        }

    }
}
