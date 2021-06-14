package com.abc.pbm.racassignmentpoll.component.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ApcAspect {

    @Pointcut("execution(*  com.abc.pbm.racassignmentpoll.services.ClassTwo.startSecondMethod(..))")
    public void startCrimForApcJobs() {
    }

    @Before("startCrimForApcJobs()")
    public void beforeApcApiCallAdvice(JoinPoint joinPoint) {
        log.info("Before");
    }

    @AfterThrowing(value = "startCrimForApcJobs()", throwing = "error")
    public void onErrorApcApiCallAdvice(JoinPoint joinPoint, Throwable error) {
        log.info("After");
    }


}
