package com.wolfcompany.springbootrestapidemo.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    
    // 타겟 메소드 실행 전후
    // * : 모든
    // (..) : 매개변수 무관
    @Around("execution(* com.wolfcompany.springbootrestapidemo.controller.UserController.*(..))")
    public Object setLog(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("실행 시작: "
                + pjp.getSignature().getDeclaringTypeName() + "."
                + pjp.getSignature().getName());

        long startMillis = System.currentTimeMillis();
        
        Object result = pjp.proceed();  // 타겟 메소드 수행
        
        long executionMillis = System.currentTimeMillis() - startMillis;
        System.out.println("실행 완료: " + executionMillis + "밀리초 소요됨 :"
                + pjp.getSignature().getDeclaringTypeName()
                + pjp.getSignature().getName());

        return result;
    }

    // 타겟 메소드 실행 전
    // service.*.get*(..) : service 폴더의 모든 class 내 get으로 시작하는 이름을 가진 메소드들
    @Before("execution(* com.wolfcompany.springbootrestapidemo.service.*.get*(..))")
    public void logger() {
        System.out.println("logger test before service methods");
    }
}
