package com.abc.pbm.racassignmentpoll.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class ClassTwo {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String crimApiBaseUrl = "http://localhost:8081/api/";

    @Retryable(maxAttemptsExpression = "2", backoff = @Backoff(delayExpression = "5000"))
    public ResponseEntity startSecondMethod(String invEligDt, String runType) {
        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("INV_ELIG_DT", invEligDt);
        reqBody.put("RUNTYPE", runType);

        ResponseEntity responseEntity = restTemplate.postForEntity(crimApiBaseUrl + "start",
                reqBody,
                null,
                Collections.EMPTY_MAP);
        return responseEntity;
    }

    @Recover
    public void recover(Exception error, String invEligDt, String runType){
        // Some action.
        log.info("INside recovery");
    }
}
