package com.yao.vuedemo.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {
    @Scheduled(cron = "1/10 * * * * ?")
    public void second10(){
        System.out.println("10秒执行一次");
    }
}
