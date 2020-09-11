package com.xiaozhoujia.crab.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: AjaxResult
 * @Description: TODO
 * @Author: zhouzhongli
 * @Date: 2019-11-04 16:44:30
 * @Version: 1.0
 * @Copyright: 中国电信集团系统集成有限责任公司
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AjaxResult {
    private String code;
    private String msg;
    private Object returnObj;
}
