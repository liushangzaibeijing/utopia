package com.xiu.utopia.annonation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 缓存注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Cache {
    /**
     * 对应的key
     * @return
     */
    @AliasFor("key")
    String name() default "";

    /**
     * 对应的key 的值
     * @return
     */
    @AliasFor("name")
    String key() default "";

    /**
     * 缓存描述
     * @return
     */
    String desc() default "";

    /**
     * key的生成策略
     * @return 对应策略生成的key
     */
    String keyGenerator() default "";

    /**
     * 返回值的参数
     * @return 对应策略生成的key
     */
    Class returnClass() default Object.class;
}
