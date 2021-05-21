package com.wawahei.kk.demo.nanyuan.task;

import org.quartz.DisallowConcurrentExecution;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description:
 * @author: yanghailang
 * @create: 2021-05-21 17:02
 **/
@DisallowConcurrentExecution
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ScheduledJob {
    String name();
    String group() default "DEFAULT_GROUP";
}
