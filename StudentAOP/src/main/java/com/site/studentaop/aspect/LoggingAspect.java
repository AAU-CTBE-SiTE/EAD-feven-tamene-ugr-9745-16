package com.site.studentaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* com.site.studentaop.service.StudentService.*(..))")
    public void studentServiceMethods() {
    }

    @Before("studentServiceMethods()")
    public void beforeAdvice(JoinPoint joinPoint) {

        System.out.println("\n[AOP BEFORE] Before method execution: "
                + joinPoint.getSignature().getName() + "()");
    }

    @After("studentServiceMethods()")
    public void afterAdvice() {

        System.out.println("\n[AOP AFTER RETURNING] Method execution completed.");
    }

    @AfterReturning(
            pointcut = "studentServiceMethods()",
            returning = "result"
    )
    public void afterReturningAdvice(Object result) {

        System.out.println("\n[AOP AFTER] Method executed successfully.");
    }


    @AfterThrowing(
            pointcut = "studentServiceMethods()",
            throwing = "exception"
    )
    public void afterThrowingAdvice(Exception exception) {

        System.out.println("\n Exception occurred: "
                + exception.getMessage());
    }


    @Around("studentServiceMethods()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint)
            throws Throwable {

        long startTime = System.currentTimeMillis();

        try {

            return joinPoint.proceed();

        } finally {

            long endTime = System.currentTimeMillis();

            System.out.println("\n[AOP AROUND] Execution Time: "
                    + (endTime - startTime) + " ms");
        }
    }
}