package com.june.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.lang.module.ModuleFinder;
import java.lang.reflect.Modifier;

@Component
@Aspect
public class LogAdivce {

    @Before("execution(* com.june.service..*.*(..))")
    public void start(JoinPoint joinPoint) {
        String simpleName = joinPoint.getTarget().getClass().getSimpleName();
        Signature signature = joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        int modifiers = joinPoint.getSignature().getModifiers();
        System.out.println("方法类的信息"+simpleName+"方法名"+signature+"参数列表"+args+"获取权限"+Modifier.toString(modifiers));
        System.out.println("方式开始了");
    }

    @After("execution(* com.june.service..*.*(..))")
    public void after(){
        System.out.println("方法结束了");
    }

    @AfterThrowing("execution(* com.june.service..*.*(..))")
    public void error(){
        System.out.println("方法报错了");
    }
}
