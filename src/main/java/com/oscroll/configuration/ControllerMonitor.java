package com.oscroll.configuration;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

//@Aspect
//@Component
//public class ControllerMonitor {
//
//    @Around("execution(* com.oscroll.domain.*.UserController.*(..))")
//    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
//
//        System.out.println("time aspect start");
//
//        Object[] args = pjp.getArgs();
//        for (Object arg : args) {
//            System.out.println("arg is "+arg);
//        }
//
//        long start = new Date().getTime();
//
//        Object object = pjp.proceed();
//
//        System.out.println("time aspect 耗时:"+ (new Date().getTime() - start));
//
//        System.out.println("time aspect end");
//
//        return object;
//    }
//
//}
