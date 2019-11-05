package com.itany.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName: MyConfig
 * @Description: TODO
 * @Author: zhouzhongli
 * @Date: 2019-11-04 17:29:00
 * @Version: 1.0
 * @Copyright: 中国电信集团系统集成有限责任公司
 **/
@Configuration
public class MyConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/showLogin").setViewName("login");
        registry.addViewController("/showMain").setViewName("index");
    }
}
