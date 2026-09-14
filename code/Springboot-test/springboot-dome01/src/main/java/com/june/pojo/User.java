package com.june.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/*
* 读取配置的方式1:
*       @Value:直接在属性上添加即可
*               @Value(key必须写全了)
*               @Value只能读取单个值
* 批量配置读取
*       @ConfigurationProperties(prefix = "前缀")
*       属性名----->key
* */
@Data
@Component
@ConfigurationProperties(prefix = "spring.datasource")
public class User {
//    @Value("${cjj.root.username}")
    private String username;
//    @Value("${cjj.root.password}")
    private String password;
//    @Value("${cjj.root.gfs}")
    private String url;

    private String driver;

    private List<String> names;


}
