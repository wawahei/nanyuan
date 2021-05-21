package com.wawahei.kk.demo.nanyuan.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: yanghailang
 * @create: 2021-05-21 17:24
 **/
@Data
@Configuration
@ConfigurationProperties(prefix ="ftp.config" )
public class FtpServerProperties {

    //用户名
    private String username;
    //密码
    private String password;
    //根目录
    private String homeDirectory;
    //服务端口号
    private int port;
}