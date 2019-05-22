package com.xiu.utopia.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface AuthorityAnnotation {
    /**
     * 权限编码
     */
    public String authCode() default "";

    /**
     * 权限名称
     */
    public String authName() default  "";

    /**
     * 权限描述
     */
    public String authDesc() default  "";


}
