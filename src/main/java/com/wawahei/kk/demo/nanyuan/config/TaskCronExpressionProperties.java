package com.wawahei.kk.demo.nanyuan.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @description:
 * @author: yanghailang
 * @create: 2021-05-21 17:06
 **/
@Data
@Configuration
@ConfigurationProperties(prefix = "task.cron")
public class TaskCronExpressionProperties {

    private Map<String, String> expression;
}