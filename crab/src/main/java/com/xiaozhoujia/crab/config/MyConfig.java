package com.xiaozhoujia.crab.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName: MyConfig
 * @Author: zhouzhongli
 * @Date: 2020-09-08 17:18:10
 * @Version: 1.0
 * @Copyright: 南京云昇信息技术有限公司
 **/
@Configuration
public class MyConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/showLogin").setViewName("/login");
        registry.addViewController("/showMain").setViewName("/index");
        registry.addViewController("/showRegister").setViewName("/register");
    }

}
