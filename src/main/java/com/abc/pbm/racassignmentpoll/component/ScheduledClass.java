package com.abc.pbm.racassignmentpoll.component;

import com.abc.pbm.racassignmentpoll.services.ClassTwo;
import com.abc.pbm.racassignmentpoll.services.ClassOne;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ScheduledClass {

    private final ClassOne classOne;
    private final ClassTwo classTwo;

    public ScheduledClass(ClassOne classOne, ClassTwo classTwo) {
        this.classOne = classOne;
        this.classTwo = classTwo;
    }

    @Scheduled(cron = "0 0/2 * * * *")
    public void scheduleTaskWithFixedDelay() {
        try {
            log.info("scheduleTaskWithFixedDelay");
            this.triggerSecondJob(true);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    protected void triggerSecondJob(boolean isDaily) throws Exception {
        log.info("triggerSecondJob");
        this.classTwo.startSecondMethod("02-02-2001", "Runtype_now");
    }
}