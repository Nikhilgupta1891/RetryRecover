package com.abc.pbm.racassignmentpoll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.TimeZone;

@EnableRetry
@EnableScheduling
@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class MyApplication {

    public static void main(String[] args) {
        final String UTC = "UTC";
        TimeZone.setDefault(TimeZone.getTimeZone(UTC));
        SpringApplication.run(MyApplication.class, args);
    }

}
