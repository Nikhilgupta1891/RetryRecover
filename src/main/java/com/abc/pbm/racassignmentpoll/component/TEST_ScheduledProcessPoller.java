package com.abc.pbm.racassignmentpoll.component;

import com.abc.pbm.racassignmentpoll.services.TEST_BdaProcessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TEST_ScheduledProcessPoller {

    private final TEST_BdaProcessService bdaProcessService;

    public TEST_ScheduledProcessPoller(TEST_BdaProcessService bdaProcessService) {
        this.bdaProcessService = bdaProcessService;
    }

    @Scheduled(cron = "0 0/2 * * * *")
    public void scheduleTaskWithFixedDelay() {
        try {
            log.info("scheduleTaskWithFixedDelay");
            this.triggerBdaJobs(true);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    protected void triggerBdaJobs(boolean isDaily) throws Exception {
        log.info("triggerBdaJobs");
        this.bdaProcessService.triggerJob(isDaily, 1L);
    }
}