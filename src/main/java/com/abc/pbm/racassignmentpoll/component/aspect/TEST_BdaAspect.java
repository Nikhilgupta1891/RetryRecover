package com.abc.pbm.racassignmentpoll.component.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class TEST_BdaAspect {

    @Pointcut("execution(* com.abc.pbm.racassignmentpoll.services.ClassOne.triggerJob(..))")
    public void bdaTriggerJobs() {
    }

    @Pointcut("execution(* com.abc.pbm.racassignmentpoll.services.ClassOne.recover(..))")
    public void bdaRecoverJobs() {
    }

    @Before("bdaTriggerJobs()")
    public void beforeBdaTriggerJobsAdvice(JoinPoint joinPoint) {
        log.info("log beforeBdaTriggerJobsAdvice");
    }

    @AfterReturning("bdaTriggerJobs()")
    public void afterBdaTriggerJobsAdvice(JoinPoint joinPoint) {
        log.info("log afterBdaTriggerJobsAdvice");
    }

    @AfterThrowing(value = "bdaTriggerJobs()", throwing = "error")
    public void onErrorBdaTriggerJobsAdvice(JoinPoint joinPoint, Throwable error) {
        log.info("log onErrorBdaTriggerJobsAdvice");
    }

    @Before("bdaRecoverJobs()")
    public void beforeBdaRecoverJobsAdvice(JoinPoint joinPoint) {
        log.info("log beforeBdaRecoverJobsAdvice");
    }

    @AfterThrowing(value = "bdaRecoverJobs()", throwing = "error")
    public void onErrorRecoveryBdaTriggerJobsAdvice(JoinPoint joinPoint, Throwable error) {
        log.info("log onErrorRecoveryBdaTriggerJobsAdvice");
    }

    @AfterReturning("bdaRecoverJobs()")
    public void afterRecoveryBdaTriggerJobsAdvice(JoinPoint joinPoint) {
        log.info("log afterRecoveryBdaTriggerJobsAdvice");
    }
}