package cn.duckflew.anno;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME) //确定当前注解在什么时候生效  Runtime表示在运行时生效  Source在源码中有效 Class表示在字节码中有效
public @interface MySwaggerAnnotation
{
    String value() default "";
}
