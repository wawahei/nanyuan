package com.wawahei.kk.demo.nanyuan.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: yanghailang
 * @create: 2021-05-21 14:49
 **/
@Data
@Configuration
@ConfigurationProperties(prefix ="aliyun.oss" )
public class OssProperties {

    private String endpoint;
    private String keyId;
    private String keySecret;
    private String bucketName;
}