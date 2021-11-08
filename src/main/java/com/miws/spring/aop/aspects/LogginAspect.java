package com.miws.spring.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogginAspect {
    @Before("execution(public void getBook())")
    public void BeforeGetBookAdvice(){
        System.out.println("BeforeGetBookAdvice: Попытка получить книгу");
    }
}
