package com.xiu.followdouban.commonservice.annonation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * author   xieqx
 * createTime  2018/7/20
 * desc 记录花费时间注解
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TimeCostAnnotation {
    String value() default "";
}
