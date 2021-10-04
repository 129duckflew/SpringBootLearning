package cn.duckflew.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@Aspect
public class BookAspect
{
//    @Before(value = "execution(* cn.duckflew.service.*.*(..))")
//    public void before()
//    {
//        System.out.println("前置Aop================================");
//    }

    @Around(value = "execution(* cn.duckflew.service.*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable
    {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args)
        {
            System.out.println(arg.toString());
        }
        Signature signature = joinPoint.getSignature();
        System.out.println(signature);
        System.out.println(joinPoint.getTarget());
        System.out.println(joinPoint.getThis());
        Object proceed = joinPoint.proceed();
        return proceed;
    }

}
