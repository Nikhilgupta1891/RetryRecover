package com.abc.pbm.racassignmentpoll.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ClassOne {

    @Retryable(maxAttemptsExpression = "3", backoff = @Backoff(delayExpression = "1000"))
    public void triggerJob(boolean isDaily, long eventId) {
        // Some code here that can throw exceptions.
        log.info("triggerJob");
        throw new RuntimeException("triggerJob");
    }

    @Recover
    public void recover(boolean isDaily, long eventId) {
        log.info("recover");
        // Some code here that can throw exceptions.
        throw new RuntimeException();
    }
}
